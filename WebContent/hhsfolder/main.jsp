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
<title>2議� ��濡�����</title>
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
	<!-- 硫��� 濡�洹� �� --> <!-- �ъ�대��硫��� ���� -->
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
		<!-- �ъ�대�� ��泥닿���  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="��泥닿���"><a class="nav-link"
				href="#"> <i class="fa fa-fw fa-dashboard"></i> <span
					class="nav-link-text">��泥닿���</span>
			</a>
			<!-- �ъ�대�� 遺�遺�寃���  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="遺�遺�寃���"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#collapseComponents" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-wrench"></i> <span class="nav-link-text">遺�遺�寃���</span>
			</a>
				<ul class="sidenav-second-level collapse" id="collapseComponents">
					<li><a href="#">SQL�몄����</a></li>
					<li><a href="#">痍⑥�쏀���몄�</a></li>
					<li><a href="#">�곗�댄�곕�몄�</a></li>
					<li><a href="#">XSS(�щ��ㅼ�ъ�댄�몄�ㅽ�щ┰��)</a></li>
					<li><a href="#">痍⑥�쏀�� ��洹쇳�듭��</a></li>
				</ul></li>
				<!-- �ъ�대�� 寃��ш껐怨�  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="寃��ш껐怨�"><a class="nav-link"
				href="#"> <i class="fa fa-fw fa-area-chart"></i> <span
					class="nav-link-text">寃��ш껐怨�</span>
			</a></li>
		</ul>
		<!--�ъ�대��硫��� ��  -->
		<!--�ъ�대�� ���⑤��� ����  -->
		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item"><a class="nav-link text-center"
				id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
			</a></li>
		</ul>
		<!--�ъ�대�� ���⑤��� ��  -->
		<!-- ���⑤��� ���� -->
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
            <i class="fa fa-fw fa-sign-out"></i>濡�洹몄����</a>
        </li>
		</ul>
		<!-- ���⑤��� �� -->
	</div>
	</nav>
	<div class="content-wrapper">
    <div class="container-fluid">
    <!-- ���댁� 異�媛� 遺�遺� -->
    
    
    
    
    
    
    
    
    
    
    
    
    
    <!-- ���댁� 異�媛� 遺�遺� -->
      </div>
    </div>
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright 짤 �듯�⑸낫�� 3湲� 2李⑦��濡����� 2議� 2018</small>
        </div>
      </div>
    </footer>
    <!-- �ㅽ�щ· & ��踰���-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- 濡�洹몄���� modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" style="display: none;" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">濡�洹몄����</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">�</span>
            </button>
          </div>
          <div class="modal-body">���� ������ 醫�猷� ��怨��띠�쇱���ㅻ㈃ "濡�洹몄����"踰��쇱�� ���ъ＜������.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">痍⑥��</button>
            <a class="btn btn-primary" href="login.jsp">濡�洹몄����</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>

