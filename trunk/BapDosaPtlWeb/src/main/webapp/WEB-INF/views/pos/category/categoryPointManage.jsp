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
<div data-role="page" id="point-page" data-url="point-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="/pos/setting/setting.do" class="btn_admin" title="설정" data-role="none" data-ajax="false"></a>
		<h1>간편포스</h1>
	</div>
	<div data-role="content">
		<div class="menu_tab">
			<ul>
				<li><a href="/pos/category/categoryManage.do" data-ajax="false">카테고리 편집</a></li>
				<c:forEach var="category" items="${categoryList}" varStatus="status">
				<c:if test="${status.first}">
				<li><a href="/pos/category/categoryMenuManage.do?categoryid=${category.CATEGORYID}" data-ajax="false">메뉴추가</a></li>
				</c:if>
				</c:forEach>
				<c:forEach var="category" items="${categoryList}" varStatus="status">
				<c:if test="${status.first}">
				<li><a href="/pos/category/categoryPointManage.do?categoryid=${category.CATEGORYID}" data-ajax="false" class="on">포인트/할인율 설정</a></li>
				</c:if>
				</c:forEach>
			</ul>
		</div>
		<div class="discount_time">
		    <div class="btn_fl"><input type="checkbox" id="pr_other" class="class_point_check" /><label for="pr_other">매장/배달/포장 금액 각각 다름</label></div>
			<div class="btn_fr"><a href="#discount_time" class="btn_02" data-rel="popup" data-position-to="window" data-transition="pop">할인시간대 설정</a></div>
			<!-- <a href="#discount_time" class="btn_02" data-rel="popup" data-position-to="window" data-transition="pop">할인시간대 설정</a>-->
		</div>
		<div class="food_list">
			<div class="tab">
				<ul class="class_category_point_area">
					<c:forEach var="category" items="${categoryList}" varStatus="status">
				    <c:if test="${category.ISETC == 'N'}">
					   <li value="${status.count}" tabpointid="${category.CATEGORYID}" isetc="${category.ISETC}" pointname="${category.NAME}"><a href="#" data-ajax="false">${category.NAME}</a></li>
					</c:if>
					<!-- <li id="id_menu_sub2"><a href="/pos/category/categoryMenuManage.do?categoryid=2" data-ajax="false">식사류</a></li>
					<li id="id_menu_sub3" ><a href="/pos/category/categoryMenuManage.do?categoryid=3" data-ajax="false">주류</a></li>-->
				</c:forEach>
					<li tabpointid="tabpointid5" isetc="Y" ><a href="#others_menu1" data-rel="popup" data-position-to="window" data-transition="pop">기타</a></li>
				</ul>
			</div>
			<div class="price_other">
				<!-- s: 매장/배달/포장 금액 다를경우 나타남 -->
				<div class="p_type" id="id_check_point_dc" style="display:none" >
					<ul>
						<li><a href="#" id="id_point_check_sub" class="active">포인트</a></li>
						<li><a href="#" id="id_dc_check_sub">할인율</a></li>
					</ul>
				</div>
				<!--e: 매장/배달/포장 금액 다를경우 나타남 -->
			</div>
			<!--s: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="write" id="id_long_menu">
				<table id="id_tbodylist" class="class_tbodylist">
					<colgroup>
						<col width="*" />
						<col id="id_point_col_top1" width="20%" />
						<col id="id_point_col_top2" width="20%" />
						<col id="id_point_col_top3" width="14%" />
						<col id="id_point_col_top4" width="14%" />
						<col id="id_point_col_top5" width="14%" />
					</colgroup>
					<thead>
						<tr>
							<th class="class_point_tab_top" scope="col">요리류 메뉴</th>
							<th scope="col" id="id_point_tab_top1">포인트</th>
							<th scope="col" id="id_point_tab_top2">할인율</th>
							<th scope="col" id="id_point_tab_top3">매장</th>
							<th scope="col" id="id_point_tab_top4">배달</th>
							<th scope="col" id="id_point_tab_top5">포장</th>
						</tr>
					</thead>
					<tbody >
					    <c:forEach var="categoryMenu" items="${categoryMenuList}" varStatus="status">
							<tr class="class_point_main_view" memberid="${categoryMenu.MEMBERID}" deviceid="${categoryMenu.DEVICEID}" categoryid="${categoryMenu.CATEGORYID}" menuid="${categoryMenu.MENUID}" sortorder="${categoryMenu.SORTORDER}" catepointname="${categoryMenu.NAME}" 
							storepoint = "${categoryMenu.STOREPOINT}" deliverypoint="${categoryMenu.DELIVERYPOINT}" takeoutpoint="${categoryMenu.TAKEOUTPOINT}" 
							storediscount = "${categoryMenu.STOREDISCOUNT}" deliverydiscount="${categoryMenu.DELIVERYDISCOUNT}" takeoutdiscount="${categoryMenu.TAKEOUTDISCOUNT}" menuFlag="false">
								<td><input type="text" class="class_point_name" data-role="none" value="${categoryMenu.NAME}"/></td>
								<td class="class_point_point"><input type="tel"  data-role="none" value="${categoryMenu.STOREPOINT}"/></td>
								<td class="class_point_storediscount"><input type="tel"  data-role="none" value="${categoryMenu.STOREDISCOUNT}"/></td>
								<td class="class_point_storepoint"><input type="tel"  data-role="none" value="${categoryMenu.STOREPOINT}"/></td>
								<td class="class_point_deliverypoint"><input type="tel"  data-role="none" value="${categoryMenu.DELIVERYPOINT}"/></td>
								<td class="class_point_takeoutpoint" ><input type="tel" data-role="none" value="${categoryMenu.TAKEOUTPOINT}"/></td>
								<td class="class_point_storediscount1"><input type="tel"  data-role="none" value="${categoryMenu.STOREDISCOUNT}"/></td>								
								<td class="class_point_deliverydiscount"><input type="tel"  data-role="none" value="${categoryMenu.DELIVERYDISCOUNT}"/></td>
								<td class="class_point_takeoutdiscount" ><input type="tel" data-role="none" value="${categoryMenu.TAKEOUTDISCOUNT}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!--e: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="btn_c tline">
				<a href="#" id="id_point_save"  class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
			</div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<!-- <a href="menu_manager02.html" class="pnprev" data-ajax="false"><span>&lt;</span></a>개발에선 지워주세요 -->
			<p><span>카테고리를 선택하고 포인트와 할인율을 입력하세요.</span></p>
			<!--<a href="memo_list.html" class="pnnext" data-ajax="false"><span>&gt;</span></a> 개발에선 지워주세요 -->
		</div>
	</div>

	<!-- s: 할인시간대 설정 팝업 -->
	<div data-role="popup" id="discount_time" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>할인시간 설정</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="time_wrap">
				<p class="diferente"><input type="checkbox" id="timec" class="class_point_time_differ"/><label for="timec">할인시간대 요일마다 다르게 설정</label></p>
				<div class="time_box">
					<!--s: 할인시간대 요일마다 다르게 설정 경우 -->
					<div class="week_choice tab" id="id_point_set_time_differ" style="display:none">
						<ul class="class_dc_time_differ_main" starttime1="" starttime2="" starttime3="" starttime4="" starttime5="" starttime6="" starttime7=""
							endtime1="" endtime2="" endtime3="" endtime4="" endtime5="" endtime6="" endtime7="">
							<li class="class_dc_time_differ_tap"><a href="#" class="active" >월</a></li>
							<li class="class_dc_time_differ_tap"><a href="#">화</a></li>
							<li class="class_dc_time_differ_tap"><a href="#">수</a></li>
							<li class="class_dc_time_differ_tap"><a href="#">목</a></li>
							<li class="class_dc_time_differ_tap"><a href="#">금</a></li>
							<li class="week_blue class_dc_time_differ_tap"><a href="#">토</a></li>
							<li class="week_red class_dc_time_differ_tap"><a href="#">일</a></li>
						</ul>
					</div>
					<!--e: 할인시간대 요일마다 다르게 설정 경우 -->
					<div class="time_admin">
						<div class="btn_ud bup">
							<ul>
								<li><a href="#" id="id_point_am_btn" class="class_point_am_pm" title="오전오후"></a></li>
								<li><a href="#" id="id_point_hour_plus_btn" title="시간"></a></li>
								<li><a href="#" id="id_point_minute_btn" title="분"></a></li>
							</ul>
							<ul>
								<li><a href="#" id="id_point_pm_btn" class="class_point_am_pm" title="오전오후"></a></li>
								<li><a href="#" id="id_point_hour2_plus_btn" title="시간"></a></li>
								<li><a href="#" id="id_point_minute2_btn"title="분"></a></li>
							</ul>
						</div>
						<div class="time_line">
							<ul>
								<li class="class_dc_time_line"><span id="id_point_am_text">오전</span> <span id="id_point_hour_text" >12</span> : <span id="id_point_minute_text">00</span></li>
								<li><span id="id_point_pm_text">오후</span> <span id="id_point_hour2_text">12</span> : <span id="id_point_minute2_text">00</span></li>
							</ul>
						</div>
						<div class="btn_ud bdown">
							<ul>
								<li><a href="#" id="id_point_hour_minus_btn" title="시간"></a></li>
							</ul>
							<ul>
								<li><a href="#" id="id_point_hour2_minus_btn" title="시간"></a></li>
							</ul>
						</div>						
					</div>
					<div class="week_choice" id="id_point_time_same">
						<ul class="class_dc_time_same_main">
							<li class="class_dc_time_same"><input type="checkbox" id="week_01" /><label for="week_01">월</label></li>
							<li class="class_dc_time_same"><input type="checkbox" id="week_02" /><label for="week_02">화</label></li>
							<li class="class_dc_time_same"><input type="checkbox" id="week_03" /><label for="week_03">수</label></li>
							<li class="class_dc_time_same"><input type="checkbox" id="week_04" /><label for="week_04">목</label></li>
							<li class="class_dc_time_same"><input type="checkbox" id="week_05" /><label for="week_05">금</label></li>
							<li class="class_dc_time_same"><input type="checkbox" id="week_06" /><label for="week_06" class="week_blue">토</label></li>
							<li class="class_dc_time_same"><input type="checkbox" id="week_07" /><label for="week_07" class="week_red">일</label></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue class_menu_dc_save">저장</a><a href="#" class="btn_white" data-rel="back">취소</a>
			</div>
		</div>
	</div>
	<!--e: 할인시간대 설정 팝업 -->

	<!-- s: 기타 팝업 -->
	<div data-role="popup" id="others_menu1" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>기타메뉴 입력, 편집</h1>
			<a href="#" data-rel="back" data-role="none" id="id_etc_menu_close" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="menu_list">
				<ul class="class_point_pop_tap">
					<c:forEach var="category" items="${categoryList}" varStatus="status">
				    <c:if test="${category.ISETC == 'Y'}">
						<li><input type="radio" id="otherL_${category.SORTORDER}" pointname="${category.NAME}" name="otherL_point" etcpointid="${category.CATEGORYID}" value="${category.SORTORDER}" isetc="${category.ISETC}" class="class_point_pop"/><label for="otherL_${category.SORTORDER}">${category.NAME}</label></li>
						
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