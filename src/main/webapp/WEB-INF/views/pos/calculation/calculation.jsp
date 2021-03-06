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
$(document).ready(function() {
	$('.opn01').click(function() {
		$('.tb01').toggleClass('shv');
		$('.tb01 .op_blt').toggleClass('closed');
	});
	$('.opn02').click(function() {
		$('.tb02').toggleClass('shv');
		$('.tb02 .op_blt').toggleClass('closed');
	});
});
</script>
</head>
<body>
<div data-role="page" id="demo-page" data-url="demo-page">
	<div data-role="header" data-position="fixed">
		<a href="${ContextPath}/pos/main/posMain.ui" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="${ContextPath}/pos/list.ui" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>계산</h1>
	</div>
	<div data-role="content">
		<div class="pos_top">
			<div class="top01 onlyt">
				<div class="btn_fl">
					<!--s: 단골 고객(외상인경우 :c, tc  / 예치금인 경우:y, ty) -->
					<span class="patron">이명필
						<span class="ico c">외</span><span><em class="tc">117</em> / 1,256</span>
						<!-- <span class="ico y">예</span><span><em class="ty">117</em> / 1,256</span> -->
					</span>
					<!--e: 단골 고객(외상인경우 :c, tc  / 예치금인 경우:y, ty) -->
				</div>
				<p>No. <span><em>14</em></span></p>
			</div>
		</div>
		<div class="write3">
			<table>
				<colgroup>
					<col width="25%" />
					<col width="35%" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">음식요금</th>
						<td></td>
						<td class="a_tr"><input type="number" id="" data-role="none" class="in_green" /></td>
					</tr>
					<tr>
						<td colspan="3"><a href="#" class="tover">소갈비(2) 돼지양념갈비(2) 소주(3) 공기밥(1) 소갈비(2) 돼지양념갈비(2) 소주(3) 공기밥(1)</a></td>
					</tr>
					<tr>
						<th scope="row">포장금액</th>
						<td class="take_out">찹쌀순대(2)</td>
						<td class="a_tr"><input type="number" id="" data-role="none" /></td>
					</tr>
					<tr>
						<th scope="row">외상값</th>
						<td><a href="#" class="btn_01">all</a></td>
						<td class="a_tr"><input type="number" id="" data-role="none" /></td>
					</tr>
					<tr>
						<td colspan="3" class="a_tc">옵션없음
							<div class="tb_option tb01">
								<p class="blt">
									<span class="op_blt opn01"></span>
									<span>
										<label for="op01">손실</label>
										<input type="number" id="op01" data-role="none" />
									</span>
									<span>
										<label for="op02">할인</label>
										<input type="number" id="op02" data-role="none" />
									</span>
									<a href="#discount_pop" class="btn_arr" data-rel="popup" data-position-to="window" data-transition="pop"></a>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"><span>청구금액</span></th>
						<td></td>
						<td class="a_tr"><input type="number" id="" data-role="none" class="in_green" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="write3 double">
			<table>
				<colgroup>
					<col width="25%" />
					<col width="35%" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">포장금액</th>
						<td class="take_out"><input type="checkbox" id="cash" data-role="none" /><label for="cash" class="brown">현금영수증</label></td>
						<td class="a_tr"><input type="number" id="" data-role="none" /></td>
					</tr>
					<tr>
						<td colspan="3">
							<div class="cash_list">
								<ul>
									<li><a href="#">80,000원</a></li>
									<li><a href="#">100,000원</a></li>
								</ul>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row">카드</th>
						<td><a href="#" class="btn_01">all</a></td>
						<td class="a_tr"><input type="number" id="" data-role="none" /></td>
					</tr>
					<tr>
						<td colspan="3" class="a_tc">옵션없음
							<div class="tb_option tb02">
								<p class="blt">
									<span class="op_blt opn02"></span>
									<span class="btn_fl">
										<input type="checkbox" id="op03" data-role="none" /><label for="op03" class="brown">외상처리</label>
									</span>
									<span>
										<label for="op04">적립P</label>
										<input type="number" id="op04" data-role="none" />
									</span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"><span>거스름돈</span></th>
						<td></td>
						<td class="a_tr"><input type="number" id="" data-role="none" class="in_orange" /></td>
					</tr>
					<tr>
						<th scope="row"><span>더받을돈</span></th>
						<td></td>
						<td class="a_tr"><input type="number" id="" data-role="none" class="in_brown" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btn_c tline">
			<a href="#" class="btn_white">주문조회</a><a href="#" class="btn_white">취소</a><a href="#message_pop" class="btn_blue" data-rel="popup" data-position-to="window" data-transition="pop">완료</a>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>메뉴를 선택하세요. 점심특선/포장 등은 기타</span></p>
		</div>
	</div>

	<!-- s: 할인율 팝업 -->
	<div data-role="popup" id="discount_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>할인율</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="credit_write">
				<dl>
					<dt class="w02">직접입력</dt>
					<dd><input type="number" id="" data-role="none" /> 원</dd>
				</dl>
			</div>
			<div class="menu_list">
				<ul>
					<li><input type="radio" id="discountL_01" name="discountL" data-role="none" /><label for="discountL_01">할인없음</label></li>
					<li><input type="radio" id="discountL_02" name="discountL" data-role="none" /><label for="discountL_02">3%</label></li>
					<li><input type="radio" id="discountL_03" name="discountL" data-role="none" /><label for="discountL_03">5%</label></li>
					<li><input type="radio" id="discountL_04" name="discountL" data-role="none" /><label for="discountL_04">7%</label></li>
					<li><input type="radio" id="discountL_05" name="discountL" data-role="none" /><label for="discountL_05">10%</label></li>
				</ul>
			</div>
			<div class="btn_c line">
				<a href="#" class="btn_blue">확인</a><a href="#" class="btn_white" data-rel="back">취소</a>
			</div>
		</div>
	</div>
	<!--e: 할인율 팝업 -->

	<!-- s: 알림 팝업 -->
	<div data-role="popup" id="message_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>알림</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="massage_wrap">
				<p>손실 및 할인 항목에 금액이 입력되어 있습니다.<br />손실 및 할인을 취소하시겠습니까?</p>
				<p style="display:none">더 받을 돈이 남아 있습니다.<br />내용을 수정하시거나 [&lt;]버튼을 눌러 외상 <br />처리하시기 바랍니다.</p>
				<p style="display:none">현금+카드 금액이 외상값 금액보다 작아선 <br />안 됩니다.</p>
				<p style="display:none">외상값이 남아 있습니다.<br />[외상갚기]도 선택해 주세요.</p>
				<p style="display:none">예치할 금액이 없습니다.<br />[예치]를 선택해제 해 주세요.</p>
				<p style="display:none">외상처리를 위해 단골로 등록하시겠습니까?</p>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue">예</a><a href="#" class="btn_white" data-rel="back">아니오</a>
				<a href="#" class="btn_blue" style="display:none">확인</a><!-- 확인버튼 -->
			</div>
		</div>
	</div>
	<!--e: 알림 팝업 -->
</div>
</body>
</html> 