<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
</head>
<body>
	<!-- s: 예약 팝업 -->
	<div data-role="popup" id="reservation_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1 class="has_num"><span class="table_number">${detailData.memberid}</span>예약조회</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
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
					<dd>${detailData.contents}</dd>
				</dl>
				<dl>
					<dt>SMS</dt>
					<dd><em>2</em>시간 전 문자보내기</dd>
				</dl>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue" data-rel="back">확인</a><a href="#" class="btn_white">수정</a>
			</div>
		</div>
	</div>
	<!--e: 예약 팝업 -->

	<!-- s: 배달 팝업 -->
	<div data-role="popup" id="delivery_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>배달조회</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="data_view">
				<dl>
					<dt>배달여부</dt>
					<dd><em>배달실패</em></dd>
				</dl>
				<dl>
					<dt>업체</dt>
					<dd>세부그룹정명</dd>
				</dl>
				<dl>
					<dt>주소</dt>
					<dd>잠원동 한신 뉴코아 B동 102-123호</dd>
				</dl>
				<dl>
					<dt>연락처</dt>
					<dd><a href="tel:010-5566-7788">010-5566-7788</a></dd>
				</dl>
				<dl>
					<dt>담당자</dt>
					<dd>이배달 <a href="tel:010-5566-7788">010-5566-7788</a></dd>
				</dl>
				<dl>
					<dt>메모</dt>
					<dd>경비실에 연락해주세요</dd>
				</dl>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue" data-rel="back">확인</a>
			</div>
		</div>
	</div>
	<!--e: 배달 팝업 -->

	<!-- s: 메모 팝업 -->
	<div data-role="popup" id="memo_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>메모조회</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="memo_box">
				<p>메모 내용 들어갑니다~</p>
			</div>
			<p class="point_memo">
				<input type="checkbox" id="memos" data-role="none" /><label for="memos">주요메모로 보관</label>
			</p>
			<div class="btn_c">
				<a href="#" class="btn_blue" data-rel="back">확인</a><a href="#" class="btn_white">수정</a>
			</div>
		</div>
	</div>
	<!--e: 메모 팝업 -->

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
						<tr>
							<td class="a_tl"><strong>소갈비 - 한우</strong></td>
							<td>3</td>
							<td>16:43</td>
							<td class="price">60,000</td>
						</tr>
						<tr>
							<td class="a_tl"><strong>양념갈비 - 한우</strong></td>
							<td>3</td>
							<td>16:43</td>
							<td class="price">36,000</td>
						</tr>
						<tr>
							<td class="a_tl"><strong>소갈비 - 한우</strong></td>
							<td>6</td>
							<td>16:43</td>
							<td class="price">120,000</td>
						</tr>
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
				<a href="#" class="btn_blue" data-rel="back">확인</a><a href="#" class="btn_white">수정</a>
			</div>
		</div>
	</div>
	<!--e: 주문 팝업 -->

</body>
</html> 