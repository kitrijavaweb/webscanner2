<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
.jumbotron { 
    background-color: #474e5d;
    color: #ffffff;
}

body{
    font: 16px "Montserrat", sans-serif;
    line-height: 1.8;
    color: #555555;
}
</style>
</head>
<body>
  <div class="jumbotron text-center">
    <h3>패턴등록</h3> 
    <p>Insert to pattern</p> 
  </div>
  <div class="input-group">
      <span class="input-group-addon">Text</span>
      <input id="pattern" type="text" class="form-control" name="msg" placeholder="Additional Info">
    </div>
    <div class="input-group">
      <span class="input-group-addon">Text</span>
      <input id="msg" type="text" class="form-control" name="msg" placeholder="Additional Info">
    </div>
</body>
</html>