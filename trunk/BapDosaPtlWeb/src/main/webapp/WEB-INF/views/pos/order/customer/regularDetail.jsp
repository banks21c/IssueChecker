<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
<title>가게노트</title>
<link rel="stylesheet" href="${ContextPath}/css/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="${ContextPath}/css/style.css" />
<script type="text/javascript" src="${ContextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ContextPath}/js/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
<div data-role="page" id="demo-page" data-url="demo-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="설정" data-role="none"></a>
		<h1>단골고객</h1>
	</div>
	<div data-role="content">
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
		<div class="btn_c tline">
			<a href="#credit_pop" class="btn_blue" data-rel="popup" data-position-to="window" data-transition="pop">외상잔액 조정</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>단골고객 선택하거나 직접 입력하세요.</span></p>
		</div>
	</div>

	<!-- s: 외상잔액 조정 팝업 -->
	<div data-role="popup" id="credit_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>외상잔액 조정</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="credit_write">
				<dl>
					<dt>장부상 외상잔액</dt>
					<dd><input type="text" id="" data-role="none" class="disable" disabled="disabled" /></dd>
				</dl>
				<dl>
					<dt>실제 외상잔액</dt>
					<dd><input type="text" id="" data-role="none" /></dd>
				</dl>
				<dl>
					<dt>조정액</dt>
					<dd><input type="text" id="" data-role="none" class="disable" disabled="disabled" /></dd>
				</dl>
			</div>
			<div class="credit_key">
				<p class="credit_info">일단 1/1일자로 외상잔액이 증액됩니다. </p>
				<div class="keypad">
					<ul>
						<li><a href="#"><span>1</span></a></li>
						<li><a href="#"><span>2</span></a></li>
						<li><a href="#"><span>3</span></a></li>
						<li><a href="#"><span>4</span></a></li>
						<li><a href="#"><span>5</span></a></li>
						<li><a href="#"><span>6</span></a></li>
						<li><a href="#"><span>7</span></a></li>
						<li><a href="#"><span>8</span></a></li>
						<li><a href="#"><span>9</span></a></li>
						<li><a href="#"><span>-</span></a></li>
						<li><a href="#"><span>0</span></a></li>
						<li><a href="#"><span>.</span></a></li>
					</ul>
				</div>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue">확인</a><a href="#" class="btn_white" data-rel="back">취소</a>
			</div>
		</div>
	</div>
	<!--e: 외상잔액 조정 팝업 -->

</div>
</body>
</html> 