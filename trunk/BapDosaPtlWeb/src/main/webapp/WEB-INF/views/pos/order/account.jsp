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
<script type="text/javascript" src="../../js/moment.min.js"></script>
<script type="text/javascript" src="../../js/json2.js"></script>
<script type="text/javascript" src="../../js/base64.js"></script>
<script type="text/javascript" src="../../js/common/common.js"></script>
<script type="text/javascript" src="../../js/common/util.js"></script>
<script type="text/javascript" src="../../js/pos/account.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.opn01').click(function() {
//		$('.tb01').toggleClass('shv');
//		$('.tb01 .op_blt').toggleClass('closed');
	});
	$('.opn02').click(function() {
		$('.tb02').toggleClass('shv');
		$('.tb02 .op_blt').toggleClass('closed');
	});
});
</script>
</head>
<body>
<div data-role="page" id="account-page" data-url="demo-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>계산</h1>
	</div>
	<div data-role="content">
		<form name="form_account" id="form_account">
		<div class="pos_top">
			<div class="top01 onlyt">
				<div class="btn_fl">
					<!--s: 단골 고객(외상인경우 :c, tc  / 예치금인 경우:y, ty) -->
					<!-- 					
					<span class="patron">이명필
						<span class="ico c">외</span><span><em class="tc">117</em> / 1,256</span>
						<span class="ico y">예</span><span><em class="ty">117</em> / 1,256</span>
					</span> -->
					<!--e: 단골 고객(외상인경우 :c, tc  / 예치금인 경우:y, ty) -->					
					
					<span class="patron class-area-customer-info">
					</span>				
					
				</div>
				<p>No. <span><em class="class-area-table-name"></em></span></p>
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
						<td class="a_tr"><input type="tel" name="foodPrice" data-role="none" class="in_green" readonly/></td>
					</tr>
					<tr>
						<td colspan="3">
						<a href="#" class="tover class-area-order-list"></a>
						</td>
					</tr>
					<!-- 
					<tr>
						<th scope="row">포장금액</th>
						<td class="take_out">찹쌀순대(2)</td>
						<td class="a_tr"><input type="number" id="" data-role="none" /></td>
					</tr>
					-->
					<tr class="class-area-credit" style="display:none">
						<th scope="row">외상값</th>
						<td><a href="#" class="btn_01 class-event-credit-all">all</a></td>
						<td class="a_tr"><input type="tel" name="creditAmount" data-role="none" value="0"/></td>
					</tr>
					<tr>
						<td colspan="3" class="a_tc">
							<p class="class-area-nooption">옵션없음</p>
							<!--s: 적립포인트가 있는경우 -->
							<div class="point_use class-area-point" style="display:none">
								<label for="op04">적립P</label>
								<input type="tel" name="point" value="0" id="op04" data-role="none" />
							</div>
							<!--e: 적립포인트가 있는경우 -->			
							<div class="tb_option tb01">
								<p class="blt">
									<span class="op_blt opn01"></span>
									<span>
										<label for="op01">손실</label>
										<input type="tel" id="op01" data-role="none" name="lossAmount" value="0"/>
									</span>
									<span>
										<label for="op02">할인</label>
										<input type="tel" id="op02" data-role="none" name="discountAmount" value="0"/>
									</span>
									<a href="#discount_pop" class="btn_arr" data-rel="popup" data-position-to="window" data-transition="pop"></a>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"><span>청구금액</span></th>
						<td></td>
						<td class="a_tr"><input type="tel" name="chargeAmount" data-role="none" class="in_green" readonly/></td>
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
					<tr class="class-area-deposit" style="display:none">
						<th scope="row">예치금</th>
						<td><input type="checkbox" name="depositUse" id="id_deposit_use" value="Y"/><label for="id_deposit_use" class="brown">사용</label></td>
						<td class="a_tr"><input type="tel" name="depositAmount" data-role="none" value="0" readonly/></td>
					</tr>				
					<tr>
						<th scope="row">현금</th>
						<td class="take_out"><input type="checkbox" name="cashReceipt" id="id_cashReceipt" value="Y"/><label for="id_cashReceipt" class="brown">현금영수증</label></td>
						<td class="a_tr"><input type="tel" name="cash" data-role="none" /></td>
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
						<td><a href="#" class="btn_01 class-event-card-all">all</a> <a href="#" class="btn_01 class-event-card-left">나머지</a></td>
						<td class="a_tr"><input type="tel" name="cardAmount" data-role="none" value="0"/></td>
					</tr>
					
					<tr>
						<td colspan="3" class="a_tc">옵션없음
							<div class="tb_option tb02">
								<p class="blt">
									<span class="op_blt opn02"></span>
									<span class="btn_fl">
										<input type="checkbox" id="op03" name="creditProcess" value="Y"/><label for="op03" class="brown">외상처리</label>
										<input type="checkbox" id="op03_1" name="creditPay" value="Y"/><label for="op03_1" class="brown">외상갚기</label>
										<input type="checkbox" id="op03_2" name="depositProcess" value="Y"/><label for="op03_2" class="brown">예치</label>
									</span>
									<span>
										<label for="op04">적립P</label>
										<input type="tel" id="op04" data-role="none" name="customPoint" value="0"/>
									</span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"><span>거스름돈</span></th>
						<td></td>
						<td class="a_tr"><input type="tel" name="changeAmount" data-role="none" class="in_orange" readonly/></td>
					</tr>
					<tr>
						<th scope="row"><span>더받을돈</span></th>
						<td></td>
						<td class="a_tr"><input type="tel" name="addAmount" data-role="none" class="in_brown" readonly/></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btn_c tline">
			<a href="#" class="btn_white class-event-order-inquery">주문조회</a><a href="#" class="btn_white">취소</a><a href="#message_pop" class="btn_blue class-event-account-go" data-rel="popup" data-position-to="window" data-transition="pop">완료</a>
		</div>
		</form>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<a href="pos_memo.html" class="pnprev" data-ajax="false"><span>&lt;</span></a><!-- 개발에선 지워주세요 -->
			<p><span>메뉴를 선택하세요. 점심특선/포장 등은 기타</span></p>
			<a href="delivery_write.html" class="pnnext" data-ajax="false"><span>&gt;</span></a><!-- 개발에선 지워주세요 -->
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
					<dd><input type="tel" name="directDcRate" data-role="none" class="wp70" /> %</dd>
				</dl>
			</div>
			<div class="menu_list">
				<ul>
					<li><input type="radio" id="discountL_0" name="discountRate" value="0" checked/><label for="discountL_0">할인없음</label></li>
					<!-- 
					<li><input type="radio" id="discountL_02" name="discountL" /><label for="discountL_02">3%</label></li>
					<li><input type="radio" id="discountL_03" name="discountL" /><label for="discountL_03">5%</label></li>
					<li><input type="radio" id="discountL_04" name="discountL" /><label for="discountL_04">7%</label></li>
					<li><input type="radio" id="discountL_05" name="discountL" /><label for="discountL_05">10%</label></li>
					-->
				</ul>
			</div>
			<div class="btn_c line">
				<a href="#" class="btn_blue class-event-dcrate-save">확인</a><a href="#" class="btn_white" data-rel="back">취소</a>
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
	
	<!-- s: 주문 팝업 -->
	<div data-role="popup" id="order_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>주문조회</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="list maxh">
				<table>
					<colgroup>
						<col width="*" />
						<col width="7%" />
						<col width="17%" />
						<col width="25%" />
					</colgroup>
					<tbody>
						<!-- 
						<tr>
							<td class="a_tl"><strong>소갈비 - 한우</strong></td>
							<td>3</td>
							<td>16:43</td>
							<td class="price"><span class="dis">60,000</span><span>50,000</span></td>
						</tr>
						<tr>
							<td class="a_tl"><strong>양념갈비 - 한우</strong></td>
							<td>3</td>
							<td>16:43</td>
							<td class="price"><span>36,000</span></td>
						</tr>
						<tr>
							<td class="a_tl"><strong>소갈비 - 한우</strong></td>
							<td>6</td>
							<td>16:43</td>
							<td class="price"><span>120,000</span></td>
						</tr>
						 -->
					</tbody>
					<tfoot>
						<tr>
							<td class="a_tl">합계</td>
							<td class="price" colspan="3">78,000</td>
						</tr>
					</tfoot>
				</table>
			</div>
			<p class="pop_total">total : <span>10</span></p>
			<div class="btn_c">
				<a href="#" class="btn_blue" data-rel="back">확인</a>
				<!-- <a href="#" class="btn_white">수정</a> -->
			</div>
		</div>
	</div>
	<!--e: 주문 팝업 -->	
</div>
</body>
</html> 