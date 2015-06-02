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
	<h1>이슈 등록</h1>
	<form id="issueForm" method="post" action="/issue/saveIssue.do">
		<table border="1">
			<colgroup>
				<col width="100px" />
				<col />
				<col width="100px" />
				<col />
			</colgroup>
			<tr>
				<th>주제</th>
				<td colspan="3"><input type="text" size=79 name="subject" value="" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea cols="80" rows="5" name="contents"></textarea></td>
			</tr>
			<tr>
				<th>유형</th>
				<td><select name="type" id="type">
						<option value="">전체</option>
						<option value="0">요건</option>
						<option value="1">버그</option>
						<option value="2">요청</option>
				</select></td>
				<th>상태</th>
				<td><select name="state" id="state">
						<option value="">전체</option>
						<option value="0">open</option>
						<option value="1">close</option>
						<option value="2">suspend</option>
						<option value="3">solved</option>
				</select></td>
			</tr>
			<tr>
				<th>담당자</th>
				<td colspan="3">
				<select name="chargePersonId">
						<c:forEach items="${chargePersonList}" var="chargePerson">
							<option value="${chargePerson.USERID}">${chargePerson.USERNAME}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
		</table>
	</form>
	    <br/>
		<div style="padding-left:250px">
			<input type="button" id="saveBtn" value="저장"/>
			<input type="button" id="gotoListBtn" value="목록"/>
		</div>
	    				
	</body>
</html>