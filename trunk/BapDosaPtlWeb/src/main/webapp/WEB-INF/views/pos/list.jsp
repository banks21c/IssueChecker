<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text; charset=euc-kr" />
<title>가게노트</title>
<style type="text/css">
	body {background:none;background-color:#f5f5f5}
	a:link		{text-decoration:underline;color:#777}
	a:visited	{text-decoration:underline;color:#777}
	a:hover	{text-decoration:underline;color:#399be2}
	a:active	{text-decoration:underline;color:#399be2}
	.list_wrap {margin:0 0 20px 0}
	.list_wrap h1 {text-align:center;padding:20px 0;background-color:#4d595d;color:#fff;font-size:20px}
	.list_style {border-top:1px solid #000}
	.list_style th:first-child {border-left:1px solid #000}
	.list_style th {border-right:1px solid #000;border-bottom:1px solid #333;padding:5px;background-color:#333;font-weight:bold;color:#fff}
	.list_style td {border-right:1px solid #ddd;border-bottom:1px solid #ddd;padding:5px;border-top:none;background-color:#fff}
	.list_style td.gray {background-color:#e4e4e6;font-weight:bold;text-align:center;border-left:1px solid #ddd}
	.list_style td em {color:#ff0000}
	.list_style td em.modify {color:#00a4b3}
	.list_style td.day {font-size:10px;text-align:center}
	.list_style .no_data {padding:1px;border-left:1px solid #ddd}
	.blue {color:#2a8ad0;font-weight:bold;font-size:11px;letter-spacing:-1px;text-align:center}
</style>
</head>
<body>
	<div class="list_wrap">
		<h1>가게노트</h1>
		<table class="list_style">
			<colgroup>
				<col width="18%" />
				<col width="18%" />
				<col width="16%" />
				<col width="16%" />
				<col width="17%" />
				<col width="*" />
				<col width="8%" />
			</colgroup>
			<thead>
			<tr>
				<th scope="col">1뎁스</th>
				<th scope="col">2뎁스</th>
				<th scope="col">3뎁스</th>
				<th scope="col">4뎁스</th>
				<th scope="col">파일경로</th>
				<th scope="col">파일명</th>
				<th scope="col">비고</th>
				<th scope="col">update</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td class="gray" rowspan="12">POS</td>
				<td>메인</td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="./main/posMain.ui">pos_main.html</a></td>
				<td></td>
				<td class="day">2015.03.20</td>
			</tr>
			<tr>
				<td rowspan="3">주문</td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="./order/orderMain.ui">order_list.html</a></td>
				<td></td>
				<td class="day">2015.03.18</td>
			</tr>
			<tr>
				<td rowspan="2">단골</td>
				<td>목록</td>
				<td></td>
				<td><a href="./order/customer/regularList.ui">frequenter_list.html</a></td>
				<td></td>
				<td class="day">2015.03.23</td>
			</tr>
			<tr>
				<td>보기</td>
				<td></td>
				<td><a href="./order/customer/regularDetail.ui">frequenter_view.html</a></td>
				<td></td>
				<td class="day">2015.03.23</td>
			</tr>
			<tr>
				<td>카테고리 편집</td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="./category/categoryManage.ui">menu_manager01.html</a></td>
				<td></td>
				<td class="day">2015.03.19</td>
			</tr>
			<tr>
				<td>메뉴추가</td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="./menu/menuManage.ui">menu_manager02.html</a></td>
				<td></td>
				<td class="day">2015.03.19</td>
			</tr>
			<tr>
				<td>포인트/할인율 설정</td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="./point/pointManage.ui">menu_manager03.html</a></td>
				<td></td>
				<td class="day">2015.03.19</td>
			</tr>
			<tr>
				<td rowspan="4">메모</td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="./memo/memoList.ui">memo_list.html</a></td>
				<td></td>
				<td class="day">2015.03.20</td>
			</tr>
			<tr>
				<td>예약</td>
				<td></td>
				<td></td>
				<td><a href="./memo/reservation.ui">pos_reserve.html</a></td>
				<td></td>
				<td class="day">2015.03.20</td>
			</tr>
			<tr>
				<td>고객요구</td>
				<td></td>
				<td></td>
				<td><a href="./memo/customerRequest.ui">pos_ask.html</a></td>
				<td></td>
				<td class="day">2015.03.20</td>
			</tr>
			<tr>
				<td>메모</td>
				<td></td>
				<td></td>
				<td><a href="./memo/memoRegist.ui">pos_memo.html</a></td>
				<td></td>
				<td class="day">2015.03.20</td>
			</tr>
			<tr>
				<td>계산</td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="./calculation/calculation.ui">account.html</a></td>
				<td></td>
				<td class="day">2015.03.20</td>
			</tr>
			<tr>
				<td colspan="8" class="no_data"></td>
			</tr>
			</tbody>
		</table>
	</div>
</body>
</html>