<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>
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
<script type="text/javascript" src="../../../../js/pos/category/category.js"></script>
</head>
<body>
<div data-role="page" id="demo-page" data-url="">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>간편포스</h1>
	</div>
	<div data-role="content">
		<div class="menu_tab">
			<ul>
				<li><a href="/pos/category/categoryManage.do" data-ajax="false">카테고리 편집</a></li>
				<li><a href="/pos/category/categoryMenuManage.do?categoryid=1" data-ajax="false" class="on">메뉴추가</a></li>
				<li><a href="/pos/category/categoryPointManage.do?categoryid=1" data-ajax="false">포인트/할인율 설정</a></li>
			</ul>
		</div>

		<div class="food_list">
			<div class="tab">
				<ul>
				<c:forEach var="category" items="${categoryList}" varStatus="status">
				    <c:if test="${category.isetc == 'N'}">
					   <li id=""><a href="/pos/category/categoryMenuManage.do?categoryid=${status.count}" data-ajax="false">${category.name}</a></li>
					</c:if>
					<!-- <li id="id_menu_sub2"><a href="/pos/category/categoryMenuManage.do?categoryid=2" data-ajax="false">식사류</a></li>
					<li id="id_menu_sub3" ><a href="/pos/category/categoryMenuManage.do?categoryid=3" data-ajax="false">주류</a></li>-->
					</c:forEach>
					    <li id="id_menu_sub4"><a href="/pos/category/categoryMenuManage.do?categoryid=4" data-ajax="false">음료류</a></li>
					    <li id="id_menu_sub5"><a href="#others_menu" data-rel="popup" data-position-to="window" data-transition="pop">기타</a></li>
				</ul>
			</div>
			<div class="price_other">
				<input type="checkbox" id="pr_other" class="class_menu_check" name="name_memu_add"/><label for="pr_other">매장/배달/포장 금액 각각 다름</label>
				<span class="ps">금액(천단위)</span>
			</div>
			<!--s: 입력목록 -->
			<div class="write" id="id_short_menu">
				<table id="id_tbodylist" class="class_tbodylist">
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="30%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col"></th>
							<th class="class_menu_tab_top" scope="col">요리류 메뉴</th>
							<th scope="col">금액</th>
							<th scope="col">숨김</th>
						</tr>
					</thead>
					<tbody>
					    <c:forEach var="categoryMenu" items="${categoryMenuList}">
							<tr>
								<td><label><input type="checkbox" id="" /></label></td>
								<td><input type="text" id="" data-role="none" value="${categoryMenu.name}"/></td>
								<td><input type="text" id="" data-role="none" value="${categoryMenu.storeprice}"/></td>
								<td><label><input type="checkbox" id="" /></label></td>
							</tr>
						</c:forEach>						
					</tbody>
				</table>
			</div>
			<!--e: 입력목록 -->
			<!--s: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="write" id="id_long_menu" style="display:none">
				<table id="id_tbodylist2" class="class_tbodylist">
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="12%" />
						<col width="12%" />
						<col width="12%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col"></th>
							<th class="class_menu_tab_top" scope="col">요리류 메뉴</th>
							<th scope="col">매장</th>
							<th scope="col">배달</th>
							<th scope="col">포장</th>
							<th scope="col">숨김</th>
						</tr>
					</thead>
					<tbody >
					    <c:forEach var="categoryMenu" items="${categoryMenuList}">
							<tr>
								<td><label><input type="checkbox" id="" /></label></td>
								<td><input type="text" id="" data-role="none" value="${categoryMenu.name}"/></td>
								<td><input type="text" id="" data-role="none" value="${categoryMenu.storeprice}"/></td>
								<td><input type="text" id="" data-role="none" value="${categoryMenu.deliveryprice}"/></td>
								<td><input type="text" id="" data-role="none" value="${categoryMenu.takeoutprice}"/></td>
								<td><label><input type="checkbox" id="" /></label></td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
			<!--e: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="control">
				<a href="#" class="btn_01" title="위로"><i class="up"></i></a><a href="#" class="btn_01" title="아래로"><i class="down"></i></a><a href="#" id="id_menu_add_row" class="btn_02">추가</a><a href="#" class="btn_02">삭제</a>
				<span>ex) 12,000원 12/ 5백원 0.5</span>
			</div>
			<div class="btn_c tline">
				<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
			</div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<!--<a href="menu_manager01.html" class="pnprev" data-ajax="false"><span>&lt;</span></a> 개발에선 지워주세요 -->
			<p><span>카테고리를 선택하고 메뉴와 금액을 입력하세요.</span></p>
			<!--<a href="menu_manager03.html" class="pnnext" data-ajax="false"><span>&gt;</span></a> 개발에선 지워주세요 -->
		</div>
	</div>

	<!-- s: 기타 팝업 -->
	<div data-role="popup" id="others_menu" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>기타메뉴 입력, 편집</h1>
			<a href="#" data-rel="back" data-role="none" id="id_etc_menu_close" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="menu_list">
				<ul>
					<li><input type="radio" id="otherL_1" name="otherL" value="1" class="class_menu_pop"/><label for="otherL_1">점심특선</label></li>
					<c:forEach var="category" items="${categoryList}" varStatus="status">
				    <c:if test="${category.isetc == 'Y'}">
						<li><input type="radio" id="otherL_${status.count-2}" name="otherL" value="${status.count-2}" class="class_menu_pop"/><label for="otherL_${status.count-2}">${category.name}</label></li>
						
					</c:if>
					</c:forEach>
					<li><input type="radio" id="otherL_5" name="otherL" value="5" class="class_menu_pop"/><label for="otherL_5">서비스</label></li>
				</ul>
			</div>
		</div>
	</div>
	<!--e: 기타 팝업 -->

</div>
</body>
</html> 