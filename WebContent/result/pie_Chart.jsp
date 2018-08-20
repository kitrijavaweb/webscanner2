<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/webscanner/js/chart/Chart.bundle.js"></script>
<script src="/webscanner/js/chart/utils.js"></script>
<script src="/webscanner/js/chart/excute.js"></script>
<link rel="stylesheet" href="/webscanner/css/chart.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 차트 시작 -->
			<div class="col-md-5">
				<div id="canvas-holder" style="width: 100%">
					<canvas id="chart-area"></canvas>
				</div>
			</div>
			<div class="col-md-7">
				<div id="container" style="width: 75%">
					<canvas id="canvas"></canvas> 
				</div>
			</div>
		</div>
		<!--목록 출력  -->
		<div class="row">
			<div class="col-md-12">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr id="tr_userTable">
								<th>#</th>
								<th>위험도</th>
								<th>취약점명</th>
								<th>설명 및 대응방안</th>
								<th>발견지점</th>
								<th>바로가기</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td><span class="label label-danger">위험</span></td>
								<th>SQL injection<br />(Basic)
								</th>
								<td><span id="getdecrp">사용자의 입력 값 등 외부 입력 값이 SQL 쿼리에 삽입되어 공격자가 쿼리를
										조작해 공격할 수 있는 보안약점</span><br /> - 대응방안<br /> ①웹 서버의 오류 정보가 사용자에게
									노출되지 않도록 조치<br /> ②웹 어플리케이션과 연동되는 데이터베이스의 접근 권한을 최소화<br />
									③사용자 입력 폼(로그인 폼, 검색 폼, URL 등)을 대상으로 특수문자, 특수구문 필터링 규칙 적용<br />
									④홈페이지 소스코드는 사용자로부터 입력되는『입력 값』에 대한 검증과 예외처리<br /></td>
								<td>http://localhost:8088/webscanner/result/pie_Chart.jsp</td>
								<td><a
									href="http://localhost:8088/webscanner/result/pie_Chart.jsp">이동</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td><span class="label label-warning">주의</span></td>
								<td>취약한 인증<br />(Brute Force)
								</td>
								<td><span id="getdecrp">무차별적으로 데이터를 삽입공격하는 기법</span><br /> - 대응방안<br />
									①접근하는 IP통제 (허용IP등록, 사내 IP만 사용)<br /> ②MAC기반 접근통제<br /> ③국내
									IP허용, 해외IP 차단<br /> ④패스워드 복잡도 올리고 최대한 길게<br /> ⑤보안정책에 의해 로그인
									실패 시 자동차단<br /></td>
								<td>http://localhost:8088/webscanner/result/pie_Chart.jsp</td>
								<td><a
									href="http://localhost:8088/webscanner/result/pie_Chart.jsp">이동</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var color = Chart.helpers.color;
	var barChartData = {
		labels : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월' ],
		datasets : [
				{
					label : 'SQL Injection',
					backgroundColor : color(window.chartColors.red).alpha(0.5)
							.rgbString(),
					borderColor : window.chartColors.red,
					borderWidth : 1,
					data : [ 10,20,30,40,50,60,70 ]
				},
				{
					label : '취약한인증',
					backgroundColor : color(window.chartColors.blue).alpha(0.5)
							.rgbString(),
					borderColor : window.chartColors.blue,
					borderWidth : 1,
					data : [ 10,20,30,40,50,60,70 ]
				} ]

	};
	</script>
</body>
</html>