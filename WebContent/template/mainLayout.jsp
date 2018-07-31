<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap core CSS-->
<link href="/webscanner/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="/webscanner/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="/webscanner/css/sb-admin.css" rel="stylesheet">
<title>WebScanner - 메인</title>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav" style=""> <a class="navbar-brand" href="#">WebScanner</a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- 메인 로그 끝 --> <!-- 사이드메뉴 시작 -->
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<!-- 사이드 메뉴시작  -->
		    <jsp:include page="${menupath }"/>
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
    <jsp:include page="${viewpath }"/>
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
            <a class="btn btn-primary" href="/webscanner/webLogout.do">로그아웃</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript [하단 화살표 이벤트]-->
    <script src="/webscanner/vendor/jquery/jquery.min.js"></script>
    <script src="/webscanner/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="/webscanner/js/sb-admin.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="/webscanner/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="/webscanner/vendor/datatables/jquery.dataTables.js"></script>
    <script src="/webscanner/vendor/datatables/dataTables.bootstrap4.js"></script>
</body>
</html>