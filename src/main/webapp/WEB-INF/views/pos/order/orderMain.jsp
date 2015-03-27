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
<script type="text/javascript">
jQuery(function($){ // on document load
	$('.bigs, .small').click(function(){
		$(".list_total").toggleClass("list_open");
		$(".btn_btm").toggleClass("bigtype");
		$(".food_list").toggleClass("none");
		$(".minh").toggleClass("full");
	});
})
</script>
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
		<div class="pos_top">
			<div class="top01">
				<div class="btn_fl">
					<a href="#" class="btn_01">메모</a><a href="#reserve_check" class="btn_01" data-rel="popup" data-position-to="window" data-transition="pop">예약</a>
					<!--s: 단골 고객(외상인경우 :c, tc  / 예치금인 경우:y, ty) -->
					<span class="patron">이명필
						<span class="ico c">외</span><span><em class="tc">117</em> / 1,256</span>
						<!-- <span class="ico y">예</span><span><em class="ty">117</em> / 1,256</span> -->
					</span>
					<!--e: 단골 고객(외상인경우 :c, tc  / 예치금인 경우:y, ty) -->
				</div>
				<p>No. <span><em>14</em></span></p>
			</div>
			<div class="top02">
				<div class="btn_fl">
					<a href="#" class="btn_01"><i title="추가" class="plus"></i></a><a href="#" class="btn_01"><i title="삭제" class="minus"></i></a><a href="#" class="btn_02">삭제</a><a href="#" class="btn_02">전체삭제</a>
				</div>
				<div class="btn_fr">
					<a href="#" class="btn_03">고객주문</a><a href="#" class="btn_03">서비스</a>
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
					<col width="23%" />
				</colgroup>
				<tbody>
					<tr>
						<td class="a_tl"><span class="ico p">포</span><strong>소갈비 - 한우</strong></td>
						<td>3</td>
						<td>16:43</td>
						<td class="price">60,000</td>
					</tr>
					<tr class="active">
						<td class="a_tl"><span class="ico p">포</span><strong><span class="ico s">서</span><strong>양념갈비 - 한우</strong></td>
						<td>3</td>
						<td>16:43</td>
						<td class="price">36,000</td>
					</tr>
					<tr>
						<td class="a_tl"><strong>소갈비 - 한우</strong></td>
						<td>6</td>
						<td>16:43</td>
						<td class="price">216,000</td>
					</tr>
					<tr>
						<td class="a_tl"><strong>소갈비 - 한우</strong></td>
						<td>6</td>
						<td>16:43</td>
						<td class="price">216,000</td>
					</tr>
					<tr>
						<td class="a_tl"><strong>소갈비 - 한우</strong></td>
						<td>6</td>
						<td>16:43</td>
						<td class="price">216,000</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="list_total">
			<div class="btn_fl">
				<a href="#" class="btn_01 small"><i></i>축소</a><a href="#" class="btn_01 bigs"><i></i>확대</a>
			</div>
			<p class="paging_count">total : <span>26</span></p>
			<p class="price_total">합계 <span>216,000 </span></p>
		</div>
		<!--e: 목록출력 -->
		<div class="btn_btm">
			<div class="btn_fl">
				<a href="#" class="btn_01">포장</a><a href="#" class="btn_01">단골</a>
			</div>
			<div class="btn_fr">
				<a href="#" class="btn_02">저장</a><a href="#" class="btn_02" data-rel="back">돌아가기</a><a href="#" class="btn_04">계산</a>
			</div>
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
			<div class="list2">
				<table>
					<colgroup>
						<col width="40%" />
						<col width="10%" />
						<col width="40%" />
						<col width="10%" />
					</colgroup>
					<tbody>
						<tr>
							<td class="a_tl">양념갈비 - 호주</td>
							<td>20</td>
							<td class="a_tl">양념갈비 - 호주</td>
							<td>20</td>
						</tr>
						<tr>
							<td class="a_tl"></td>
							<td></td>
							<td class="a_tl"></td>
							<td></td>
						</tr>
						<tr>
							<td class="a_tl"></td>
							<td></td>
							<td class="a_tl"></td>
							<td></td>
						</tr>
						<tr>
							<td class="a_tl"></td>
							<td></td>
							<td class="a_tl"></td>
							<td></td>
						</tr>
					</tbody>
				</table>
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