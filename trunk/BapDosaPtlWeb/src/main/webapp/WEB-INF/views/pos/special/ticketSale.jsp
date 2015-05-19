<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<script type="text/javascript" src="../../../../js/moment.min.js"></script>
<script type="text/javascript" src="../../../../js/json2.js"></script>
<script type="text/javascript" src="../../../../js/base64.js"></script>
<script type="text/javascript" src="../../../../js/common/common.js"></script>
<script type="text/javascript" src="../../../../js/common/util.js"></script>
<script type="text/javascript" src="../../../../js/pos/ticketSale.js"></script>
</head>
<body>

<!-- s: 식권 팝업 -->
	<div data-role="page" id="numpad-page" data-url="numpad-page">
		<div data-role="header" data-theme="a">
			<h1>식권판매금액 입력</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="change_wrap">
				<div class="change_in">
					<p class="day">
						<a href="#" id="id_numpad_prev" class="btn_pn prev ui-link" title="이전"></a>
						<span id="id_get_month"></span>/<span id="id_get_day"></span>/<span id="id_get_weekday"></span>
						<a href="#" id="id_numpad_next" class="btn_pn next ui-link" title="다음"></a>
					</p>
					<p class="gb"><input type="number" id="" class="class_price_input" data-role="none" /> 천원</p>
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
							<a href="#"><span>←</span></a>
							<a href="#" style="display:none"><span><i></i></span></a><!-- 숫자가 입력되면 마이너스가 백버튼으로 변경 -->
						</li>
						<li><a href="#"><span>0</span></a></li>
						<li><a href="#"><span>.</span></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="btn_c line">
			<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
		</div>
	</div>
	<!--e: 식권 팝업 -->	

</body>
</html>