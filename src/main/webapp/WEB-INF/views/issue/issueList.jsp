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
		$(document).ready(function() {			
			$("#searchBtn").click(function(e){
				e.preventDefault();
				issueForm.submit();
			});

			$("#viewAll").click(function(e){
				e.preventDefault();
				issueForm.submit();
			});
			
			$("#registBtn").click(function(e){
				e.preventDefault();
				document.location.href="/issue/issueRegist.do";
			});
		});
		</script>
	</head>
	<body>
	<div>
		<div align="left" style="float:left">
			<form id="issueForm" method="get" action="/issue/issueList.do">
				유형 : 
				<select name="type" id="type">
				<option value="">전체</option>
				<option value="0">요건</option>
				<option value="1">버그</option>
				<option value="2">요청</option>
				</select>
				
				상태 : 
				<select name="state" id="state">
				<option value="">전체</option>
				<option value="0">open</option>
				<option value="1">close</option>
				<option value="2">suspend</option>
				<option value="3">solved</option>
				</select>
				
				상태 : 
				<select name="chargePersonId" id="chargePersonId">
				<option value="">전체</option>
				<option value="0">open</option>
				<option value="1">close</option>
				<option value="2">suspend</option>
				<option value="3">solved</option>
				</select>
				
				담당자 :
				<select name="chargePersonId">
						<c:forEach items="${chargePersonList}" var="chargePerson">
							<c:if test="${chargePerson.USERID == registerId}">
								<option value="${chargePerson.USERID}" selected>${chargePerson.USERNAME}</option>
							</c:if>
							<c:if test="${chargePerson.USERID != registerId}">
								<option value="${chargePerson.USERID}">${chargePerson.USERNAME}</option>
							</c:if>
						</c:forEach>
				</select>				
                <input type="button" id="searchBtn" value="조회"/>
                <input type="button" id="registBtn" value="등록"/>
			</form>
		</div>
		<div style="padding-left:450px">
		&nbsp;
		</div>
	</div>
	<br/>		
	    <table border="1">
	    <colgroup>
	    <col width="5%"/>
	    <col width="15%"/>
	    <col width="15%"/>
	    <col width="10%"/>
	    <col width="10%"/>
	    <col width="10%"/>
	    <col width="10%"/>
	    <col width="15%"/>
	    </colgroup>
	    <thead>
	    <tr>
	      <th>이슈ID</th>
	      <th>주제</th>
	      <th>내용</th>
	      <th>유형</th>
	      <th>상태</th>
	      <th>등록자</th>
	      <th>담당자</th>
	      <th>등록일</th>
	     </tr>
	     </thead>
	      <c:forEach items="${issueList}" var="issue">
	        <tr>
	          <td><c:out value="${issue.ISSUEID}" /></td>
	          <td><a href="/issue/issueDetail.do?issueId=${issue.ISSUEID}"><c:out value="${issue.SUBJECT}" /></a></td>
	          <td><c:out value="${issue.CONTENTS}" /></td>
	          <td><c:out value="${issue.TYPE}" /></td>
	          <td><c:out value="${issue.STATE}" /></td>
	          <td><c:out value="${issue.REGISTERID}" /></td>
	          <td><c:out value="${issue.CHARGEPERSONID}" /></td>
	          <td><c:out value="${issue.CREATIONDATE}" /></td>
	        </tr>
	      </c:forEach>
	    </table>
	    				
	</body>
</html>