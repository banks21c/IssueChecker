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
		<a href="${ContextPath}/pos/main/posMain.ui" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="${ContextPath}/pos/list.ui" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>메모</h1>
	</div>
	<div data-role="content">
		<!--s: 테이블 목록 -->
		<div class="table_map list6">
			<ul>
				<li>
					<div class="table_info active">
						<a href="#">
							<span class="number">1</span>
							<span class="sales">999</span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">2</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">3</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">4</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">5</span>
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
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">8</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">9</span>
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
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">12</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">13</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">14</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">15</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">16</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">17</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">18</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">19</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">20</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">21</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">22</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">23</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">24</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
			</ul>
		</div>
		<!--e: 테이블 목록 -->
		<p class="memo_tip">테이블은 선택 안 해도 됩니다.</p>
		<div class="mm_write2">
			<textarea id="" rows="" cols="" data-role="none"></textarea>
		</div>
		<p class="mms"><input type="checkbox" id="memos" data-role="none" /><label for="memos">주요메모로 보관</label></p>
		<div class="btn_c tline">
			<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white">삭제</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>먼저 고객의 좌석을 선택하세요.</span></p>
		</div>
	</div>
</div>
</body>
</html> 