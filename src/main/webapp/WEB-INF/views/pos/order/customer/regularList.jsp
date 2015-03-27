<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
<title>가게노트</title>
<link rel="stylesheet" href="${ContextPath}/css/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="${ContextPath}/css/style.css" />
<script type="text/javascript" src="${ContextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ContextPath}/js/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page" id="demo-page" data-url="demo-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>단골고객</h1>
	</div>
	<div data-role="content">
		<div class="pos_top">
			<div class="top01">
				<p>테이블. <span><em>14</em></span></p>
			</div>
			<div class="top02">
				<div class="btn_fl">
					<a href="#" class="btn_01"><i title="추가" class="plus"></i></a><a href="#" class="btn_01"><i title="삭제" class="minus"></i></a><a href="#" class="btn_01">단골</a>
				</div>
				<div class="btn_fr">
					<a href="#reserve_check" class="btn_03" data-rel="popup" data-position-to="window" data-transition="pop">예약</a><a href="#" class="btn_03">고객주문(1)</a><a href="#" class="btn_03">메모</a>
				</div>
			</div>
		</div>
		
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>메뉴를 선택하세요. 점심특선/포장 등은 기타</span></p>
		</div>
	</div>

	<!-- s: 예약확인 팝업 -->
	<div data-role="popup" id="reserve_check" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>예약테이블 확인</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="pop_q">
				<p>예약손님 테이블입니다.<br /><span>예약 손님이 맞습니까?</span></p>
			</div>
			<div class="data_view">
				<dl>
					<dt>예약자</dt>
					<dd>최은혜 <a href="tel:010-5566-7788">010-5566-7788</a></dd>
				</dl>
				<dl>
					<dt>예약일자</dt>
					<dd>10-10(수) 오후 07:00</dd>
				</dl>
				<dl>
					<dt>예약인원</dt>
					<dd>7명</dd>
				</dl>
				<dl>
					<dt>메모</dt>
					<dd>10회 동문회</dd>
				</dl>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue" data-rel="back">예</a><a href="#" class="btn_white">다른손님</a>
			</div>
		</div>
	</div>
	<!--e: 예약확인 팝업 -->

	<!-- s: 기타 팝업 -->
	<div data-role="popup" id="others_menu" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>기타메뉴 입력, 편집</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="menu_list">
				<ul>
					<li><input type="radio" id="otherL_01" name="otherL" data-role="none" /><label for="otherL_01">점심특선</label></li>
					<li><input type="radio" id="otherL_02" name="otherL" data-role="none" /><label for="otherL_02">셋트메뉴</label></li>
					<li><input type="radio" id="otherL_03" name="otherL" data-role="none" /><label for="otherL_03">할인메뉴</label></li>
					<li><input type="radio" id="otherL_04" name="otherL" data-role="none" /><label for="otherL_04">포장메뉴</label></li>
					<li><input type="radio" id="otherL_05" name="otherL" data-role="none" /><label for="otherL_05">서비스</label></li>
				</ul>
			</div>
		</div>
	</div>
	<!--e: 기타 팝업 -->

</div>
</body>
</html> 