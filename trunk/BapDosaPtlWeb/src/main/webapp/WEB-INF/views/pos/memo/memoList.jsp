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
var recievedData;


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
	var popId = "memo_pop";
	
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
			popId = "memo_pop";
			if(memotype == 'A'){
				popId = "memo_pop";
			}else if(memotype == 'B' || memotype == 'C'){
				popId = "reservation_pop";
			}else if(memotype == 'I'){
				popId = "order_pop";
			}else if(memotype == 'K' || memotype == 'N'){
				popId = "delivery_pop";
			}
			var html = '';
			if(item.ischecked == 'Y'){
				html += '<tr class="gray">';
			}else{
				html += '<tr>';
			}
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
			
			var key = $this.closest("tr").find('td').eq(3).find('.hiddenKey').val();
			if(key == undefined) return;
			var keys = key.split('^');
			var param = "";
			if(keys.length >0){
				$('#memberid').val(keys[0]);
				$('#deviceid').val(keys[1]);
				$('#memoid').val(keys[2]);
				$('#memotype').val(keys[3]);
			}
			
		    if ($this.is(':checked')) {
				$this.closest("tr").addClass("gray");
				$('#ischecked').val('Y');
		    } else {
				$this.closest("tr").removeClass("gray");
				$('#ischecked').val('N');
		    }
		    
			changeCheckFlag();
		});		

		$("a").bind(selectEvent, function(event) {
			var key = $(this).siblings('.hiddenKey').attr('value');
			if(key == undefined) return;
			var keys = key.split('^');
			var param = "";
			if(keys.length >0){
				$('#memberid').val(keys[0]);
				$('#deviceid').val(keys[1]);
				$('#memoid').val(keys[2]);
				$('#memotype').val(keys[3]);
			}
			var memotype = keys[3];
			popId = "memo_pop";
			if(memotype == 'A'){
				popId = "memo_pop";
			}else if(memotype == 'B' || memotype == 'C'){
				popId = "reservation_pop";
			}else if(memotype == 'I'){
				popId = "order_pop";
			}else if(memotype == 'K' || memotype == 'N'){
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
				$('#' + popId).html(data);
				
				//주요메모로 보관 		
				$('#memos').change(function() {
				    var $this = $(this);
					if ($this.is(':checked')) {
						$('#isimportant').val('Y');
				    } else {
						$('#isimportant').val('N');
				    }
					console.log("isimportant",$('#isimportant').val());
					changeImportantFlag();
				});
			  })
			  .done(function() {
				    $('#' + popId).popup();
				    $('#' + popId).popup('open');			  
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

function changeCheckFlag(){
	var url = "${ContextPath}/pos/memo/modifyMemoIschecked.json";
	var param = $("#detailViewParamForm").serialize();
	$.ajax({
		url: url,
		type: 'post',
		data: param,
		dataType: "json",
		error:function (xhr, ajaxOptions, thrownError){
			
			alert("thrownError:"+thrownError);
		},
		success:function(data){
			console.log(data);			
		}
	});	
}

function changeImportantFlag(){
	var url = "${ContextPath}/pos/memo/modifyMemoIsimportant.json";
	var param = $("#detailViewParamForm").serialize();
	$.ajax({
		url: url,
		type: 'post',
		data: param,
		dataType: "json",
		error:function (xhr, ajaxOptions, thrownError){
			
			alert("thrownError:"+thrownError);
		},
		success:function(data){
			console.log(data);			
		}
	});	
}
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
					
				</tbody>
			</table>

			<div class="btn_c tline">
				<a href="#" class="btn_blue">예약</a>
				<a href="#" class="btn_blue">고객주문</a>
				<a href="#" class="btn_blue">메모</a>
				<a href="#" class="btn_white" data-rel="back">돌아가기</a>
			</div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>완료된 메모는 왼쪽 체킹 하면 색상이 희미해집니다.</span></p>
		</div>
	</div>

	<div data-role="popup" id="memo_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
	</div>
	<div data-role="popup" id="reservation_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
	</div>
	<div data-role="popup" id="order_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
	</div>
	<div data-role="popup" id="delivery_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
	</div>

	<form id="detailViewParamForm">
		<input type="hidden" name="memberid" id="memberid" value=""/>
		<input type="hidden" name="deviceid" id="deviceid" value=""/>
		<input type="hidden" name="memoid" id="memoid" value=""/>
		<input type="hidden" name="memotype" id="memotype" value=""/>
		<input type="hidden" name="ischecked" id="ischecked" value=""/>
		<input type="hidden" name="isimportant" id="isimportant" value=""/>
	</form>
</div>
</body>
</html> 