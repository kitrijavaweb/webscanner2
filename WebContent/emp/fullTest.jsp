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
	<h3>전체검사</h3>
	<p class="lead">
		전체검사를 진행할 URL을 입력해주세요. <br />
	</p>
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
				<div class="jbTableCell jbSubmit"></div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<p>진행상황</p>
		<div class="progress">
			<div class="progress-bar progress-bar-striped progress-bar-animated"
				role="progressbar" aria-valuenow="75" aria-valuemin="0"
				aria-valuemax="100" style="width: 75%"></div>
		</div>
		<textarea class="form-control" id="exampleTextarea" rows="10">
                전체 검사 실행(10:00 경과)
                인젝션 취약점 점검중.....
                인젝션 취약점 점검 완료(02:00)
                
                다음 검사진행
                취약한 인증 점검중.....
                취약한 인증 점검 완료(05:00)
                 ......
                전체 검사 완료(총 15:00)
      </textarea>
	</div>
	<br />
	<br />
</body>
</html>