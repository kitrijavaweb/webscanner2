<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="EUC-KR">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
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
body{
    font: 16px "Montserrat", sans-serif;
    line-height: 1.8;
    color: #555555;
}
</style>
</head>
<body>
	<h3>XSS(크로스 사이트 스크립트)</h3>
	<p class="lead">
		전체검사를 진행할 URL을 입력해주세요. <br />
	</p>
	<hr class="my-4">
	<div class="jbTable">
		<div class="jbTableRow">
			<div class="jbTableCell jbText">
				<div>
					<div class="cols-md-8">
						<input type="url" id="url" placeholder="url형식에 맞게 입력 바랍니다.">
					</div>
					<div class="cols-md-4">
						<button class="btn btn-success btn pull-right" type="button" id="scanstart">START</button>
						<button class="btn btn-danger btn pull-right" type="button" id="scanstop">STOP</button>
					</div>
				</div>
				<div class="jbTableCell jbSubmit"></div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<p>진행상황</p>
		<textarea class="form-control" id="resultText" rows="10" disabled="disabled">
      </textarea>
	</div>
	<br />
	<br />
	<script src="/webscanner/js/scan/xssScan.js" charset='UTF-8'></script>
</body>
</html>