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
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>간편포스</h1>
	</div>
	<div data-role="content">
		<div class="menu_tab">
			<ul>
				<li><a href="#" class="on">카테고리 편집</a></li>
				<li><a href="#">메뉴추가</a></li>
				<li><a href="#">포인트/할인율 설정</a></li>
			</ul>
		</div>

		<div class="category_list">
			<div class="cate before">
				<h3>Before</h3>
				<div class="cl">
					<ul>
						<li><a href="#" class="on">요리류</a></li>
						<li><a href="#">식사류</a></li>
						<li><a href="#">주류</a></li>
						<li><a href="#">음료류</a></li>
						<li><a href="#">기타</a></li>
					</ul>
					<div class="btn_c">
						<a href="#" class="btn_01" title="위로"><i class="up"></i></a><a href="#" class="btn_01" title="아래로"><i class="down"></i></a>
					</div>
				</div>
				<div class="cr">
					<ul>
						<li><a href="#">점심특선</a></li>
						<li><a href="#">셋트메뉴</a></li>
						<li><a href="#">할인메뉴</a></li>
						<li><a href="#">포장메뉴</a></li>
						<li><a href="#">서비스</a></li>
					</ul>
				</div>
			</div>
			<div class="cate after">
				<h3>After</h3>
				<div class="cl">
					<ul>
						<li><span><input type="text" id="" data-role="none" /></span></li>
						<li><span><input type="text" id="" data-role="none" /></span></li>
						<li><span><input type="text" id="" data-role="none" /></span></li>
						<li><span class="disable">음료류</span></li>
						<li><span><input type="text" id="" data-role="none" /></span></li>
					</ul>
				</div>
				<div class="cr">
					<ul>
						<li><span class="disable">점심특선</span></li>
						<li><span><input type="text" id="" data-role="none" /></span></li>
						<li><span><input type="text" id="" data-role="none" /></span></li>
						<li><span><input type="text" id="" data-role="none" /></span></li>
						<li><span class="disable">서비스</span></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="btn_c tline">
			<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>카테고리를 선택하고 메뉴와 금액을 입력하세요.</span></p>
		</div>
	</div>
</div>
</body>
</html> 