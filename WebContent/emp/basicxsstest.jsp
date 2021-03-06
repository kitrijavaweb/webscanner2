<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="EUC-KR">
<!-- 부가적인 테마 -->
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
		<h3>부분검사-XXS(크로스사이트스크립트)</h3>
		<p class="lead">부분검사를 진행할 URL을 입력해주세요.</p>
		<hr class="my-4">
		<div class="jbTable">
			<div class="jbTableRow">
				<div class="jbTableCell jbText">
					<div>
					<div class="cols-md-8">
						<input type="url" placeholder="url형식에 맞게 입력 바랍니다.">
					</div>
					<div class="cols-md-4">
						<button class="btn btn-success btn pull-right" type="button">START</button>
						<button class="btn btn-danger btn pull-right" type="button">STOP</button>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<p>진행상황</p>
		<div class="progress">
			<div class="progress-bar progress-bar-striped progress-bar-animated"
				role="progressbar" aria-valuenow="75" aria-valuemin="0"
				aria-valuemax="100" style="width: 75%;"></div>
		</div>
			<SCRIPT LANGUAGE="JavaScript">
				var request; // URL 요청에 대한 응답을 받아올 객체

				/*	
				 요청 객체 생성을 위한 랩퍼 함수 
				
				 매개변수:
				 regType: HTTP 요청 유형. GET 또는 POST
				 url: 서버 프로그램의 URL
				 asynch: 동기 또는 비동기 모드 선택
				 */
				function httpRequest(reqType, url, asynch) {
					if (window.XMLHttpRequest) // 모질라 기반 브라우저(네스케이프, 파이어폭스)
					{
						request = new XMLHttpRequest();
					} else if (window.ActiveXObject) // IE 기반 브라우저
					{
						request = new ActiveXObject("MSXML2.XMLHTTP"); // IE 6 이만

						if (!request) {
							request = new ActiveXObject("Microsoft.XMLHTTP"); // IE 6 이상			
						}
					}

					if (request) {
						initReq(reqType, url, asynch);
					} else {
						alert("이 브라우저는 Ajax 를 지원하지 않습니다.");
					}
				}

				/*
				 생성된 요청 객체의 초기화
				
				 매개변수:
				 regType: HTTP 요청 유형. GET 또는 POST
				 url: 서버 프로그램의 URL
				 asynch: 동기 또는 비동기 모드 선택. true 또는 false
				 */
				function initReq(reqType, url, asynch) {
					request.onreadystatechange = handleRespone; // CallBack 함수 지정	
					request.open(reqType, url, asynch);
					request.send(null);
				}

				/*
				 Ajax 실행 후 CallBack 함수
				 */
				function handleRespone() {
					if (request.readyState == 4) {
						// 문서 다운로드가 완료되었는가?
						if (request.status == 200) {
							// 문서가 정상적으로 로드되었는가?
							result = request.responseText;
							tdSourceView.innerText = result;
						} else {
							alert("해당 URL 에 정상적으로 접근하지 못 했습니다.");
						}
					}
				}

				/*
				 시작 포인트 함수
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
						alert("소스보기 URL 을 입력하세요");
						txtURL.focus();
					}
				}
			</SCRIPT>

			<TABLE width="100%">
				<TR height="23px">
					<TD>
						<TABLE width="100%" height="100%">
							<TR>
								<TD width="140px">소스보기 URL</TD>
								<TD><INPUT TYPE="text" NAME="txtURL" style="width: 100%;"
									onFocus="this.select();"></TD>
								<TD width="40px"><INPUT TYPE="button" VALUE="소스 보기"
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