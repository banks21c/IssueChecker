<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>이슈 목목</title>
		<script type="text/javascript" src="/js/jquery.min.js"></script>
		<script>var console = (window.console = window.console || {});</script>
		<script>
		var resultValue = '${resultValue}';
		$(document).ready(function() {			
			$("#saveBtn").click(function(e){
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
		});
		</script>
	</head>
	<body>
	<h1>이슈 수정</h1>
	<form id="issueForm" method="post" action="/issue/saveIssue.do">
		<input type="hidden" name="issueId" value="${issueDetail.ISSUEID}" />
		<input type="hidden" name="registerId" value="${issueDetail.REGISTERID}" />
		<table border="1">
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
				<td colspan="3"><input type="text" name="subject"
					value="${issueDetail.SUBJECT}" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
				<textarea cols="80" rows="5" name="contents">${issueDetail.CONTENTS}</textarea>
				</td>
			</tr>
			<tr>
				<th>유형</th>
				<td><select name="type" id="type">
						<option value="">전체</option>
						<option value="0"
							<c:if test="${issueDetail.TYPE=='0'}">selected</c:if>>요건</option>
						<option value="1"
							<c:if test="${issueDetail.TYPE=='1'}">selected</c:if>>버그</option>
						<option value="2"
							<c:if test="${issueDetail.TYPE=='2'}">selected</c:if>>요청</option>
				</select></td>
				<th>상태</th>
				<td><select name="state" id="state">
						<option value="">전체</option>
						<option value="0"
							<c:if test="${issueDetail.STATE=='0'}">selected</c:if>>open</option>
						<option value="1"
							<c:if test="${issueDetail.STATE=='1'}">selected</c:if>>close</option>
						<option value="2"
							<c:if test="${issueDetail.STATE=='2'}">selected</c:if>>suspend</option>
						<option value="3"
							<c:if test="${issueDetail.STATE=='3'}">selected</c:if>>solved</option>
				</select></td>
			</tr>
			<tr>
				<th>등록자</th>
				<td><c:out value="${issueDetail.REGISTERID}" /></td>
				<th>담당자</th>
				<td><select name="chargePersonId">
						<c:forEach items="${chargePersonList}" var="chargePerson">
							<c:if test="${chargePerson.USERID == issueDetail.CHARGEPERSONID}">
								<option value="${chargePerson.USERID}" selected>${chargePerson.USERNAME}</option>
							</c:if>
							<c:if test="${chargePerson.USERID != issueDetail.CHARGEPERSONID}">
								<option value="${chargePerson.USERID}">${chargePerson.USERNAME}</option>
							</c:if>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>등록일</th>
				<td colspan="3"><c:out value="${issueDetail.CREATIONDATE}" /></td>
			</tr>
		</table>
	</form>
	    <br/>
		<div style="padding-left:250px">
			<input type="button" id="registBtn" value="등록"/>
			<input type="button" id="saveBtn" value="저장"/>
			<input type="button" id="gotoListBtn" value="목록"/>
		</div>
	    				
	</body>
</html>