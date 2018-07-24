<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>WebScanner - 로그인</title>
  <!-- Bootstrap core CSS-->
  <link href="/webscanner/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="/webscanner/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="/webscanner/css/sb-admin.css" rel="stylesheet">
  <style type="text/css">
  body{
  background-image: url("https://post-phinf.pstatic.net/MjAxNzAzMjdfMTY0/MDAxNDkwNTc2ODExNDQy.53oCxWZ0zWW3JvBWmOhkQQguVYe9lrH2MNnzd2hLWtQg.-ntAGaWH-WZ9-aUdQmuyfOezMGHc-qvMbzNpm_fKYqIg.JPEG/LG-CNS_%EB%B3%B4%EC%95%88_1.jpg?type=w1200");
  background-size:cover;
  }
  </style>
</head>
<body>
<form name="login_frm" action="/webscanner/webMain.do" method="post">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">로그인</div>
      <div class="card-body">
          <div class="form-group">
            <label for="InputEmail1">Email address</label>
            <input class="form-control" name="id" id="InputEmail1" type="email" aria-describedby="emailHelp" placeholder="이메일 주소">
          </div>
          <div class="form-group">
            <label for="InputPassword1">Password</label>
            <input class="form-control" id="InputPassword1" type="password" placeholder="비밀번호">
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> 이메일 주소 기억하기</label>
            </div>
          </div>
                <button class="btn btn-primary btn-block" type="submit">로그인</button>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.jsp">회원가입</a>
        </div>
      </div>
    </div>
  </div>
  <script src="/webscanner/vendor/jquery/jquery.min.js"></script>
  <script src="/webscanner/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="/webscanner/vendor/jquery-easing/jquery.easing.min.js"></script>
  </form>
</body>

</html>