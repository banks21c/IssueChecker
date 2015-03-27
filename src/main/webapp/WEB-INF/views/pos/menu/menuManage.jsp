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
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>간편포스</h1>
	</div>
	<div data-role="content">
		<div class="menu_tab">
			<ul>
				<li><a href="#">카테고리 편집</a></li>
				<li><a href="#" class="on">메뉴추가</a></li>
				<li><a href="#">포인트/할인율 설정</a></li>
			</ul>
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
				<span class="ps">금액(천단위)</span>
			</div>
			<!--s: 입력목록 -->
			<div class="write">
				<table>
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="30%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">요리류 메뉴</th>
							<th scope="col">금액</th>
							<th scope="col">숨김</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--e: 입력목록 -->
			<!--s: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="write" style="display:none">
				<table>
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="12%" />
						<col width="12%" />
						<col width="12%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">요리류 메뉴</th>
							<th scope="col">매장</th>
							<th scope="col">배달</th>
							<th scope="col">포장</th>
							<th scope="col">숨김</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
						<tr>
							<td class="a_tl"><input type="checkbox" id=""  data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="text" id="" data-role="none" /></td>
							<td><input type="checkbox" id="" data-role="none" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--e: 입력목록(매장/배달/포장 금액 다를경우) -->
			<div class="control">
				<a href="#" class="btn_01" title="위로"><i class="up"></i></a><a href="#" class="btn_01" title="아래로"><i class="down"></i></a><a href="#" class="btn_02">추가</a><a href="#" class="btn_02">삭제</a>
				<span>ex) 12,000원 12/ 5백원 0.5</span>
			</div>
			<div class="btn_c tline">
				<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
			</div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>카테고리를 선택하고 메뉴와 금액을 입력하세요.</span></p>
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