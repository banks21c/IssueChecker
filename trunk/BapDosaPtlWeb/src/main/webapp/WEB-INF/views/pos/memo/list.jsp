<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

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
						<td><a href="#reservation_pop" data-rel="popup" data-position-to="window" data-transition="pop">�輺��8��(010-5555-5555) 17</a></td>
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

	<!-- s: ���� �˾� -->
	<div data-role="popup" id="reservation_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1 class="has_num"><span class="table_number">16</span>������ȸ</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="data_view">
				<dl>
					<dt>������</dt>
					<dd>������ <a href="tel:010-5566-7788">010-5566-7788</a></dd>
				</dl>
				<dl>
					<dt>��������</dt>
					<dd>10-10(��) ���� 07:00</dd>
				</dl>
				<dl>
					<dt>�����ο�</dt>
					<dd>7��</dd>
				</dl>
				<dl>
					<dt>�޸�</dt>
					<dd>10ȸ ����ȸ</dd>
				</dl>
				<dl>
					<dt>SMS</dt>
					<dd><em>2</em>�ð� �� ���ں�����</dd>
				</dl>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue" data-rel="back">Ȯ��</a><a href="#" class="btn_white">����</a>
			</div>
		</div>
	</div>
	<!--e: ���� �˾� -->

	<!-- s: ��� �˾� -->
	<div data-role="popup" id="delivery_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>�����ȸ</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="data_view">
				<dl>
					<dt>��޿���</dt>
					<dd><em>��޽���</em></dd>
				</dl>
				<dl>
					<dt>��ü</dt>
					<dd>���α׷�����</dd>
				</dl>
				<dl>
					<dt>�ּ�</dt>
					<dd>����� �ѽ� ���ھ� B�� 102-123ȣ</dd>
				</dl>
				<dl>
					<dt>����ó</dt>
					<dd><a href="tel:010-5566-7788">010-5566-7788</a></dd>
				</dl>
				<dl>
					<dt>�����</dt>
					<dd>�̹�� <a href="tel:010-5566-7788">010-5566-7788</a></dd>
				</dl>
				<dl>
					<dt>�޸�</dt>
					<dd>���ǿ� �������ּ���</dd>
				</dl>
			</div>
			<div class="btn_c">
				<a href="#" class="btn_blue" data-rel="back">Ȯ��</a>
			</div>
		</div>
	</div>
	<!--e: ��� �˾� -->

	<!-- s: �޸� �˾� -->
	<div data-role="popup" id="memo_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>�޸���ȸ</h1>
			<a href="#" data-rel="back" data-role="none" class="close ui-btn-right"></a>
		</div>
		<div role="main" class="ui-content">
			<div class="memo_box">
				<p>�޸� ���� ���ϴ�~</p>
			</div>
			<p class="point_memo">
				<input type="checkbox" id="memos" data-role="none" /><label for="memos">�ֿ�޸�� ����</label>
			</p>
			<div class="btn_c">
				<a href="#" class="btn_blue" data-rel="back">Ȯ��</a><a href="#" class="btn_white">����</a>
			</div>
		</div>
	</div>
	<!--e: �޸� �˾� -->

	<!-- s: �ֹ� �˾� -->
	<div data-role="popup" id="order_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1>�ֹ���ȸ</h1>
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
							<td class="a_tl"><strong>�Ұ��� - �ѿ�</strong></td>
							<td>3</td>
							<td>16:43</td>
							<td class="price">60,000</td>
						</tr>
						<tr>
							<td class="a_tl"><strong>��䰥�� - �ѿ�</strong></td>
							<td>3</td>
							<td>16:43</td>
							<td class="price">36,000</td>
						</tr>
						<tr>
							<td class="a_tl"><strong>�Ұ��� - �ѿ�</strong></td>
							<td>6</td>
							<td>16:43</td>
							<td class="price">120,000</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td class="a_tl">�հ�</td>
							<td class="price" colspan="3">78,000</td>
						</tr>
					</tfoot>
				</table>
			</div>
			<p class="pop_total">total : <span>10</span></p>
			<div class="btn_c">
				<a href="#" class="btn_blue" data-rel="back">Ȯ��</a><a href="#" class="btn_white">����</a>
			</div>
		</div>
	</div>
	<!--e: �ֹ� �˾� -->

</div>
</body>
</html> 