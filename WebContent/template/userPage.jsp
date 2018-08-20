<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>WebScanner - 사용자페이지</title>
</head>
<body>
<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
		<!-- 사이드 전체검사  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="전체검사"><a class="nav-link"
				href="/webscanner/main/full.do"> <i class="fa fa-fw fa-desktop"></i> <span
					class="nav-link-text">전체검사(X)</span>
			</a>
			<!-- 사이드 부분검사  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="부분검사"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#weakness" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-list-alt"></i> <span class="nav-link-text">부분검사</span>
			</a>
				<ul class="sidenav-second-level collapse" id="weakness">
					<li><a href="/webscanner/main/scan/SqlScan.do">SQL Injection</a></li>
					<li><a href="/webscanner/main/scan/bruteForceScan.do">취약한 인증(Brute Force)</a></li>
					<li><a href="/webscanner/main/scan/xssScan.do">XSS(크로스사이트스크립트)</a></li>
				</ul></li>
				<!-- 사이드 검사결과  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="검사결과"><a class="nav-link"
				href="/webscanner/main/resultuser.do"> <i class="fa fa-fw fa-area-chart"></i> <span
					class="nav-link-text">검사결과</span>
			</a></li>
		</ul>
</body>
</html>