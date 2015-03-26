<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
</head>
<body>
	<!-- s: ���� �˾� -->
	<div data-role="popup" id="reservation_pop" data-overlay-theme="b" data-theme="a" data-dismissible="false">
		<div data-role="header" data-theme="a">
			<h1 class="has_num"><span class="table_number">${detailData.memberid}</span>������ȸ</h1>
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
					<dd>${detailData.contents}</dd>
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

</body>
</html> 