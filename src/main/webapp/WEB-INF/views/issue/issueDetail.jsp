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
		
		<script type="text/javascript" src="/js/jquery.min.js"></script>
		<script>var console = (window.console = window.console || {});</script>
		<script>
		var resultValue = '${resultValue}';
		$(document).ready(function() {
			$("#commentBtn").click(function(e){
				e.preventDefault();
				commentDiv.style.visibility = "visible";
			});			
			$("#saveBtn").click(function(e){
				e.preventDefault();
				issueForm.submit();
			});
			$("#modifyBtn").click(function(e){
				e.preventDefault();
				issueForm.submit();
			});
			$("#saveBtn1").click(function(e){
				e.preventDefault();
				
				var url = "/issue/saveIssue.json";
				var param = $("#issueForm").serialize();
				console.log("param:"+param);
				$.ajax({
					url: url,
					type: 'post',
					data: param,
					dataType: "json",
					error:function (xhr, ajaxOptions, thrownError){
						alert("error");
						alert(thrownError);
						
						if(fail){
							fail();
						}
					},
					success:function(data){
						if(typeof console != 'undefined'){		
							console.log(data);					
						}
						
						if(data.returnJsonVO){
							
							//console.log("data.returnJsonVO.returnVal: " + data.returnJsonVO.returnVal);
							if(data.returnJsonVO.returnCode == 1){
								alert("저장에 성공하였습니다.");
							} else {
								console.log("fail: " + data.returnJsonVO.returnVal);
								alert("저장에 실패하였습니다.");
								
								if(data.returnJsonVO.returnErrorCode == "201"){
									if(confirm("로그인이 필요합니다.\n로그인하러 가시겠습니까?")){
										var forwardUrl = location.pathname;
										var queryString = location.search;
										document.location.href="/login/login.do?forwardUrl="+forwardUrl+queryString;							
									}
									
									return false;
								}						
								
								if(fail){
									fail(data.returnJsonVO);
								} else {
									alert(data.returnJsonVO.message);
								}
							}
						} else {
							alert("error.");
						}
						
					}
				});
				
			});
			$("#gotoListBtn").click(function(e){
				e.preventDefault();
				document.location.href="/issue/issueList.do";
			});
			$("#registBtn").click(function(e){
				e.preventDefault();
				document.location.href="/issue/issueRegist.do";
			});
			
			if(resultValue > 0){
				alert("저장에 성공하였습니다.");
			}
			
			$("#saveCommentBtn").click(function(e){
				e.preventDefault();
				
				var url = "/issue/saveIssueComment.json";
				var param = $("#issueForm").serialize();
				console.log("param:"+param);
				$.ajax({
					url: url,
					type: 'post',
					data: param,
					dataType: "json",
					error:function (xhr, ajaxOptions, thrownError){
						alert("error");
						alert(thrownError);
						
						if(fail){
							fail();
						}
					},
					success:function(data){
						if(typeof console != 'undefined'){		
							console.log(data);					
						}
						
						if(data.returnJsonVO){
							if(data.returnJsonVO.returnCode == 1){
								alert("저장에 성공하였습니다.");
							} else {
								console.log("fail: " + data.returnJsonVO.returnVal);
								alert("저장에 실패하였습니다.");
							}
						} else {
							alert("error.");
						}
						
					}
				});
				
			});			
		});
		
		function saveCommentBtn(){
			var url = "/issue/saveIssueComment.json";
			var param = $("#issueForm").serialize();
			console.log("param:"+param);
			$.ajax({
				url: url,
				type: 'post',
				data: param,
				dataType: "json",
				error:function (xhr, ajaxOptions, thrownError){
					alert("error");
					alert(thrownError);
					
					if(fail){
						fail();
					}
				},
				success:function(data){
					if(typeof console != 'undefined'){		
						console.log(data);					
					}
					
					if(data.returnJsonVO){
						if(data.returnJsonVO.returnCode == 1){
							alert("저장에 성공하였습니다.");
							$('#issueForm').attr('action', '/issue/issueDetail.do');
							$("#issueForm").submit();
						} else {
							console.log("fail: " + data.returnJsonVO.returnVal);
							alert("저장에 실패하였습니다.");
						}
					} else {
						alert("error.");
					}
					
				}
			});
		}
		
		function deleteComment(a,b){
			
			var url = "/issue/deleteIssueComment.json";
			
          	
			var param = "issueId="+a+"&commentId="+b
			console.log("param:"+param);
			$.ajax({
				url: url,
				type: 'post',
				data: param,
				dataType: "json",
				error:function (xhr, ajaxOptions, thrownError){
					alert("error");
					alert(thrownError);
					
					if(fail){
						fail();
					}
				},
				success:function(data){
					if(typeof console != 'undefined'){		
						console.log(data);					
					}
					
					if(data.returnJsonVO){
						if(data.returnJsonVO.returnCode == 1){
							alert("삭제에 성공하였습니다.");
							$('#issueForm').attr('action', '/issue/issueDetail.do');
							$("#issueForm").submit();
						} else {
							console.log("fail: " + data.returnJsonVO.returnVal);
							alert("삭제에 실패하였습니다.");
						}
					} else {
						alert("error.");
					}
					
				}
			});
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
			<i class="fa fa-map-marker"></i>이슈  &gt;  <strong>이슈 상세보기</strong>
		</div>
	</div>			
	<div class="form_wrap">
	<form id="issueForm" method="post" action="/issue/modifyIssue.do">
		<input type="hidden" name="issueId" value="${issueDetail.ISSUEID}" />
		<input type="hidden" name="registerId" value="${issueDetail.REGISTERID}" />
		<input type="hidden" name="chargePersonId" value="${issueDetail.CHARGEPERSONID}" />
		<table>
			<colgroup>
				<col width="100px" />
				<col />
				<col width="100px" />
				<col />
			</colgroup>
			<tr>
				<th>이슈ID</th>
				<td colspan="3"><c:out value="${issueDetail.ISSUEID}" /></td>
			</tr>
			<tr>
				<th>주제</th>
				<td colspan="3">${issueDetail.SUBJECT}"</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
				<textarea cols="80" rows="5" name="contents" readonly>${issueDetail.CONTENTS}</textarea>
				</td>
			</tr>
			<tr>
				<th>유형</th>
				<td><c:out value="${issueDetail.TYPENM}" /></td>
				<th>상태</th>
				<td><c:out value="${issueDetail.STATENM}" />
				</td>
			</tr>
			<tr>
				<th>등록자</th>
				<td><c:out value="${issueDetail.USERNAME}" /></td>
				<th>담당자</th>
				<td>
						<c:forEach items="${chargePersonList}" var="chargePerson">
							<c:if test="${chargePerson.USERID == issueDetail.CHARGEPERSONID}">
								${chargePerson.USERNAME}
							</c:if>
						</c:forEach>
				</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><c:out value="${issueDetail.CREATIONDATE}" /></td>
				<th>수정일</th>
				<td><c:out value="${issueDetail.MODIFICATIONDATE}" /></td>
			</tr>
		</table>
		<br><br>
		<div class="h3_wrap"><h3>댓글목록</h3></div>
	    <table style="border-top: 1px solid gray;">
	    <colgroup>
	    <col/>
	    <col width="20%"/>
	    <col width="20%"/>
	    <col width="5%"/>
	    </colgroup>
	    <thead>
	    <!-- 
	    
	    <tr>
	      <th>COMMENT</th>
	      <th>등록자</th>
	      <th>등록일</th>
	      <th>삭제</th>
	     </tr>
	     -->
	     </thead>
	      <c:forEach items="${commentList}" var="comment">
	        <tr>
	          <td align="center">
	          	<input type="hidden" name="issueId" id="issueId" value="${comment.ISSUEID}"/>
	          	<input type="hidden" name="commentId" id="commentId" value="${comment.COMMENTID}"/>
	          	${comment.COMMENTS}
	          </td>
	          <td align="center">
	          	${comment.USERNAME}
	          </td>
	          <td align="center">
	          	${comment.CREATIONDATE}
	          </td>
	         <td>
	          	<img width="15" height="15" src="/images/ico/ico_delete.png" 
	          	onclick="deleteComment(${comment.ISSUEID},${comment.COMMENTID})" style="cursor:pointer"/>
			  </td>
	        </tr>
	      </c:forEach>
	    </table>
	    <br/>
	    <table style="border-top: 0px;">
		    <tr>
		    	<td>
		    		<textarea name="comment" id="comment" style='min-width:500px;min-height: 50px' placeholder="댓글입력" onfocus="this.placeholder = ''" onblur="this.placeholder = '댓글입력'"></textarea>
					<span class="btn_gray"> 
	               		<a onclick="saveCommentBtn()">저장</a> 
	          		</span> 
	          	</td>
         	</tr>
        </table>
	    
	    <br/><br/>
		<div style="padding-left:250px">

<!-- 			<input type="button" id="registBtn" value="등록"/> -->
<!-- 			<input type="button" id="modifyBtn" value="수정"/> -->
<!-- 			<input type="button" id="gotoListBtn" value="목록"/> -->
<!-- 			<input type="button" id="commentBtn" value="댓글달기"/> -->
			
			<span class="btn_sky"><a id="registBtn">등록</a></span>
			<span class="btn_green"><a id="modifyBtn">수정</a></span>
			<span class="btn_white"><a id="gotoListBtn">목록</a></span>
			<!--span class="btn_green"><a id="commentBtn">댓글달기</a></span-->
			
		</div>
	     <br/><br/>
		<div id="commentDiv" style="visibility:hidden">
		<input type="text" name="comment1" size="80" />
		
<!-- 		<input type="button" name="saveCommentBtn" id="saveCommentBtn" value="저장" /> -->
		
			<span class="btn_gray"> 
               		<a onclick="saveCommentBtn()">저장</a> 
          	</span> 

		</div>
	</form>
	</div>
</div>
</div>
</body>
</html>