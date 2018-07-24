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
  <h4>패턴목록</h4>
  <form>
  <div class="row justify-content-end">
  <div class="cols-md-4">
 	<select name="attackweb">
  		<option value="SQL" selected="selected">SQL인젝션</option>
  		<option value="Brute">BRUTE FORCE</option>
  		<option value="XSS">XSS(크로스사이트스크립트)</option>
	</select>
  </div>
  <div class="cols-md-4">
  <input id="msg" type="text" class="form-control" name="msg" placeholder="패턴등록">
  </div>
  <div class="cols-md-4">
  <button type="submit" class="btn btn-danger btn pull-right" style="font-size: 8pt">추가</button>
  </div>
  </div>
  </form>
  <input class="form-control" id="myInput" type="text" placeholder="패턴정보 검색  ex) SQL">
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th>패턴종류</th>
        <th>내용</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody id="myTable">
      <tr>
        <td>SQL INJECTION</td>
        <td>패턴1</td>
        <td><a href="#">삭제</a></td>
      </tr>
      <tr>
        <td>SQL INJECTION</td>
        <td>패턴2</td>
        <td><a href="#">삭제</a></td>
      </tr>
      <tr>
        <td>SQL INJECTION</td>
        <td>패턴3</td>
        <td><a href="#">삭제</a></td>
      </tr>
      <tr>
        <td>BRUTE FORCE</td>
        <td>패턴1</td>
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