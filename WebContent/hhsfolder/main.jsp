<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap core CSS-->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="../vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="../css/sb-admin.css" rel="stylesheet">
<!-- Bootstrap core JavaScript-->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
<!-- Page level plugin JavaScript-->
<script src="../vendor/chart.js/Chart.min.js"></script>
<script src="../vendor/datatables/jquery.dataTables.js"></script>
<script src="../vendor/datatables/dataTables.bootstrap4.js"></script>
<!-- Custom scripts for all pages-->
<script src="../js/sb-admin.min.js"></script>
<!-- Custom scripts for this page-->
<script src="../js/sb-admin-datatables.min.js"></script>
<script src="../js/sb-admin-charts.min.js"></script>
<title>2조 프로젝트</title>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav" style=""> <a class="navbar-brand" href="main.jsp">WebScanner</a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- 메인 로그 끝 --> <!-- 사이드메뉴 시작 -->
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
		<!-- 사이드 전체검사  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="전체검사"><a class="nav-link"
				href="#"> <i class="fa fa-fw fa-dashboard"></i> <span
					class="nav-link-text">전체검사</span>
			</a>
			<!-- 사이드 부분검사  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="부분검사"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#collapseComponents" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-wrench"></i> <span class="nav-link-text">부분검사</span>
			</a>
				<ul class="sidenav-second-level collapse" id="collapseComponents">
					<li><a href="#">SQL인젝션</a></li>
					<li><a href="#">취약한인증</a></li>
					<li><a href="#">데이터노출</a></li>
					<li><a href="#">XSS(크로스사이트스크립트)</a></li>
					<li><a href="#">취약한 접근통제</a></li>
				</ul></li>
				<!-- 사이드 검사결과  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="검사결과"><a class="nav-link"
				href="#"> <i class="fa fa-fw fa-area-chart"></i> <span
					class="nav-link-text">검사결과</span>
			</a></li>
		</ul>
		<!--사이드메뉴 끝  -->
		<!--사이드 하단메뉴 시작  -->
		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item"><a class="nav-link text-center"
				id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
			</a></li>
		</ul>
		<!--사이드 하단메뉴 끝  -->
		<!-- 상단메뉴 시작 -->
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
				<form class="form-inline my-2 my-lg-0 mr-lg-2">
					<div class="input-group">
						<input class="form-control" type="text"
							placeholder="Search for..."> <span
							class="input-group-append">
							<button class="btn btn-primary" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
			</li>
			<li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>로그아웃</a>
        </li>
		</ul>
		<!-- 상단메뉴 끝 -->
	</div>
	</nav>
	<div class="content-wrapper">
    <div class="container-fluid">
    <!-- 페이지 추가 부분 -->
    
    
    
    
    
    
    
    
    
    
    
    
    
    <!-- 페이지 추가 부분 -->
      </div>
    </div>
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © 융합보안 3기 2차프로젝트 2조 2018</small>
        </div>
      </div>
    </footer>
    <!-- 스크롤 & 탑버튼-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- 로그아웃 modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">로그아웃</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">현재 작업을 종료 하고싶으시다면 "로그아웃"버튼을 눌러주십시오.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
            <a class="btn btn-primary" href="login.jsp">로그아웃</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>