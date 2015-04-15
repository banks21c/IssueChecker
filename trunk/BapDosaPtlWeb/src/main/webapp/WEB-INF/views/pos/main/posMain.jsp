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
<script type="text/javascript" src="../../js/common/common.js"></script>
<script type="text/javascript" src="../../js/common/util.js"></script>
<script type="text/javascript" src="../../js/pos/posMain.js"></script>
</head>
<body>
<div data-role="page" id="pos-main" data-url="pos-main">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_home" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>간편포스</h1>
	</div>
	<div data-role="content">
		<div class="nav_btn">
			<ul>
				<li><a href="#" class="btn_03">주문</a></li>
				<li><a href="#" class="btn_03">배달</a></li>
				<li><a href="#" class="btn_03">메모</a></li>
				<li><a href="#special_pop" class="btn_03" data-rel="popup" data-position-to="window" data-transition="pop">특수</a></li>
				<li><a href="#" class="btn_03">매상</a></li>
				<li><a href="/pos/category/categoryManage.do" class="btn_03" data-ajax="false">메뉴</a></li>
			</ul>
		</div>
		<!--s: 테이블 목록 -->
		<div class="table_map">
			<ul>
				<li>
					<!--s: 테이블 주문이 들어간 경우 active 추가 -->
					<div class="table_info active">
						<a href="#">
							<span class="number">1</span>
							<span class="in_time">1:58</span>
							<span class="ico_list">
								<span class="ico m">M</span><span class="ico p">포</span><span class="ico s">서</span><span class="ico b">대</span>
							</span>
							<span class="connect">연결(+9)</span>
							<span class="sales">999</span>
						</a>
					</div>
					<!--e: 테이블 주문이 들어간 경우 active 추가 -->
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">2</span>
						</a>
					</div>
				</li>
				<li>
					<!--s: 예약 테이블인 경우 reserve 추가 -->
					<div class="table_info reserve">
						<a href="#">
							<span class="number">매난국죽</span>
							<span class="re_t">예약</span>
							<span class="re_name">길길주 8명</span>
							<span class="re_time">7:30</span>
						</a>
					</div>
					<!--e: 예약 테이블인 경우 reserve 추가 -->
				</li>
				<li>
					<!--s: 테이블을 선택한 경우 choice 추가 -->
					<div class="table_info choice">
						<a href="#">
							<span class="number">4</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
					<!--e: 테이블을 선택한 경우 choice 추가 -->
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">5</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">6</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">7</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">8</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">9</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">10</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">11</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">12</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">13</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">14</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">15</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">16</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">17</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">18</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
			</ul>
		</div>
		<!--e: 테이블 목록 -->
		<p class="sales_count">0 / 96</p>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<!-- <a href="" class="pnprev"><span>&lt;</span></a> --><!-- 개발에선 지워주세요 -->
			<p><span>주문→테이블터치, 메뉴설정→메뉴버튼</span></p>
			<a href="order_list.html" class="pnnext" data-ajax="false"><span>&gt;</span></a><!-- 개발에선 지워주세요 -->
		</div>
	</div>

	<!-- s: 특수팝업 -->
	<div data-role="popup" id="special_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>특수</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="menu_list">
				<ul>
					<li><input type="radio" id="specialM_01" name="specialM" /><label for="specialM_01">테이블 이동</label></li>
					<li><input type="radio" id="specialM_02" name="specialM" /><label for="specialM_02">합석</label></li>
					<li><input type="radio" id="specialM_03" name="specialM" /><label for="specialM_03">테이블 연결</label></li>
					<li><input type="radio" id="specialM_04" name="specialM" /><label for="specialM_04">포장판매</label></li>
					<li><input type="radio" id="specialM_05" name="specialM" /><label for="specialM_05">외상수금</label></li>
					<li><input type="radio" id="specialM_06" name="specialM" /><label for="specialM_06">예치금(선불금) 입금 및 반환</label></li>
					<li><input type="radio" id="specialM_07" name="specialM" /><label for="specialM_07">외상수금</label></li>
					<li><input type="radio" id="specialM_08" name="specialM" /><label for="specialM_08">테이블 이름 변경</label></li>
					<li><input type="radio" id="specialM_09" name="specialM" /><label for="specialM_09">식권판매</label></li>
					<li><input type="radio" id="specialM_10" name="specialM" /><label for="specialM_10">설정(프로그램 셋팅)</label></li>
				</ul>
			</div>
		</div>
	</div>
	<!--e: 특수 팝업 -->
	
	<!-- s: 식권 팝업 -->
	<div data-role="popup" id="voucher_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>식권판매금액 입력</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="change_wrap">
				<div class="change_in">
					<p class="day">
						<a href="#" class="btn_pn prev ui-link" title="이전"></a>
						<span>10/10 화</span>
						<a href="#" class="btn_pn next ui-link" title="다음"></a>
					</p>
					<p class="gb"><input type="number" id="" data-role="none" /> 천원</p>
				</div>
				<div class="keypad">
					<ul>
						<li><a href="#"><span>1</span></a></li>
						<li><a href="#"><span>2</span></a></li>
						<li><a href="#"><span>3</span></a></li>
						<li><a href="#"><span>4</span></a></li>
						<li><a href="#"><span>5</span></a></li>
						<li><a href="#"><span>6</span></a></li>
						<li><a href="#"><span>7</span></a></li>
						<li><a href="#"><span>8</span></a></li>
						<li><a href="#"><span>9</span></a></li>
						<li>
							<a href="#"><span>-</span></a>
							<a href="#" style="display:none"><span><i></i></span></a><!-- 숫자가 입력되면 마이너스가 백버튼으로 변경 -->
						</li>
						<li><a href="#"><span>0</span></a></li>
						<li><a href="#"><span>.</span></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="btn_c line">
			<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">취소</a>
		</div>
	</div>
	<!--e: 식권 팝업 -->	
</div>
</body>
</html>