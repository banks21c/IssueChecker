<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
<title>가게노트</title>
<link rel="stylesheet" href="../../css/jquery.mobile-1.4.5.min.css" />
<link rel="stylesheet" href="../../css/style.css" />
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery.mobile-1.4.5.min.js"></script>
<script>
$(document).ready(function() {

	var url = "/bapdosaptlweb/pos/memo/getMemoList.json";
	var param = "";
	$.ajax({
		url: url,
		type: 'post',
		data: param,
		dataType: "json",
		error:function (xhr, ajaxOptions, thrownError){
			
			alert("thrownError:"+thrownError);
		},
		success:function(data){
			if(typeof console != 'undefined'){		
				console.log(data);					
			}
			
			if(data.returnJsonVO){
				
				if(data.returnJsonVO && data.returnJsonVO.returnObj){
					makeList(data.returnJsonVO.returnObj, "listTable");
				}	
				
			} else {
				alert("오류가 발생했습니다.");
			}
			
		}
	});
	
	function makeList(returnObj,id){
		$.each(returnObj, function (i, item) {
		    console.log(item.memberid);
		    console.log(item.deviceid);
		    console.log(item.memoid);
		    console.log(item.deliverymasterid);
		    console.log(item.orderid);
		    console.log(item.startsalesdate);
		    console.log(item.memotype);
		    console.log(item.codename);
		    console.log(item.reservid);
		    console.log(item.requestid);
		    console.log(item.tradeid);
		    console.log(item.contents);
		    console.log(item.creationdate);
		    console.log(item.isimportant);
		    console.log(item.ischecked);
		    console.log(item.isdeleted);
		    console.log(item.modificationdate);
		    
			var html = '';
			html += '<tr>';
			html += '<td class="a_tc"><input type="checkbox" id="" data-role="none"></td>';
			html += '<td class="data">21:32</td>';
			html += '<td>'+item.codename+'</td>';
			html += '<td><a href="#reservation_pop" data-rel="popup" data-position-to="window" data-transition="pop" aria-haspopup="true" aria-owns="reservation_pop" aria-expanded="false" class="ui-link">'+item.contents+'</a></td>';
			html += '</tr>';
			$('#'+id).append(html);
		});
	}	
		
});
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
		<div class="top_total">
			total : <span>26</span>
		</div>
		<div class="memo_list">
			<table id="listTable">
				<colgroup>
					<col width="10%" />
					<col width="16%" />
					<col width="20%" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>예약</td>
						<td><a href="#reservation_pop" data-rel="popup" data-position-to="window" data-transition="pop">김성기8명(010-5555-5555) 17</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>배달실패</td>
						<td><a href="#delivery_pop" data-rel="popup" data-position-to="window" data-transition="pop">정명세무그룹 주소불명 정명세무그룹 주소불명</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>메모</td>
						<td><a href="#memo_pop" data-rel="popup" data-position-to="window" data-transition="pop">계란 김씨 8시 도착</a></td>
					</tr>
					<tr class="gray">
						<td class="a_tc"><input type="checkbox" id="" data-role="none" checked="checked" /></td>
						<td class="data">21:32</td>
						<td>식권</td>
						<td><span class="tover">20</span></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>포장</td>
						<td><a href="#order_pop" data-rel="popup" data-position-to="window" data-transition="pop">14번 포장메뉴 추가</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>식권</td>
						<td><a href="#">정명세무그룹 거스름돈 정명세무그룹 거스름돈</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>식권</td>
						<td><a href="#">20</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>배달실패</td>
						<td><span class="tover">정명세무그룹 주소불명 정명세무그룹 주소불명</span></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>식권</td>
						<td><a href="#">정명세무그룹 거스름돈 정명세무그룹 거스름돈</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>식권</td>
						<td><a href="#">20</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>배달실패</td>
						<td><span class="tover">정명세무그룹 주소불명 정명세무그룹 주소불명</span></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>식권</td>
						<td><a href="#">정명세무그룹 거스름돈 정명세무그룹 거스름돈</a></td>
					</tr>
				</tbody>
			</table>

			<div class="btn_c tline">
				<a href="#" class="btn_blue">예약</a><a href="#" class="btn_blue">고객주문</a><a href="#" class="btn_blue">메모</a><a href="#" class="btn_white" data-rel="back">돌아가기</a>
			</div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>완료된 메모는 왼쪽 체킹 하면 색상이 희미해집니다.</span></p>
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