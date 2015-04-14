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
<script type="text/javascript" src="../../common/common.js"></script>
<script type="text/javascript" src="../../common/util.js"></script>
<script type="text/javascript">
jQuery(function($){ // on document load
	$('.bigs, .small').click(function(){
		$(".list_total").toggleClass("list_open");
		$(".btn_btm").toggleClass("bigtype");
		$(".food_list").toggleClass("none");
		$(".minh").toggleClass("full");
	});
	$('.view_fre, .fre_sh .btn_x').click(function(){
		$('.fre_pop').toggleClass('shw');
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
						<span class="ico c">외</span> <span><em class="tc">117</em> / 1,256</span>
						<!-- <span class="ico y">예</span><span><em class="ty">117</em> / 1,256</span> -->
					</span>
					<!--e: 단골 고객(외상인경우 :c, tc  / 예치금인 경우:y, ty) -->
				</div>
				<p>No. <span><em>14</em></span></p>
			</div>
			<div class="top02">
				<div class="btn_fl">
					<a href="#" class="btn_01 pds"><i title="추가" class="plus"></i></a><a href="#" class="btn_01 pds"><i title="삭제" class="minus"></i></a><a href="#" class="btn_02">삭제</a><a href="#" class="btn_02">전체삭제</a>
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
					<col width="20%" />
				</colgroup>
				<tbody>
					<tr>
						<td class="a_tl"><span class="ico p">포</span>소갈비 - 한우</td>
						<td>3</td>
						<td>16:43</td>
						<td class="price">60,000</td>
					</tr>
					<tr class="active">
						<td class="a_tl"><span class="ico p">포</span><span class="ico s">서</span>양념갈비 - 한우</td>
						<td>3</td>
						<td>16:43</td>
						<td class="price">36,000</td>
					</tr>
					<tr>
						<td class="a_tl">소갈비 - 한우</td>
						<td>6</td>
						<td>16:43</td>
						<td class="price">216,000</td>
					</tr>
					<tr>
						<td class="a_tl">소갈비 - 한우</td>
						<td>6</td>
						<td>16:43</td>
						<td class="price">216,000</td>
					</tr>
					<tr>
						<td class="a_tl">소갈비 - 한우</td>
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
				<a href="#" class="btn_01">포장</a><a href="#" class="btn_01 view_fre">단골</a>
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
			<a href="pos_main.html" class="pnprev" data-ajax="false"><span>&lt;</span></a><!-- 개발에선 지워주세요 -->
			<p><span>메뉴를 선택하세요. 점심특선/포장 등은 기타</span></p>
			<a href="frequenter_view.html" class="pnnext" data-ajax="false"><span>&gt;</span></a><!-- 개발에선 지워주세요 -->
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
					<li><input type="radio" id="otherL_01" name="otherL" /><label for="otherL_01">점심특선</label></li>
					<li><input type="radio" id="otherL_02" name="otherL" /><label for="otherL_02">셋트메뉴</label></li>
					<li><input type="radio" id="otherL_03" name="otherL" /><label for="otherL_03">할인메뉴</label></li>
					<li><input type="radio" id="otherL_04" name="otherL" /><label for="otherL_04">포장메뉴</label></li>
					<li><input type="radio" id="otherL_05" name="otherL" /><label for="otherL_05">서비스</label></li>
				</ul>
			</div>
		</div>
	</div>
	<!--e: 기타 팝업 -->

	<!--s: 단골팝업 -->
	<div class="fre_pop">
		<div class="fre_box">
			<div class="fre_sh">
				<strong>단골고객</strong>
				<input type="radio" id="fre_sh01" name="fre_shL" /><label for="fre_sh01">가나다 순</label>
				<input type="radio" id="fre_sh02" name="fre_shL" /><label for="fre_sh02">매상액 순</label>
				<a href="#" class="btn_x" title="닫기"></a>
			</div>
			<div class="name_shw">
				<div class="name_choice">
					<ul>
						<li><a href="#" class="active">모두</a></li>
						<li><a href="#"><span class="icot t01" title="ㄱ"></span></a></li>
						<li><a href="#"><span class="icot t02" title="ㄴ"></span></a></li>
						<li><a href="#"><span class="icot t03" title="ㄷ"></span></a></li>
						<li><a href="#"><span class="icot t04" title="ㄹ"></span></a></li>
						<li><a href="#"><span class="icot t05" title="ㅁ"></span></a></li>
						<li><a href="#"><span class="icot t06" title="ㅂ"></span></a></li>
						<li><a href="#"><span class="icot t07" title="ㅅ"></span></a></li>
						<li><a href="#"><span class="icot t08" title="ㅇ"></span></a></li>
						<li><a href="#"><span class="icot t09" title="ㅈ"></span></a></li>
						<li><a href="#"><span class="icot t10" title="ㅊ"></span></a></li>
						<li><a href="#"><span class="icot t11" title="ㅋ"></span></a></li>
						<li><a href="#"><span class="icot t12" title="ㅌ"></span></a></li>
						<li><a href="#"><span class="icot t13" title="ㅍ"></span></a></li>
						<li><a href="#"><span class="icot t14" title="ㅎ"></span></a></li>
					</ul>
				</div>
				<div class="delivery_name">
					<ul>
						<li><a href="#add_fre" data-rel="popup" data-position-to="window" data-transition="pop">직접입력</a></li>
						<li><a href="#">김치과</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹정명 <strong class="tc">17</strong></a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li><!-- 외상인 경우 -->
						<li><a href="#">세무그룹 <strong class="ty">17</strong></a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li><!-- 예치금인 경우 -->
						<li><a href="#">세무그룹정명</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹정명</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹정명</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹정명</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹정명</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹정명</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹정명</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹정명</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
						<li><a href="#">세무그룹</a><a href="#guest_detail" class="btn_go2" title="자세히보기" data-rel="popup" data-position-to="window" data-transition="pop"></a></li>
					</ul>
				</div>
				<div class="name_sh">
					<p>검색 <input type="text" id="" data-role="none" /></p>
				</div>
			</div>
		</div>
	</div>
	<!--e: 단골팝업 -->

	<!-- s: 단골 등록 팝업 -->
	<div data-role="popup" id="add_fre" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>단골 등록</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="fre_add_top">
				<p>고객명 <input type="text" id="" data-role="none" class="wp60" /></p>
				<ul>
					<li><input type="checkbox" id="fre_add01" name="" /><label for="fre_add01">연락처 입력</label></li>
					<li><input type="checkbox" id="fre_add02" name="" /><label for="fre_add02">외상잔액 입력</label></li>
					<li><input type="checkbox" id="fre_add03" name="" /><label for="fre_add03">예치금 입력</label></li>
				</ul>
			</div>
			<div class="fre_addition">
				<dl>
					<dt>연락처</dt>
					<dd>
						<input type="number" id="" data-role="none" class="wp20" /> - 
						<input type="number" id="" data-role="none" class="wp20" /> - 
						<input type="number" id="" data-role="none" class="wp20" />
						<a href="#" class="btn_sh" title="검색"></a>
					</dd>
				</dl>
				<dl style="display:none">
					<dt>외상잔액</dt>
					<dd><input type="number" id="" data-role="none" /></dd>
				</dl>
				<dl>
					<dt>예치금잔액</dt>
					<dd><input type="number" id="" data-role="none" /></dd>
				</dl>
			</div>
			<div class="gray_box">
				<p>입력 중에 아래 원하는 고객이 나타나면 선택하세요.</p>
				<ul>
					<li><input type="text" id="" data-role="none" /></li>
					<li><input type="text" id="" data-role="none" /></li>
					<li><input type="text" id="" data-role="none" /></li>
					<li><input type="text" id="" data-role="none" /></li>
				</ul>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">취소</a>
			</div>
		</div>
	</div>
	<!--e: 단골 등록 팝업 -->

	<!-- s: 고객상세 팝업 -->
	<div data-role="popup" id="guest_detail" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>고객 상세정보</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="pos_top">
				<div class="top01">
					<span class="name">이명필 <span><em>117</em> / 1,256</span></span>
					<p><strong>010-5555-5555</strong></p>
				</div>
				<div class="top02 bgf">
					<div class="btn_fl">
						<span class="year_write">
							<a href="#" class="perv" title="이전"></a>
							<input type="text" id="" data-role="none" class="year" />
							<a href="#" class="next" title="다음"></a>
						</span>
					</div>
					<div class="btn_fr">
						<span class="month">
							<input type="text" id="" data-role="none" /> 월 ~
							<input type="text" id="" data-role="none" /> 월
						</span>
						<a href="#" class="btn_02">조회</a>
					</div>
				</div>
			</div>
			<div class="list3">
				<table>
					<colgroup>
						<col width="15%" />
						<col width="*" />
						<col width="12%" />
						<col width="12%" />
						<col width="14%" />
						<col width="12%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">일자</th>
							<th scope="col">주문</th>
							<th scope="col">금액</th>
							<th scope="col">결제</th>
							<th scope="col">외상</th>
							<th scope="col">잔액</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>10/10</td>
							<td class="a_tl"><span class="tover">김치찌게 외</span></td>
							<td>23</td>
							<td>13</td>
							<td>외상</td>
							<td>117</td>
						</tr>
						<tr>
							<td>10/10</td>
							<td class="a_tl"><span class="tover">김치찌게 김치찌게 외</span></td>
							<td>23</td>
							<td>13</td>
							<td>외상</td>
							<td>117</td>
						</tr>
						<tr>
							<td>10/10</td>
							<td class="a_tl"><span class="tover">김치찌게 외</span></td>
							<td>23</td>
							<td>13</td>
							<td>외상</td>
							<td>117</td>
						</tr>
						<tr>
							<td>10/10</td>
							<td class="a_tl"><span class="tover">김치찌게 외</span></td>
							<td>23</td>
							<td>13</td>
							<td>외상</td>
							<td>117</td>
						</tr>
						<tr>
							<td>10/10</td>
							<td class="a_tl"><span class="tover">김치찌게 외</span></td>
							<td>23</td>
							<td>13</td>
							<td>외상</td>
							<td>117</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th scope="row" colspan="2">합계</th>
							<td>67</td>
							<td>50</td>
							<td></td>
							<td></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<div class="btn_c">
			<a href="#" class="btn_blue" data-rel="back">확인</a>
		</div>
	</div>
	<!--e: 고객상세 팝업 -->

</div>
</body>
</html> 