<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
<title>���Գ�Ʈ</title>
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
				alert("������ �߻��߽��ϴ�.");
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
			html += '<tr id="tr"'+i+'>';
			html += '<td class="a_tc"><input type="checkbox" id="chk'+i+'" data-role="none"></td>';
			html += '<td class="data">'+item.time+'</td>';
			html += '<td>'+item.codename+'</td>';
			html += '<td><a href="#reservation_pop" data-rel="popup" data-position-to="window" data-transition="pop" aria-haspopup="true" aria-owns="reservation_pop" aria-expanded="false" class="ui-link">'+item.contents+'</a></td>';
			html += '</tr>';
			$('#'+id).append(html);
		});
		
		$('input:checkbox').click(function() {
			console.log("aa");
		    var $this = $(this);
		    if ($this.is(':checked')) {
				console.log($this.attr("id"));
		    } else {
				console.log($this.attr("id"));
		    }
		});		
	}
	
	$("#more").bind("tap", function(event) {
//  		$.post('getMemoDetail.json', "param", function(data) {
//  			$('#popupDiv').html(data);
// 			    $('#reservation_pop').popup();
// 			    $('#reservation_pop').popup('open');			
//  		});
		
		
		// Assign handlers immediately after making the request,
		// and remember the jqxhr object for this request
		var jqxhr = $.post( "getMemoDetail.json", function(data) {
			$('#popupDiv').html(data);
		})
		  .done(function() {
			    $('#reservation_pop').popup();
			    $('#reservation_pop').popup('open');			  
		  })
		  .fail(function() {
		    console.log( "error" );
		  })
		  .always(function() {
		    console.log( "finished" );
		});		
	});

	$('input:checkbox').click(function() {
		console.log("kk");
	    var $this = $(this);
	    if ($this.is(':checked')) {
			console.log($this.attr("id"));
	    } else {
			console.log($this.attr("id"));
	    }
	});
		
});
</script>
</head>
<body>
<div data-role="page" id="demo-page" data-url="demo-page">
	<div data-role="header" data-position="fixed">
		<a href="#" class="topbtn btn_poshome" title="home" data-role="none"></a>
		<a href="#" class="topbtn btn_home2" title="home" data-role="none"></a>
		<a href="#" class="btn_admin" title="����" data-role="none"></a>
		<h1>��������</h1>
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
						<td>����</td>
						<td><a href="#reservation_pop" id="more" data-rel="popup" data-position-to="window" data-transition="pop">�輺��8��(010-5555-5555) 17</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>��޽���</td>
						<td><a href="#delivery_pop" data-rel="popup" data-position-to="window" data-transition="pop">�������׷� �ּҺҸ� �������׷� �ּҺҸ�</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>�޸�</td>
						<td><a href="#memo_pop" data-rel="popup" data-position-to="window" data-transition="pop">��� �达 8�� ����</a></td>
					</tr>
					<tr class="gray">
						<td class="a_tc"><input type="checkbox" id="" data-role="none" checked="checked" /></td>
						<td class="data">21:32</td>
						<td>�ı�</td>
						<td><span class="tover">20</span></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>����</td>
						<td><a href="#order_pop" data-rel="popup" data-position-to="window" data-transition="pop">14�� ����޴� �߰�</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>�ı�</td>
						<td><a href="#">�������׷� �Ž����� �������׷� �Ž�����</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>�ı�</td>
						<td><a href="#">20</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>��޽���</td>
						<td><span class="tover">�������׷� �ּҺҸ� �������׷� �ּҺҸ�</span></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>�ı�</td>
						<td><a href="#">�������׷� �Ž����� �������׷� �Ž�����</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>�ı�</td>
						<td><a href="#">20</a></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>��޽���</td>
						<td><span class="tover">�������׷� �ּҺҸ� �������׷� �ּҺҸ�</span></td>
					</tr>
					<tr>
						<td class="a_tc"><input type="checkbox" id="" data-role="none" /></td>
						<td class="data">21:32</td>
						<td>�ı�</td>
						<td><a href="#">�������׷� �Ž����� �������׷� �Ž�����</a></td>
					</tr>
				</tbody>
			</table>

			<div class="btn_c tline">
				<a href="#" class="btn_blue">����</a><a href="#" class="btn_blue">���ֹ�</a><a href="#" class="btn_blue">�޸�</a><a href="#" class="btn_white" data-rel="back">���ư���</a>
			</div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
		<div class="help">
			<p><span>�Ϸ�� �޸�� ���� üŷ �ϸ� ������ ��������ϴ�.</span></p>
		</div>
	</div>

	<div id="popupDiv" class="ui-screen-hidden">
	</div>

</div>
</body>
</html> 