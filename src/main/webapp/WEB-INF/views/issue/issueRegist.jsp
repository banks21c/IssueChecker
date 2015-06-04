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
				if($("#type").val() == ""){
					alert("유형을 선택하여 주세요.");
					return;
				}
				if($("#state").val() == ""){
					alert("상태를 선택하여 주세요.");
					return;
				}

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
								document.location.href="/issue/issueList.do";
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
	<h1>이슈 등록</h1>
	<form id="issueForm" method="post" action="/issue/saveIssue.do">
		<input type="hidden" name="currentChargePersonId" value="" />
		<table border="1">
			<colgroup>
				<col width="100px" />
				<col />
				<col width="100px" />
				<col />
			</colgroup>
			<tr>
				<th><font color="red">*</font>주제</th>
				<td colspan="3"><input type="text" size=79 name="subject" value="" /></td>
			</tr>
			<tr>
				<th><font color="red">*</font>내용</th>
				<td colspan="3"><textarea cols="80" rows="5" name="contents"></textarea></td>
			</tr>
			<tr>
				<th><font color="red">*</font>유형</th>
				<td><select name="type" id="type">
						<option value="">선택</option>
						<option value="0">요건</option>
						<option value="1">버그</option>
						<option value="2">요청</option>
				</select></td>
				<th><font color="red">*</font>상태</th>
				<td><select name="state" id="state">
						<option value="">선택</option>
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
						<option value="">선택</option>
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