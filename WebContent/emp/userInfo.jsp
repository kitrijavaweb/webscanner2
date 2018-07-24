<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
body{
    font: 16px "Montserrat", sans-serif;
    line-height: 1.8;
    color: #555555;
}

</style>

</head>
<body>
<div class="container">
  <h4>회원목록</h4>
  <input class="form-control" id="myInput" type="text" placeholder="회원정보 검색  ex) test">
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>계정</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>가입일</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody id="myTable">
      <tr>
        <td>test@naver.com</td>
        <td>test</td>
        <td>김진</td>
        <td>2018/07/24</td>
        <td><a href="#">삭제</a></td>
      </tr>
      <tr>
        <td>tkaektn@naver.com</td>
        <td>tkaektn12</td>
        <td>삼다수</td>
        <td>2018/05/11</td>
        <td><a href="#">삭제</a></td>
      </tr>
      <tr>
        <td>coca@test.com</td>
        <td>zhffk</td>
        <td>콜라</td>
        <td>2018/07/24</td>
        <td><a href="#">삭제</a></td>
      </tr>
      <tr>
        <td>admin</td>
        <td>admin</td>
        <td>어드민</td>
        <td>2018/07/24</td>
        <td><a href="#">삭제</a></td>
      </tr>
    </tbody>
  </table>
  
</div>

<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
</body>
</html>