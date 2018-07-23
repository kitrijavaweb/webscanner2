<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>WebScanner - 관리자페이지</title>
</head>
<body>
<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
		<!-- 사이드 회원관리  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="회원관리"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#customer" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-users"></i> <span class="nav-link-text">회원관리</span>
			</a>
				<ul class="sidenav-second-level collapse" id="customer">
					<li><a href="#">회원조회</a></li>
					<li><a href="#">회원정보수정</a></li>
					<li><a href="#">회원탈퇴</a></li>
				</ul></li>
			<!-- 사이드 패턴관리  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="패턴관리"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#weaknessPartten" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-wrench"></i> <span class="nav-link-text">패턴관리</span>
			</a>
				<ul class="sidenav-second-level collapse" id="weaknessPartten">
					<li><a href="#">SQL인젝션패턴관리</a></li>
					<li><a href="#">XML인젝션패턴관리</a></li>
					<li><a href="#">패턴삭제</a></li>
				</ul></li>
		</ul>
</body>
</html>