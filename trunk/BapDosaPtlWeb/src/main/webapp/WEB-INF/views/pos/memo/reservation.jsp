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
		<h1>예약</h1>
	</div>
	<div data-role="content">
		<!--s: 테이블 목록 -->
		<div class="table_map list6">
			<ul>
				<li>
					<div class="table_info active">
						<a href="#">
							<span class="number">1</span>
							<span class="sales">999</span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">2</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">3</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">4</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">5</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">6</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">7</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">8</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">9</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">10</span>
							<span class="in_time"></span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">11</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">12</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">13</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">14</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">15</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">16</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">17</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">18</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">19</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">20</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">21</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">22</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">23</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
				<li>
					<div class="table_info">
						<a href="#">
							<span class="number">24</span>
							<span class="sales"></span>
						</a>
					</div>
				</li>
			</ul>
		</div>
		<!--e: 테이블 목록 -->
		<div class="reserve_list">
			<dl>
				<dt>예약<br />현황</dt>
				<dd>
					<ul>
						<li><a href="#" class="active">13:00<br />예약</a></li>
						<li><a href="#" class="active">15:00<br />예약</a></li>
						<li><a href="#" class="active">10/11<br />예약</a></li>
						<li><a href="#">예약<br />추가</a></li>
						<li><a href="#">예약<br />추가</a></li>
					</ul>
				</dd>
			</dl>
		</div>
		<div class="write2">
			<table>
				<colgroup>
					<col width="70" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">예약고객</th>
						<td>
							<input type="text" id="" value="최은혜" data-role="none" class="wp20 active" /><!-- input 작성시 class:active 추가-->
							<input type="text" id="" value="010" data-role="none" class="wp20" /> -
							<input type="text" id="" value="4585" data-role="none" class="wp20" /> -
							<input type="text" id="" value="0558" data-role="none" class="wp20" />
						</td>
					</tr>
					<tr>
						<th scope="row">시간</th>
						<td>
							<input type="date" id="" value="" data-role="none" class="wp31" />
							<a href="#" class="btn_01 mins">+1</a>
							<input type="time" id="" data-role="none" class="wp31" />
							<input type="number" id="" data-role="none" class="wp10" /> 명
						</td>
					</tr>
					<tr>
						<th scope="row">메모</th>
						<td><input type="text" id="" data-role="none" class="wp95 a_tl" /></td>
					</tr>
					<tr>
						<th scope="row">SMS</th>
						<td>
							<input type="checkbox" id="sms_send" data-role="none" /><label for="sms_send">예약</label>
							<input type="number" id="" data-role="none" class="wp15" /> 시간 전 문자보내기
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="btn_c tline">
			<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white">예약해제</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>먼저 예약할 좌석을 선택하세요.(복수도 가능)</span></p>
		</div>
	</div>

	<!-- s: 예약 팝업 -->
	<div data-role="popup" id="reservation_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1 class="has_num"><span class="table_number">16</span>예약조회</h1>
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
					<dd>10회 동문회</dd>
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

</div>
</body>
</html> 