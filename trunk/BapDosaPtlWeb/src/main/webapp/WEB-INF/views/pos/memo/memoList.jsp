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
<script>
$(document).ready(function() {
	var useragent = navigator.userAgent.toLowerCase();
	/**
	*모바일에서 접속했는지, PC에서 접속했는지 구분해서 이벤트를 준다.
	*/
	var connectDevice = "mobile";
	var selectEvent = "";
	if( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
		connectDevice = "mobile";
		selectEvent = "touchstart";
	}else{
		connectDevice = "pc";
		selectEvent = "click";
	}
	console.log("connect device:"+connectDevice);
	
	var url = "${ContextPath}/pos/memo/getMemoList.json";
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
				alert("오류발생");
			}
			
		}
	});
	
	function makeList(returnObj,id){
		$.each(returnObj, function (i, item) {
			var memotype = item.memotype;
			var popId = "memo_pop";
			if(memotype == 'A'){
				popId = "memo_pop";
			}else if(memotype == 'B'){
				popId = "reservation_pop";
			}else if(memotype == 'I'){
				popId = "order_pop";
			}else if(memotype == 'K'){
				popId = "delivery_pop";
			}
			var html = '';
			html += '<tr>';
			html += '<td class="a_tc"><input type="checkbox" id="chk'+i+'" data-role="none"></td>';
			html += '<td class="data">'+item.time+'</td>';
			html += '<td>';
			html += item.codename;
			html += '</td>';
			html += '<td>';
			html += '<a href="#'+popId+'" data-rel="popup" data-position-to="window" data-transition="pop" aria-haspopup="true" aria-owns="'+popId+'" aria-expanded="false" class="ui-link">'+item.contents+'</a>';
			html += '<input type="hidden" class="hiddenKey" name="key" value="'+item.memberid+'^'+item.deviceid+'^'+item.memoid+'^'+item.memotype+'"/>';
			html += '</td>';
			html += '</tr>';
			$('#'+id).append(html);
		});
		
		$('input:checkbox').click(function() {
		    var $this = $(this);
		    if ($this.is(':checked')) {
				console.log($this.closest("tr").addClass("gray"));
		    } else {
				console.log($this.closest("tr").removeClass("gray"));
		    }
		});		

		$("a").bind(selectEvent, function(event) {
			var key = $(this).siblings('.hiddenKey').attr('value');
			var keys = key.split('^');
			var param = "";
			if(keys.length >0){
				$('#memberid').val(keys[0]);
				$('#deviceid').val(keys[1]);
				$('#memoid').val(keys[2]);
				$('#memotype').val(keys[3]);
			}
			var memotype = keys[3];
			var popId = "memo_pop";
			if(memotype == 'A'){
				popId = "memo_pop";
			}else if(memotype == 'B'){
				popId = "reservation_pop";
			}else if(memotype == 'I'){
				popId = "order_pop";
			}else if(memotype == 'K'){
				popId = "delivery_pop";
			}
			
//	  		$.post('getMemoDetail.json', "param", function(data) {
//	  			$('#popupDiv').html(data);
//	 			    $('#reservation_pop').popup();
//	 			    $('#reservation_pop').popup('open');			
//	  		});
			
			
			// Assign handlers immediately after making the request,
			// and remember the jqxhr object for this request
			var jqxhr = $.post( "getMemoDetail.json",$("#detailViewParamForm").serialize(),function(data) {
				console.log("data:"+data);
				$('#popupDiv').html(data);
			})
			  .done(function() {
				    $('#'+popId).popup();
				    $('#'+popId).popup('open');			  
			  })
			  .fail(function() {
			    console.log( "error" );
			  })
			  .always(function() {
			    console.log( "finished" );
			});		
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
						<td><a href="#reservation_pop" id="more" data-rel="popup" data-position-to="window" data-transition="pop">김성기8명(010-5555-5555) 17</a></td>
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


	<div id="popupDiv" class="ui-screen-hidden">
	</div>

	<form id="detailViewParamForm">
		<input type="hidden" name="memberid" id="memberid" value=""/>
		<input type="hidden" name="deviceid" id="deviceid" value=""/>
		<input type="hidden" name="memoid" id="memoid" value=""/>
		<input type="hidden" name="memotype" id="memotype" value=""/>
	</form>
</div>
</body>
</html> 