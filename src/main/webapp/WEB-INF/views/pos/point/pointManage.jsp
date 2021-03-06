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
		<h1>간편포스</h1>
	</div>
	<div data-role="content">
		<div class="menu_tab">
			<ul>
				<li><a href="#">카테고리 편집</a></li>
				<li><a href="#">메뉴추가</a></li>
				<li><a href="#" class="on">포인트/할인율 설정</a></li>
			</ul>
		</div>
		<div class="discount_time">
			<a href="#discount_time" class="btn_02" data-rel="popup" data-position-to="window" data-transition="pop">할인시간대 설정</a>
		</div>
		<div class="food_list">
			<div class="tab">
				<ul>
					<li class="on"><a href="#">요리류</a></li>
					<li><a href="#">식사류</a></li>
					<li><a href="#">주류</a></li>
					<li><a href="#">음료류</a></li>
					<li><a href="#others_menu" data-rel="popup" data-position-to="window" data-transition="pop">기타</a></li>
				</ul>
			</div>
			<div class="price_other">
				<input type="checkbox" id="pr_other" data-role="none" /><label for="pr_other">매장/배달/포장 금액 각각 다름</label>
				<!-- s: 매장/배달/포장 금액 다를경우 나타남 -->
				<div class="p_type" style="display:none">
					<ul>
						<li><a href="#" class="active">포인트</a></li>
						<li><a href="#">할인율</a></li>
					</ul>
				</div>
				<!--e: 매장/배달/포장 금액 다를경우 나타남 -->
			</div>
			<!--s: 입력목록 -->
			<div class="write bnone">
				<table>
					<colgroup>
						<col width="*" />
						<col width="20%" />
						<col width="20%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">요리류 메뉴</th>
							<th scope="col">포인트</th>
							<th scope="col">할인율</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--e: 입력목록 -->
			<!--s: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="write bnone" style="display:none">
				<table>
					<colgroup>
						<col width="*" />
						<col width="14%" />
						<col width="14%" />
						<col width="14%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">요리류 메뉴</th>
							<th scope="col">매장</th>
							<th scope="col">배달</th>
							<th scope="col">포장</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--e: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="btn_c tline">
				<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
			</div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>카테고리를 선택하고 포인트와 할인율을 입력하세요.</span></p>
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
				<p class="diferente"><input type="checkbox" id="timec" data-role="none" /><label for="timec">할인시간대 요일마다 다르게 설정</label></p>
				<div class="time_box">
					<!--s: 할인시간대 요일마다 다르게 설정 경우 -->
					<div class="week_choice tab" style="display:none">
						<ul>
							<li><a href="#">월</a></li>
							<li><a href="#" class="active">화</a></li>
							<li><a href="#">수</a></li>
							<li><a href="#">목</a></li>
							<li><a href="#">금</a></li>
							<li class="week_blue"><a href="#">토</a></li>
							<li class="week_red"><a href="#">일</a></li>
						</ul>
					</div>
					<!--e: 할인시간대 요일마다 다르게 설정 경우 -->
					<div class="time_admin">
						<div class="times start">
							<span><a href="#" class="up"></a>오전</span>
							<span><a href="#" class="up"></a><a href="#" class="down"></a>12</span>
							<span class="mins">:</span>
							<span><a href="#" class="up"></a>00</span>
						</div>
						<div class="times end">
							<span><a href="#" class="up"></a>오후</span>
							<span><a href="#" class="up"></a><a href="#" class="down"></a>12</span>
							<span class="mins">:</span>
							<span><a href="#" class="up"></a>00</span>
						</div>
					</div>
					<div class="week_choice">
						<ul>
							<li><input type="checkbox" id="week_01" data-role="none" /><label for="week_01">월</label></li>
							<li><input type="checkbox" id="week_02" data-role="none" /><label for="week_02">화</label></li>
							<li><input type="checkbox" id="week_03" data-role="none" /><label for="week_03">수</label></li>
							<li><input type="checkbox" id="week_04" data-role="none" /><label for="week_04">목</label></li>
							<li><input type="checkbox" id="week_05" data-role="none" /><label for="week_05">금</label></li>
							<li><input type="checkbox" id="week_06" data-role="none" /><label for="week_06" class="week_blue">토</label></li>
							<li><input type="checkbox" id="week_07" data-role="none" /><label for="week_07" class="week_red">일</label></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">취소</a>
			</div>
		</div>
	</div>
	<!--e: 할인시간대 설정 팝업 -->

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