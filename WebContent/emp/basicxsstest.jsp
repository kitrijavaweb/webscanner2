<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="EUC-KR">
<!-- �ΰ����� �׸� -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>CSS Tips</title>
<style>
.jbTable {
	display: table;
	width: 100%;
}

.jbTableRow {
	display: table-row;
}

.jbTableCell {
	display: table-cell;
}

.jbText {
	width: 100%;
}

.jbSubmit {
	width: 1%;
}

.jbText input {
	width: 100%;
}
</style>
</head>
<body>
		<h3>�κа˻�-XXS(ũ�ν�����Ʈ��ũ��Ʈ)</h3>
		<p class="lead">�κа˻縦 ������ URL�� �Է����ּ���.</p>
		<hr class="my-4">
		<div class="jbTable">
			<div class="jbTableRow">
				<div class="jbTableCell jbText">
					<div>
					<div class="cols-md-8">
						<input type="url" placeholder="url���Ŀ� �°� �Է� �ٶ��ϴ�.">
					</div>
					<div class="cols-md-4">
						<button class="btn btn-success btn pull-right" type="button">START</button>
						<button class="btn btn-danger btn pull-right" type="button">STOP</button>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<p>�����Ȳ</p>
		<div class="progress">
			<div class="progress-bar progress-bar-striped progress-bar-animated"
				role="progressbar" aria-valuenow="75" aria-valuemin="0"
				aria-valuemax="100" style="width: 75%;"></div>
		</div>
			<SCRIPT LANGUAGE="JavaScript">
				var request; // URL ��û�� ���� ������ �޾ƿ� ��ü

				/*	
				 ��û ��ü ������ ���� ���� �Լ� 
				
				 �Ű�����:
				 regType: HTTP ��û ����. GET �Ǵ� POST
				 url: ���� ���α׷��� URL
				 asynch: ���� �Ǵ� �񵿱� ��� ����
				 */
				function httpRequest(reqType, url, asynch) {
					if (window.XMLHttpRequest) // ������ ��� ������(�׽�������, ���̾�����)
					{
						request = new XMLHttpRequest();
					} else if (window.ActiveXObject) // IE ��� ������
					{
						request = new ActiveXObject("MSXML2.XMLHTTP"); // IE 6 �̸�

						if (!request) {
							request = new ActiveXObject("Microsoft.XMLHTTP"); // IE 6 �̻�			
						}
					}

					if (request) {
						initReq(reqType, url, asynch);
					} else {
						alert("�� �������� Ajax �� �������� �ʽ��ϴ�.");
					}
				}

				/*
				 ������ ��û ��ü�� �ʱ�ȭ
				
				 �Ű�����:
				 regType: HTTP ��û ����. GET �Ǵ� POST
				 url: ���� ���α׷��� URL
				 asynch: ���� �Ǵ� �񵿱� ��� ����. true �Ǵ� false
				 */
				function initReq(reqType, url, asynch) {
					request.onreadystatechange = handleRespone; // CallBack �Լ� ����	
					request.open(reqType, url, asynch);
					request.send(null);
				}

				/*
				 Ajax ���� �� CallBack �Լ�
				 */
				function handleRespone() {
					if (request.readyState == 4) {
						// ���� �ٿ�ε尡 �Ϸ�Ǿ��°�?
						if (request.status == 200) {
							// ������ ���������� �ε�Ǿ��°�?
							result = request.responseText;
							tdSourceView.innerText = result;
						} else {
							alert("�ش� URL �� ���������� �������� �� �߽��ϴ�.");
						}
					}
				}

				/*
				 ���� ����Ʈ �Լ�
				 */
				function fnViewSource(arg) {
					var url = arg;

					//txtSourceView.value = "";
					tdSourceView.innerText = "";

					if (url.length > 0) {
						if (url.substring(0, 7).toLowerCase() != "http://") {
							url = "http://" + url;
						}
						httpRequest("GET", url, true);
					} else {
						alert("�ҽ����� URL �� �Է��ϼ���");
						txtURL.focus();
					}
				}
			</SCRIPT>

			<TABLE width="100%">
				<TR height="23px">
					<TD>
						<TABLE width="100%" height="100%">
							<TR>
								<TD width="140px">�ҽ����� URL</TD>
								<TD><INPUT TYPE="text" NAME="txtURL" style="width: 100%;"
									onFocus="this.select();"></TD>
								<TD width="40px"><INPUT TYPE="button" VALUE="�ҽ� ����"
									ONCLICK="fnViewSource(txtURL.value)"></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
				<TR>
					<TD>
						<TABLE width="100%" height="100%" border="1">
							<TR>
								<TD id="tdSourceView" width="100%" height="100%"></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</div>
		</div>

</body>
</html>