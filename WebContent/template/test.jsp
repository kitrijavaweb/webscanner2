<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
	<a class="navbar-brand" href="#">WebScanner</a>
	<!--상단 메뉴  -->
  	<ul class="navbar-nav ml-auto">
      <li class="active"><a class="nav-link text-center" href="#">Home</a></li>
      <li><a class="nav-link text-center" href="#">Page 1</a></li>
      <li><a class="nav-link text-center" href="#">Page 2</a></li>
    </ul>
    <!--상단메뉴 끝  -->
	<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <!--사이드메뉴 시작  -->
    <div class="collapse navbar-collapse" id="navbarResponsive">
    <ul class ="navbar-nav navbar-sidenav" id="exampleAccordion">
    <!-- 사이드 메뉴 - 전체검사  -->
    	<li class="nav-item" data-toggle="tooltip" data-placement="right" title data-original-title="전체검사">
    	 <a class="nav-link" href="#">
    	 	<i class="fa fa-fw fa-dashboard"></i>
    	 	<span class="nav-link-text">전체검사</span>
    	 </a>
    	</li>
    <!-- 사이드 메뉴 - 전체검사 끝  -->
    <!-- 사이드 메뉴 - 부분검사 시작  -->
    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="" data-original-title="부분검사">
          <a class="nav-link nav-link-collapse" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion" aria-expanded="true">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">부분검사</span>
          </a>
          <ul class="sidenav-second-level collapse show" id="collapseComponents" style="">
            <li>
              <a href="#">인젝션</a>
            </li>
            <li>
              <a href="#">취약한 인증</a>
            </li>
            <li>
              <a href="#">민감한 데이터 노출</a>
            </li>
            <li>
              <a href="#">XSS</a>
            </li>
            <li>
              <a href="#">취약한 접근통제</a>
            </li>
          </ul>
        </li>
            <!-- 사이드 메뉴 - 부분검사 끝  -->
            
    </ul>
        <!-- 사이드 메뉴 - 끝 -->
        
        <!-- 사이드 하단 메뉴 -시작  -->
      	<!-- 사이드 하단 메뉴 -끝 -->
      	<!-- 상단 메뉴 -시작  -->
        <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="login.jsp">
            <i class="fa fa-fw fa-sign-out"></i>로그아웃</a>
        </li>
        </ul>
        <!-- 상단 메뉴 - 끝 -->
    </div>
<nav>

</body>
</html>