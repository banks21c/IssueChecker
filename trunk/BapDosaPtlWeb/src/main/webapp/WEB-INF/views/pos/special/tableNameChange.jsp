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
<script type="text/javascript" src="../../../../js/pos/tableNameChange.js"></script>
</head>
<body>

<div data-role="page" id="demo-page" data-url="demo-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>테이블 이름</h1>
	</div>
	<div data-role="content">
		<div class="name_info">
			<p>테이블 이름은 <span>4자 이하</span>이어야 합니다.</p>
		</div>
		<div class="category_list">
			<div class="cate before">
				<h3>Before</h3>
				<div class="full">
					<ul id="id_table_name_change_main" class="class_table_name_change_main">
						<li><a href="#"></a></li>						
					</ul>
				</div>
			</div>
			<div class="cate after">
				<h3>After</h3>
				<div class="full">
					<ul class="class_table_name_change_sub">
						<li><span><input type="text" id="" data-role="none" /></span></li>						
					</ul>
				</div>
			</div>
		</div>
		<div class="btn_c tline">
			<a href="#" class="btn_blue class_table_name_change_save">저장</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<!--<a href="prepaid_deposit.html" class="pnprev" data-ajax="false"><span>&lt;</span></a> 개발에선 지워주세요 -->
			<p><span>오른쪽 입력란에 바뀔 테이블 이름을 입력하고 저장버튼을 눌러주세요.</span></p>
			<!-- <a href="sales_main.html" class="pnnext" data-ajax="false"><span>&gt;</span></a>개발에선 지워주세요 -->
		</div>
	</div>
</div>
</body>
</html>