<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript" src="../../../../js/common/common.js"></script>
<script type="text/javascript" src="../../../../js/common/util.js"></script>
<script type="text/javascript" src="../../../../js/pos/setting/setting.js"></script>

</head>
<body>
<div data-role="page" id="admin-page" data-url="admin-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_home" title="home" data-role="none"></a>
		<h1>설정</h1>
	</div>
	<div data-role="content">
		<div class="admin_list">
			<dl>
				<dt><span>테이블 개수 조절</span><a href="#" class="save class_admin_save1">저장</a></dt>
				<dd>
					<p class="tb_ad class_table_count">
						<span class="stb"></span>
						<input type="number" id="" class="class_table_input" data-role="none" class="wp20" />
					</p>
				</dd>
				<dt><span>점심시간 점심특선메뉴 앞으로</span><a href="#" class="save">저장</a></dt>
				<dd>
					<div class="time_set">
						<p class="time_yn">
							<input type="radio" id="timeY" name="timeYN" /><label for="timeY">예</label>
							<input type="radio" id="timeN" name="timeYN" /><label for="timeN">아니오</label>
						</p>
						   <div class="time_wrap">
								<p class="diferente"><input type="checkbox" id="timec" class="class_setting_time_differ"/><label for="timec">점심 시간대 요일마다 다르게 설정</label></p>
								<div class="time_box">
									<!--s: 할인시간대 요일마다 다르게 설정 경우 -->
									<div class="week_choice tab" id="id_setting_set_time_differ" style="display:none">
										<ul>
											<li><a href="#" class="active" >월</a></li>
											<li><a href="#">화</a></li>
											<li><a href="#">수</a></li>
											<li><a href="#">목</a></li>
											<li><a href="#">금</a></li>
											<li class="week_blue"><a href="#">토</a></li>
											<li class="week_red"><a href="#">일</a></li>
										</ul>
									</div>
									<!--e: 할인시간대 요일마다 다르게 설정 경우 -->
									<div class="time_admin">
										<div class="btn_ud bup">
											<ul>
												<li><a href="#" id="id_setting_am_btn" class="class_setting_am_pm" title="오전오후"></a></li>
												<li><a href="#" id="id_setting_hour_plus_btn" title="시간"></a></li>
												<li><a href="#" id="id_setting_minute_btn" title="분"></a></li>
											</ul>
											<ul>
												<li><a href="#" id="id_setting_pm_btn" class="class_setting_am_pm" title="오전오후"></a></li>
												<li><a href="#" id="id_setting_hour2_plus_btn" title="시간"></a></li>
												<li><a href="#" id="id_setting_minute2_btn"title="분"></a></li>
											</ul>
										</div>
										<div class="time_line">
											<ul>
												<li><span id="id_setting_am_text">오전</span> <span id="id_setting_hour_text" >12</span> : <span id="id_setting_minute_text">00</span></li>
												<li><span id="id_setting_pm_text">오후</span> <span id="id_setting_hour2_text">12</span> : <span id="id_setting_minute2_text">00</span></li>
											</ul>
										</div>
										<div class="btn_ud bdown">
											<ul>
												<li><a href="#" id="id_setting_hour_minus_btn" title="시간"></a></li>
											</ul>
											<ul>
												<li><a href="#" id="id_setting_hour2_minus_btn" title="시간"></a></li>
											</ul>
										</div>
										<!-- <div class="times start">
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
										</div> -->
									</div>
									<div class="week_choice" id="id_setting_time_same">
										<ul>
											<li><input type="checkbox" id="week_01" /><label for="week_01">월</label></li>
											<li><input type="checkbox" id="week_02" /><label for="week_02">화</label></li>
											<li><input type="checkbox" id="week_03" /><label for="week_03">수</label></li>
											<li><input type="checkbox" id="week_04" /><label for="week_04">목</label></li>
											<li><input type="checkbox" id="week_05" /><label for="week_05">금</label></li>
											<li><input type="checkbox" id="week_06" /><label for="week_06" class="week_blue">토</label></li>
											<li><input type="checkbox" id="week_07" /><label for="week_07" class="week_red">일</label></li>
										</ul>
									</div>
								</div>
						</div>
					</div>
				</dd>
				<dt><span>할인율 편집</span><a href="#" class="save">저장</a></dt>
				<dd>
					<div class="discount_admin">
						<ul>
							<li><input type="number" data-role="none" id="" value="3" /> %</li>
							<li><input type="number" data-role="none" id="" value="5" /> %</li>
							<li><input type="number" data-role="none" id="" value="7" /> %</li>
							<li><input type="number" data-role="none" id="" value="10" /> %</li>
						</ul>
					</div>
				</dd>
				<dt><span>전국랭킹-임차료,평수 수정</span><a href="#" class="save">저장</a></dt>
				<dd>
					<div class="ranking_set">
						<h4>평수 기준</h4>
						<ul>
							<li><input type="radio" id="pshL01" name="pshL1" /><label for="pshL01">3평이하</label></li>
							<li><input type="radio" id="pshL02" name="pshL1" /><label for="pshL02">4~5</label></li>
							<li><input type="radio" id="pshL03" name="pshL1" /><label for="pshL03">6~10</label></li>
							<li><input type="radio" id="pshL04" name="pshL1" /><label for="pshL04">11~15</label></li>
							<li><input type="radio" id="pshL05" name="pshL1" /><label for="pshL05">16~20</label></li>
							<li><input type="radio" id="pshL06" name="pshL1" /><label for="pshL06">20~25</label></li>
							<li><input type="radio" id="pshL07" name="pshL1" /><label for="pshL07">26~30</label></li>
							<li><input type="radio" id="pshL08" name="pshL1" /><label for="pshL08">31~40</label></li>
							<li><input type="radio" id="pshL09" name="pshL1" /><label for="pshL09">41~50</label></li>
							<li><input type="radio" id="pshL10" name="pshL1" /><label for="pshL10">51~70</label></li>
							<li><input type="radio" id="pshL11" name="pshL1" /><label for="pshL11">71~100</label></li>
							<li><input type="radio" id="pshL12" name="pshL1" /><label for="pshL12">초대형</label></li>
						</ul>
						<h4>임차료 기준</h4>
						<ul>
							<li><input type="radio" id="pshL201" name="pshL2" /><label for="pshL201">30만이하</label></li>
							<li><input type="radio" id="pshL202" name="pshL2" /><label for="pshL202">40~50</label></li>
							<li><input type="radio" id="pshL203" name="pshL2" /><label for="pshL203">60~70</label></li>
							<li><input type="radio" id="pshL204" name="pshL2" /><label for="pshL204">80~100</label></li>
							<li><input type="radio" id="pshL205" name="pshL2" /><label for="pshL205">110~150</label></li>
							<li><input type="radio" id="pshL206" name="pshL2" /><label for="pshL206">160~200</label></li>
							<li><input type="radio" id="pshL207" name="pshL2" /><label for="pshL207">210~300</label></li>
							<li><input type="radio" id="pshL208" name="pshL2" /><label for="pshL208">310~400</label></li>
							<li><input type="radio" id="pshL209" name="pshL2" /><label for="pshL209">410~500</label></li>
							<li><input type="radio" id="pshL210" name="pshL2" /><label for="pshL210">510~700</label></li>
							<li><input type="radio" id="pshL211" name="pshL2" /><label for="pshL211">710~900</label></li>
							<li><input type="radio" id="pshL212" name="pshL2" /><label for="pshL212">초대형</label></li>
						</ul>
					</div>
				</dd>
				<dt><span>고객요구사항 내용 편집</span><a href="#" class="save">저장</a></dt>
				<dd>
					<div class="memo_set">
						<!--s: 고객 요구사항 등록되어 있는 목록들이 보여짐 -->
						<ul class="class_customer_request">
							<li><input type="text" id="" data-role="none" class="wp80" /></li>
						</ul>
						<!--e: 고객 요구사항 등록되어 있는 목록들이 보여짐 -->
					</div>
				</dd>
				<dt><span>배달-집합건물 수정/삭제</span><a href="#" class="save">저장</a></dt>
				<dd>
					<div class="structure_set">
						<ul>
							<li>
								<input type="text" id="" data-role="none" class="wp60" /> <span class="ico a">아</span>
								<a href="#" class="del">삭제</a>
							</li>
							<li>
								<input type="text" id="" data-role="none" class="wp60" /> <span class="ico bd">빌</span>
								<a href="#" class="del">삭제</a>
							</li>
						</ul>
					</div>
				</dd>
				<dt><span>배달관리-수거 메뉴 보이기 여부</span><a href="#" class="save">저장</a></dt>
				<dd>
					<p><input type="checkbox" id="delivery_view" name="delivery_view" /><label for="delivery_view">수거메뉴 보이기</label></p>
				</dd>
			</dl>
		</div>
	</div>
	<div class="btn_c ">
			<a href="#" class="btn_white" data-rel="back">돌아가기</a>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<!-- <a href="" class="pnprev"><span>&lt;</span></a> --><!-- 개발에선 지워주세요 -->
			<p><span>주문→테이블터치, 메뉴설정→메뉴버튼</span></p>
			<!-- <a href="order_list.html" class="pnnext" data-ajax="false"><span>&gt;</span></a>개발에선 지워주세요 -->
		</div>
	</div>
</div>
</body>
</html> 