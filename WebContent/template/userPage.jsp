<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>WebScanner - �����������</title>
</head>
<body>
<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
		<!-- ���̵� ��ü�˻�  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="��ü�˻�"><a class="nav-link"
				href="/webscanner/main/full.do"> <i class="fa fa-fw fa-desktop"></i> <span
					class="nav-link-text">��ü�˻�(X)</span>
			</a>
			<!-- ���̵� �κа˻�  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="�κа˻�"><a
				class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
				href="#weakness" data-parent="#exampleAccordion"> <i
					class="fa fa-fw fa-list-alt"></i> <span class="nav-link-text">�κа˻�</span>
			</a>
				<ul class="sidenav-second-level collapse" id="weakness">
					<li><a href="/webscanner/main/scan/SqlScan.do">SQL Injection</a></li>
					<li><a href="/webscanner/main/scan/bruteForceScan.do">����� ����(Brute Force)</a></li>
					<li><a href="/webscanner/main/scan/xssScan.do">XSS(ũ�ν�����Ʈ��ũ��Ʈ)</a></li>
				</ul></li>
				<!-- ���̵� �˻���  -->
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="" data-original-title="�˻���"><a class="nav-link"
				href="/webscanner/main/resultuser.do"> <i class="fa fa-fw fa-area-chart"></i> <span
					class="nav-link-text">�˻���</span>
			</a></li>
		</ul>
</body>
</html>