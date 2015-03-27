<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
<title>가게노트</title>
<link rel="stylesheet" href="../../css/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/style.css" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page" id="demo-page" data-url="demo-page">
	<div data-role="header" data-position="fixed">
		<a href="${ContextPath}/pos/list.ui" class="topbtn btn_home" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>간편포스</h1>
	</div>
	<div data-role="content">
		<div class="menu_tab type6">
			<ul>
				<li><a href="#" class="on">주문</a></li>
				<li><a href="#">배달</a></li>
				<li><a href="#">메모</a></li>
				<li><a href="#">특수</a></li>
				<li><a href="#">매상</a></li>
				<li><a href="#">메뉴</a></li>
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
							<span class="number">3</span>
							<span class="re_t">예약</span>
							<span class="re_name">길길주 8명</span>
							<span class="re_time">7:30</span>
						</a>
					</div>
					<!--e: 예약 테이블인 경우 reserve 추가 -->
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">4</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
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
			<p><span>주문→테이블터치, 메뉴설정→메뉴버튼</span></p>
		</div>
	</div>
</div>
</body>
</html> 