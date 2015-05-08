<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
<title>가게노트</title>
<link rel="stylesheet" href="../../../../css/jquery.mobile-1.4.5.css" />
<link rel="stylesheet" href="../../../../css/style.css" />
<script type="text/javascript" src="../../../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../../../js/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="../../../../js/common/common.js"></script>
<script type="text/javascript" src="../../../../js/common/util.js"></script>
<script type="text/javascript" src="../../../../js/pos/menu/menu.js"></script>

</head>
<body>
<div data-role="page" id="category-page" data-url="category-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="/pos/setting/setting.do" class="btn_admin" title="설정" data-role="none" data-ajax="false"></a>
		<h1>간편포스</h1>
	</div>
	<div data-role="content">
		<div class="menu_tab">
			<ul>
				<li><a href="/pos/category/categoryManage.do" data-ajax="false" class="on">카테고리 편집</a></li>
				<c:forEach var="category" items="${categoryList}" varStatus="status">
				<c:if test="${status.first}">
				<li><a href="/pos/category/categoryMenuManage.do?categoryid=${category.CATEGORYID}" data-ajax="false">메뉴추가</a></li>
				</c:if>
				</c:forEach>
				<c:forEach var="category" items="${categoryList}" varStatus="status">
				<c:if test="${status.first}">
				<li><a href="/pos/category/categoryPointManage.do?categoryid=${category.CATEGORYID}" data-ajax="false">포인트/할인율 설정</a></li>
				</c:if>
				</c:forEach>
			</ul>
		</div>       
		<div class="category_list">
			<div class="cate before">
				<h3>Before</h3>
				<div class="cl class_cate_index">
					<ul>
					<c:forEach var="category" items="${categoryList}" varStatus="catestatus">
					    <c:if test="${category.ISETC == 'N'}">
						  <li><a href="#" class="" id="id_cate_main_${catestatus.count}" catename="${category.NAME}" categoryid ="${category.CATEGORYID}" memberid ="${category.MEMBERID}" deviceid ="${category.DEVICEID}" sortorder ="${category.SORTORDER}">${category.NAME}</a></li>
						</c:if>						
					</c:forEach>
					<li><a href="#" id="id_cate_main_5">기타</a></li>
					</ul>
					<div class="btn_c">
						<a href="#" class="btn_01" id="id_cate_up" title="위로"><i class="up"></i></a><a href="#" id="id_cate_down" class="btn_01" title="아래로"><i class="down"></i></a>
					</div>
				</div>
				<div class="cr">
					<ul>
						<c:forEach var="category" items="${categoryList}">
							<c:if test="${category.ISETC == 'Y'}">
							   <li><a href="#">${category.NAME}</a></li>	
							</c:if>					
					    </c:forEach>
					</ul>
				</div>
			</div>
			<form id="categoryForm" name="categoryForm">
			<div class="cate after">
				<h3>After</h3>
				<div class="cl class_cate_index_sub">
					<ul>
					<c:forEach var="category" items="${categoryList}" varStatus="catesubstatus">
					    <c:if test="${category.ISETC == 'N'}">
					    <c:if test="${category.ISEDITABLE == 'Y'}">
						<li><span id="id_cate_sub_${catesubstatus.count}" class="class_cate" memberid ="${category.MEMBERID}" deviceid ="${category.DEVICEID}" sortorder ="${category.SORTORDER}" categoryid ="${category.CATEGORYID}" catename="${category.NAME}" ><input type="text" data-role="none" name="cate_name_${category.CATEGORYID}"/></span></li>
						</c:if>						
						<c:if test="${category.ISEDITABLE == 'N'}">
						<li><span class="disable class_cate" memberid ="${category.MEMBERID}" deviceid ="${category.DEVICEID}" sortorder ="${category.SORTORDER}" categoryid ="${category.CATEGORYID}" catename="${category.NAME}">${category.NAME}</span></li>
						</c:if></c:if>
						</c:forEach>
						
						<li><span class="disable">기타</span></li>
					</ul>
				</div>
				<div class="cr">
					<ul>
						
						<c:forEach var="category" items="${categoryList}">
					    <c:if test="${category.ISETC == 'Y'}">
					        <c:if test="${category.ISEDITABLE == 'N'}"><c:if test="${category.ISSERVICE == 'N'}">
						    <li><span class="disable class_cate" memberid ="${category.MEMBERID}" deviceid ="${category.DEVICEID}" sortorder ="${category.SORTORDER}" categoryid ="${category.CATEGORYID}" catename="${category.NAME}">${category.NAME}</span></li>
						    </c:if></c:if>
						    <c:if test="${category.ISEDITABLE == 'Y'}"><c:if test="${category.ISSERVICE == 'N'}">
							<li><span class="class_cate" catename="${category.NAME}" memberid ="${category.MEMBERID}" deviceid ="${category.DEVICEID}" sortorder ="${category.SORTORDER}" categoryid ="${category.CATEGORYID}"><input type="text" data-role="none" name="cate_name_${category.CATEGORYID}"/></span></li>
							</c:if></c:if>
							<c:if test="${category.ISEDITABLE == 'N'}"><c:if test="${category.ISSERVICE == 'Y'}">
							<li><span class="disable class_cate"  memberid ="${category.MEMBERID}" deviceid ="${category.DEVICEID}" sortorder ="${category.SORTORDER}" categoryid ="${category.CATEGORYID}" catename="${category.NAME}">${category.NAME}</span></li>
							</c:if></c:if>
						</c:if>
						
						</c:forEach>						
						
					</ul>
				</div>
			</div>
			</form>
		</div>
		
		<div class="btn_c tline">
			<a href="#" id="id_cate_save" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<!-- <a href="frequenter_view.html" class="pnprev" data-ajax="false"><span>&lt;</span></a>개발에선 지워주세요 -->
			<p><span>카테고리를 선택하고 메뉴와 금액을 입력하세요.</span></p>
			<!--<a href="menu_manager02.html" class="pnnext" data-ajax="false"><span>&gt;</span></a> 개발에선 지워주세요 -->
		</div>
	</div>	
</div>
</body>
</html> 