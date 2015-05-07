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
<script type="text/javascript" src="../../js/pos/reservation.js"></script>
</head>
<body>
<div data-role="page" id="reservation-page" data-url="demo-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>예약</h1>
	</div>
	<div data-role="content">
		<!--s: 테이블 목록 -->
		<div class="table_map list6">
			<ul>
<!-- 				<li>
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
				</li> -->
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
							<input type="number" id="" value="010" data-role="none" class="wp20" /> -
							<input type="number" id="" value="4585" data-role="none" class="wp20" /> -
							<input type="number" id="" value="0558" data-role="none" class="wp20" />
						</td>
					</tr>
					<tr>
						<th scope="row">시간</th>
						<td>
							<span class="timeset"><a href="#dayset_pop" data-rel="popup" data-position-to="window" data-transition="pop"></a></span>
							<a href="#" class="btn_01 mins">+1</a>
							<span class="timeset"><a href="#timeset_pop" data-rel="popup" data-position-to="window" data-transition="pop"></a></span>
							<!-- <input type="time" id="" data-role="none" class="wp31" /> -->
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
							<input type="checkbox" id="sms_send" /><label for="sms_send">예약</label>
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
			<a href="memo_list.html" class="pnprev" data-ajax="false"><span>&lt;</span></a><!-- 개발에선 지워주세요 -->
			<p><span>먼저 예약할 좌석을 선택하세요.(복수도 가능)</span></p>
			<a href="pos_ask.html" class="pnnext" data-ajax="false"><span>&gt;</span></a><!-- 개발에선 지워주세요 -->
		</div>
	</div>

	<!-- s: 예약일 설정 팝업 -->
	<div data-role="popup" id="dayset_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>예약날짜 설정</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="month_head">
				<div class="day">
					<a href="#" class="btnd daypre" title="이전"></a>
					<strong>10</strong> <span>月</span>
					<a href="#" class="btnd daynex" title="다음"></a>
				</div>
			</div>
			<div class="month_tb">
				<table>
					<colgroup>
						<col width="15%" />
						<col width="14%" />
						<col width="14%" />
						<col width="14%" />
						<col width="14%" />
						<col width="14%" />
						<col width="15%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">일</th>
							<th scope="col">월</th>
							<th scope="col">화</th>
							<th scope="col">수</th>
							<th scope="col">목</th>
							<th scope="col">금</th>
							<th scope="col">토</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>1</td>
							<td>2</td>
							<td>3</td>
						</tr>
						<tr>
							<td>4</td>
							<td>5</td>
							<td>6</td>
							<td>7<p class="s_data">3</p></td>
							<td>8</td>
							<td>9</td>
							<td>10</td>
						</tr>
						<tr>
							<td>11</td>
							<td>12</td>
							<td>13</td>
							<td>14</td>
							<td>15</td>
							<td>16</td>
							<td>17</td>
						</tr>
						<tr>
							<td>18</td>
							<td>19</td>
							<td>20</td>
							<td>21</td>
							<td>22</td>
							<td>23</td>
							<td>24</td>
						</tr>
						<tr>
							<td>25</td>
							<td>26</td>
							<td>27</td>
							<td>28</td>
							<td>29</td>
							<td>30</td>
							<td>31</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">취소</a>
			</div>
		</div>
	</div>
	<!--e: 예약일 설정 팝업 -->
	
	<!-- s: 예약시간 설정 팝업 -->
	<div data-role="popup" id="timeset_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>예약시간 설정</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="time_wrap">
				<div class="time_box one">
					<div class="time_admin">
						<div class="btn_ud bup">
							<ul>
								<li><a href="#" title="오전오후"></a></li>
								<li><a href="#" title="시간"></a></li>
								<li><a href="#" title="분"></a></li>
							</ul>
						</div>
						<div class="time_line">
							<ul>
								<li><span>오전</span> <span>12</span> : <span>00</span></li>
							</ul>
						</div>
						<div class="btn_ud bdown">
							<ul>
								<li><a href="#" title="시간"></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue">저장</a><a href="#" class="btn_white" data-rel="back">취소</a>
			</div>
		</div>
	</div>
	<!--e: 예약시간 설정 팝업 -->

</div>
</body>
</html> 