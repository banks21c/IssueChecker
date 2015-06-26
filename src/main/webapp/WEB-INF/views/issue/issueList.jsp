<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>이슈 목록</title>
		<link rel="stylesheet" type="text/css" href="/css/mystyle.css">
		<link rel="stylesheet" href="/css/style.css">
		<link rel="stylesheet" href="/css/icon.css">
		<script type="text/javascript" src="/js/jquery.min.js"></script>
		<script>var console = (window.console = window.console || {});</script>
		<script>
		$(document).ready(function() {

			$("#searchBtn").click(function(e){
				e.preventDefault();
				$('#crudFlag').val('R');
				issueForm.submit();
			});

			$("#checkAll").click(function(e){
			   if (this.checked) {
					$('.chkbox').each(function(i) {
						this.checked = true;
					});
			   }else{
					$('.chkbox').each(function(i) {
						this.checked = false;
					});					       
			   }
			});

			$("#viewAll").click(function(e){
				e.preventDefault();
				issueForm.submit();
			});
			
			$("#registBtn").click(function(e){
				e.preventDefault();
				document.location.href="/issue/issueRegist.do";
			});

			checkThisIssue = function(issueId,chargePersonId){
				
				$("#issueId").val(issueId);
				var userId = $("#userId").val();
				if(userId != chargePersonId){
					alert("자신이 담당자로 배정된 이슈만 체크 가능합니다.");
					return;
				}
				
				$("#td_"+issueId).html("체크완료");
				$("#td_"+issueId).css("height","19px");

				var url = "/issue/insertUserIssueCheck.json";
				var param = $("#issueForm").serialize();
				param += "&issueId="+issueId;
				console.log("param:"+param);
				$.ajax({
					url: url,
					type: 'post',
					data: param, 
					dataType: "json",
					error:function (xhr, ajaxOptions, thrownError){
						alert("error");
						alert(thrownError);
					},
					success:function(data){
						console.log(data);					
						
						if(data.returnJsonVO){
							console.log("data.returnJsonVO.returnCode :"+data.returnJsonVO.returnCode);
							if(data.returnJsonVO.returnCode == "0"){
								alert("체크 실패");
							} else{
								alert("체크 완료");
							}
						} 
						
					}
				});					
			};
			
			deleteIssue = function(){
				
				var url = "/issue/deleteIssue.json";
				var param = $("#listForm").serialize();

				var checkBoxLength = $('input:checkbox').length;	
				console.log("checkBoxLength:"+checkBoxLength);
				
				//var numberOfChecked = $('input:checkbox:checked').length;
				//console.log("numberOfChecked:"+numberOfChecked);
				
				
				var issueIdList = "";
				$('.chkbox').each(function(i) {
					   if (this.checked) {
						   var checkBoxId = this.id;
						   console.log(this.id);
					       console.log("Checkbox at index " + i + " is checked.");
					       issueIdList += checkBoxId.split("_")[1]+",";
					   }
				});
				if(issueIdList.length > 0){
					issueIdList = issueIdList.substring(0,issueIdList.length -1);
				}
 				param = "issueIdList="+issueIdList;
				$.ajax({
					url: url,
					type: 'post',
					data: param, 
					dataType: "json",
					error:function (xhr, ajaxOptions, thrownError){
						alert("error");
						alert(thrownError);
					},
					success:function(data){
						console.log(data);					
						
						if(data.returnJsonVO){
							//alert(data.returnJsonVO.returnCode);
							alert("삭제성공");
							document.location.href="/issue/issueList.do";

						} 
						
					}
				});					
			};
			
			
			$("#logoutBtn").click(function(e){
				e.preventDefault();
				
				var url = "/login/logout.json";
				$.ajax({
					url: url,
					type: 'post',
					dataType: "json",
					error:function (xhr, ajaxOptions, thrownError){
						
						alert(thrownError);
					},
					success:function(data){
						if(typeof console != 'undefined'){		
							console.log(data);					
						}
						
						if(data.returnJsonVO){
							
							if(data.returnJsonVO.returnObj == "0"){
								alert(data.returnJsonVO.message);
							} else if(data.returnJsonVO.returnObj == "1"){

								alert("로그아웃 되었습니다.");
								document.location.href="/login/login.do";						
							}
						} 
						
					}
				});					
			});
			
			$("#deleteBtn").click(function(e){
				e.preventDefault();
				
				var url = "/issue/deleteIssue.json";
				$.ajax({
					url: url,
					type: 'post',
					dataType: "json",
					error:function (xhr, ajaxOptions, thrownError){
						
						alert(thrownError);
					},
					success:function(data){
						if(typeof console != 'undefined'){		
							console.log(data);					
						}
						
						if(data.returnJsonVO){
							
							if(data.returnJsonVO.returnObj == "0"){
								alert(data.returnJsonVO.message);
							} else if(data.returnJsonVO.returnObj == "1"){

								alert("삭제 되었습니다.");
								document.location.href="/issue/issueList.do";						
							}
						} 
						
					}
				});					
			});
			
			
			
		});
		
		function goToIssueHistory(){
			document.location.href="/issue/issueHistoryList.do";
		}			
		function goToIssueCheckList(){
			document.location.href="/issue/issueCheckList.do";
		}			
		
		</script>
	</head>
	<body>
<div class="wrap">
	<div id="header">
		<h1>Issue Tracker</h1>
		<div class="nav_wrap">
			<div class="util">
				<p class="message"><i class="fa fa-comments"></i>${userNm}님 환영합니다</p>
				<div class="logoutStyle">
			         <a id="logoutBtn">로그아웃</a>
			    </div>
			</div>		
			<div class="nav">
				<ul>
					<li class="current"><a href="#">이슈</a></li>
					<li><a href="/issue/issueHistoryList.do">이슈 히스토리</a></li>
					<li><a href="/issue/issueCheckList.do">이슈 체크 </a></li>
					<li><a href="/member/memberList.do">회원</a></li>
				</ul>
			</div>
		</div>
	</div>
	<br/>
	<div id="contents">
	<div class="page2">
	<div class="location_bar">
		<div class="location">
			<i class="fa fa-map-marker"></i>이슈  &gt;  <strong>이슈 목록</strong>
		</div>
	</div>			
	<div class="form_wrap">
		<div>
			<form id="issueForm" method="get" action="/issue/issueList.do">
			<input type="hidden" name="crudFlag" id="crudFlag"/>
			<input type="hidden" name="userId" id="userId" value="${searchVO.userId}" />
				<span class="searchTitle">유형 :</span> 
				<select name="type" id="type">
				<option value="">전체</option>
				<option value="0" <c:if test="${searchVO.type eq '0'}">selected</c:if>>요건</option>
				<option value="1" <c:if test="${searchVO.type eq '1'}">selected</c:if>>버그</option>
				<option value="2" <c:if test="${searchVO.type eq '2'}">selected</c:if>>요청</option>
				</select>
				
				<span class="searchTitle">상태 :</span> 
				<select name="state" id="state">
				<option value="">전체</option>
				<option value="0" <c:if test="${searchVO.state eq '0'}">selected</c:if>>open</option>
				<option value="1" <c:if test="${searchVO.state eq '1'}">selected</c:if>>close</option>
				<option value="2" <c:if test="${searchVO.state eq '2'}">selected</c:if>>suspend</option>
				<option value="3" <c:if test="${searchVO.state eq '3'}">selected</c:if>>solved</option>
				</select>
				<span class="searchTitle">담당자:</span> 
				<select name="chargePersonId">
					<option value="">전체</option>
						<c:choose>
							<c:when test="${searchVO.crudFlag eq 'R'}">
								<c:forEach items="${chargePersonList}" var="chargePerson">
									<c:choose>
										<c:when test="${chargePerson.USERID == searchVO.chargePersonId}">
											<option value="${chargePerson.USERID}" selected>${chargePerson.USERNAME}</option>
										</c:when>
										<c:otherwise>
											<option value="${chargePerson.USERID}">${chargePerson.USERNAME}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<c:forEach items="${chargePersonList}" var="chargePerson">
									<c:if test="${chargePerson.USERID == registerId}">
										<option value="${chargePerson.USERID}" selected>${chargePerson.USERNAME}</option>
									</c:if>
									<c:if test="${chargePerson.USERID != registerId}">
										<option value="${chargePerson.USERID}">${chargePerson.USERNAME}</option>
									</c:if>
								</c:forEach>							
							</c:otherwise>
							
						</c:choose>
				</select>				
                <!-- <input type="button" id="searchBtn" value="조회"/> -->
      
                	<span class="btn_green">
                		<a id="searchBtn">조회</a>
                	</span>
          
               	
                <!-- <input type="button" id="registBtn" value="등록"/> -->
                
               		<span class="btn_sky">
                		<a id="registBtn">등록</a>
                	</span>
                	
<!--                 <input type="button" id="deleteBtn" value="삭제"/> -->
                
                	<span class="btn_gray">
                		<a onclick="deleteIssue()">삭제</a>
<!--                 		<a  id="deleteBtn" >삭제</a> -->
                	</span>
                	
			</form>
		</div>
	</div>
	<div class="list_wrap">
	<form id="listForm">
	    <table>
	    <colgroup>
	    <col width="3%"/>
	    <col width="5%"/>
	    <col width="15%"/>
	    <col width="15%"/>
	    <col width="10%"/>
	    <col width="10%"/>
	    <col width="10%"/>
	    <col width="10%"/>
	    <col width="10%"/>
	    <col width="10%"/>
	    </colgroup>
	    <thead>
	    <tr>
	      <th><input type="checkbox" name="checkAll" id="checkAll"/></th>
	      <th>이슈ID</th>
	      <th>주제</th>
	      <th>내용</th>
	      <th>유형</th>
	      <th>상태</th>
	      <th>등록자</th>
	      <th>담당자</th>
	      <th>등록일</th>
	      <th>확인</th>
	     </tr>
	     </thead>
	      <c:forEach items="${issueList}" var="issue">
	        <tr>
	          <td align="center">
	        	<input type="checkbox" class="chkbox" name="chk_${issue.ISSUEID}" id="chk_${issue.ISSUEID}"/>
				<input type="hidden" id="issueId" name="issueId" value="${issue.ISSUEID}"/>
	          </td>
	          <td align="center"><c:out value="${issue.ISSUEID}" /></td>
	          <td><a href="/issue/issueDetail.do?issueId=${issue.ISSUEID}"><c:out value="${issue.SUBJECT}" /></a></td>
	          <td><c:out value="${issue.CONTENTS}" /></td>
	          <td align="center"><c:out value="${issue.TYPENM}" /></td>
	          <td align="center"><c:out value="${issue.STATENM}" /></td>
	          <td><c:out value="${issue.REGISTERNM}" /></td>
	          <td><c:out value="${issue.CHARGEPERSONNM}" /></td>
	          <td><c:out value="${issue.CREATIONDATE}" /></td>
	          <td align="center" id="td_${issue.ISSUEID}">
	          	<c:if test="${issue.CHECKSTATUS ne 'Y'}">
				<input type="button" class="chkBtn" onclick="checkThisIssue ('${issue.ISSUEID}','${issue.CHARGEPERSONID}')" value="체크"/>
				</c:if>
	          	<c:if test="${issue.CHECKSTATUS eq 'Y'}">
	          		체크완료
				</c:if>
	          </td>

 					
	        </tr>
	      </c:forEach>
	    </table>
	    </form>
	  </div>
</div>
</div>
</div>
</body>
</html>