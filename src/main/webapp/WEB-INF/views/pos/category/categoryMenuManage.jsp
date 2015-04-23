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
<script type="text/javascript" src="../../../../js/pos/menu/menu.js"></script>
</head>
<body>
<div data-role="page" id="menu-page" data-url="menu-page">
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
				<c:forEach var="category" items="${categoryList}" varStatus="status">
				<c:if test="${status.first}">
				<li><a href="/pos/category/categoryMenuManage.do?categoryid=${category.CATEGORYID}" data-ajax="false" class="on">메뉴추가</a></li>
				</c:if>
				</c:forEach>
				<li><a href="/pos/category/categoryPointManage.do?categoryid=20150420144440.115c265cb64c5329d2cb047f19503b45590" data-ajax="false">포인트/할인율 설정</a></li>
			</ul>
		</div>

		<div class="food_list">
			<div class="tab">
				<ul class="class_category_area">
				<c:forEach var="category" items="${categoryList}" varStatus="status">
				    <c:if test="${category.ISETC == 'N'}">
					   <li value="${status.count}" tabcateid="${category.CATEGORYID}" ><a href="#" data-ajax="false">${category.NAME}</a></li>
					</c:if>
					<!-- <li id="id_menu_sub2"><a href="/pos/category/categoryMenuManage.do?categoryid=2" data-ajax="false">식사류</a></li>
					<li id="id_menu_sub3" ><a href="/pos/category/categoryMenuManage.do?categoryid=3" data-ajax="false">주류</a></li>-->
					</c:forEach>
					    <!-- <li id="id_menu_sub4"><a href="/pos/category/categoryMenuManage.do?categoryid=4" data-ajax="false">음료류</a></li>-->
					    <li id="id_menu_sub5"><a href="#others_menu" data-rel="popup" data-position-to="window" data-transition="pop">기타</a></li>
				</ul>
			</div>
			<div class="price_other">
				<input type="checkbox" id="pr_other" class="class_menu_check" name="name_memu_add"/><label for="pr_other">매장/배달/포장 금액 각각 다름</label>
				<span class="ps">금액(천단위)</span>
			</div>		
			<!--s: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="write" id="id_long_menu">
				<table id="id_tbodylist" class="class_tbodylist">
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col id="id_menu_col_top1" width="30%" />
						<col id="id_menu_col_top2" width="12%" />
						<col id="id_menu_col_top3" width="12%" />
						<col id="id_menu_col_top4" width="12%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col"></th>
							<th class="class_menu_tab_top" scope="col">요리류 메뉴</th>
							<th scope="col" id="id_menu_tab_top1">금액</th>
							<th scope="col" id="id_menu_tab_top2">매장</th>
							<th scope="col" id="id_menu_tab_top3">배달</th>
							<th scope="col" id="id_menu_tab_top4">포장</th>
							<th scope="col">숨김</th>
						</tr>
					</thead>
					<tbody >
					    <c:forEach var="categoryMenu" items="${categoryMenuList}" varStatus="status">
							<tr class="class_menu_main_view" memberid="${categoryMenu.MEMBERID}" deviceid="${categoryMenu.DEVICEID}" categoryid="${categoryMenu.CATEGORYID}" menuid="${categoryMenu.MENUID}" sortorder="${categoryMenu.SORTORDER}" catemenuname="${categoryMenu.NAME}" 
							defaultprice = "${categoryMenu.DEFAULTPRICE}" storeprice = "${categoryMenu.STOREPRICE}" deliveryprice="${categoryMenu.DELIVERYPRICE}" takeoutprice="${categoryMenu.TAKEOUTPRICE}" ishidden="${categoryMenu.ISHIDDEN}" isdeleted="${categoryMenu.ISDELETED}">
								<td><label><input type="checkbox" class="class_menu_check_${status.count}" /></label></td>
								<td><input type="text" class="class_menu_name" data-role="none" value="${categoryMenu.NAME}"/></td>
								<td class="class_menu_defaultprice"><input type="text"  data-role="none" value="${categoryMenu.DEFAULTPRICE}"/></td>
								<td class="class_menu_storeprice"><input type="text"  data-role="none" value="${categoryMenu.STOREPRICE}"/></td>
								<td class="class_menu_deliveryprice"><input type="text"  data-role="none" value="${categoryMenu.DELIVERYPRICE}"/></td>
								<td class="class_menu_takeoutprice" ><input type="text" data-role="none" value="${categoryMenu.TAKEOUTPRICE}"/></td>
								<td><label><input type="checkbox" class="class_menu_hidden_${status.count}" /></label></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!--e: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="control">
				<a href="#" class="btn_01" title="위로"><i class="up"></i></a><a href="#" class="btn_01" title="아래로"><i class="down"></i></a><a href="#" id="id_menu_add_row" class="btn_02">추가</a><a href="#" id="id_menu_delete" class="btn_02">삭제</a>
				<span>ex) 12,000원 12/ 5백원 0.5</span>
			</div>
			<div class="btn_c tline">
				<a href="#" id="id_menu_save" class="btn_blue class_menu_save">저장</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
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
					<c:forEach var="category" items="${categoryList}" varStatus="status">
				    <c:if test="${category.ISETC == 'Y'}">
						<li><input type="radio" id="otherL_${category.SORTORDER}" name="otherL" etccateid="${category.CATEGORYID}" value="${category.SORTORDER}" class="class_menu_pop"/><label for="otherL_${category.SORTORDER}">${category.NAME}</label></li>
						
					</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<!--e: 기타 팝업 -->

</div>
</body>
</html> 