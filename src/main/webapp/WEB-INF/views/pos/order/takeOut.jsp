<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
<title>가게노트</title>
<link rel="stylesheet" href="../../css/jquery.mobile-1.4.5.css" />
<link rel="stylesheet" href="../../css/style.css" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="../../js/moment.min.js"></script>
<script type="text/javascript" src="../../js/json2.js"></script>
<script type="text/javascript" src="../../js/base64.js"></script>
<script type="text/javascript" src="../../js/common/common.js"></script>
<script type="text/javascript" src="../../js/common/util.js"></script>
<script type="text/javascript" src="../../js/pos/takeOut.js"></script>
<script type="text/javascript">
jQuery(function($){ // on document load
	$('.bigs, .small').click(function(){
		$(".list_total").toggleClass("list_open");
		$(".btn_btm").toggleClass("bigtype");
		$(".food_list").toggleClass("none");
		$(".minh").toggleClass("full");
	});
	$('.view_fre, .fre_sh .btn_x').click(function(){
		$('.fre_pop').toggleClass('shw');
	});
})
</script>
</head>
<body>
<div data-role="page" id="takeout-page" data-url="takeout-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1> 포장판매</h1>
	</div>
	<div data-role="content">
		<div class="pos_top">
			<div class="top02">
				<div class="btn_fl">
					<a href="#" class="btn_01 pds class-event-order-add"><i title="추가" class="plus"></i></a>
					<a href="#" class="btn_01 pds class-event-order-del"><i title="삭제" class="minus"></i></a>
					<a href="#" class="btn_02 class-event-order-delete">삭제</a>
					<a href="#" class="btn_02 class-event-order-delete-all">전체삭제</a>
				</div>
				<div class="btn_fr">
					<a href="#" class="btn_03 class-event-customer-request">고객주문</a><a href="#" class="btn_03 class-event-order-service">서비스</a>
				</div>
			</div>
		</div>
		<!--s: 목록출력 -->
		<div class="list minh">
			<table>
				<colgroup>
					<col width="*" />
					<col width="7%" />
					<col width="17%" />
					<col width="20%" />
				</colgroup>
				<tbody>
					<!-- 
					<tr>
						<td class="a_tl">소갈비 - 한우</td>
						<td>3</td>
						<td>16:43</td>
						<td class="price">60,000</td>
					</tr>
					<tr class="active">
						<td class="a_tl"><span class="ico s">서</span>양념갈비 - 한우</td>
						<td>3</td>
						<td>16:43</td>
						<td class="price">36,000</td>
					</tr>
					<tr>
						<td class="a_tl">소갈비 - 한우</td>
						<td>6</td>
						<td>16:43</td>
						<td class="price">216,000</td>
					</tr>
					<tr>
						<td class="a_tl">소갈비 - 한우</td>
						<td>6</td>
						<td>16:43</td>
						<td class="price">216,000</td>
					</tr>
					<tr>
						<td class="a_tl">소갈비 - 한우</td>
						<td>6</td>
						<td>16:43</td>
						<td class="price">216,000</td>
					</tr>
					 -->
				</tbody>
			</table>
		</div>
		<div class="list_total">
			<div class="btn_fl">
				<a href="#" class="btn_01 small"><i></i>축소</a><a href="#" class="btn_01 bigs"><i></i>확대</a>
			</div>
			<p class="paging_count">total : <span>0</span></p>
			<p class="price_total">합계 <span>0 </span></p>
		</div>
		<!--e: 목록출력 -->
		<div class="btn_btm">
			<!-- <div class="btn_fl">
				<a href="#" class="btn_01">단골</a>
			</div> -->
			<div class="btn_fr">
				<a href="#" class="btn_02" data-rel="back">돌아가기</a><a href="#" class="btn_04 class-event-account-go">계산</a>
			</div>
		</div>
		<div class="food_list">
			<div class="tab">
				<ul class="class-category-area">
					<li class="on"><a href="#">요리류</a></li>
					<li><a href="#">식사류</a></li>
					<li><a href="#">주류</a></li>
					<li><a href="#">음료류</a></li>
					<li><a href="#others_menu" data-rel="popup" data-position-to="window" data-transition="pop">기타</a></li>
				</ul>
			</div>
			<div class="foodlist">
				<ul></ul>
			</div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<a href="table_connect.html" class="pnprev" data-ajax="false"><span>&lt;</span></a><!-- 개발에선 지워주세요 -->
			<p><span>메뉴를 선택하세요. 점심특선/포장 등은 기타</span></p>
			<a href="credit_collect.html" class="pnnext" data-ajax="false"><span>&gt;</span></a><!-- 개발에선 지워주세요 -->
		</div>
	</div>

	<!-- s: 기타 팝업 -->
	<div data-role="popup" id="others_menu" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>기타메뉴 입력, 편집</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="menu_list">
				<ul>
					<li><input type="radio" id="otherL_01" name="otherL" /><label for="otherL_01">점심특선</label></li>
					<li><input type="radio" id="otherL_02" name="otherL" /><label for="otherL_02">셋트메뉴</label></li>
					<li><input type="radio" id="otherL_03" name="otherL" /><label for="otherL_03">할인메뉴</label></li>
					<li><input type="radio" id="otherL_04" name="otherL" /><label for="otherL_04">포장메뉴</label></li>
					<li><input type="radio" id="otherL_05" name="otherL" /><label for="otherL_05">서비스</label></li>
				</ul>
			</div>
		</div>
	</div>
	<!--e: 기타 팝업 -->

</div>
</body>
</html> 