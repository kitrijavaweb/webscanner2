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
  <title>WebScanner - 회원가입</title>
  <!-- Bootstrap core CSS-->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="../css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">회원가입</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-12">
                <label for="InputName">Name</label>
                <input class="form-control" id="InputName" type="text" aria-describedby="nameHelp" placeholder="이름">
              </div>
               </div>
          </div>
          <div class="form-group">
            <label for="InputEmail1">Email address</label>
            <input class="form-control" id="InputEmail1" type="email" aria-describedby="emailHelp" placeholder="이메일 주소">
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="InputPassword1">Password</label>
                <input class="form-control" id="InputPassword1" type="password" placeholder="비밀번호">
              </div>
              <div class="col-md-6">
                <label for="ConfirmPassword">Confirm password</label>
                <input class="form-control" id="ConfirmPassword" type="password" placeholder="비밀번호 재입력">
              </div>
            </div>
          </div>
          <a class="btn btn-primary btn-block" href="login.jsp">가입하기</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.jsp">로그인 페이지</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>