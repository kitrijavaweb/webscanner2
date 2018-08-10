<%@page import="pattern.PartternDTO"%>
<%@page import="java.util.ArrayList"%>
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
<script type="text/javascript">
$(document).ready(function() {
    $('#patternlist').DataTable();
} );
</script>
<%ArrayList<PartternDTO> patternList =(ArrayList<PartternDTO>)  request.getAttribute("patternList"); 
%>
</head>
<body>
<div class="container center-block table-responsive">
  <h4>패턴목록</h4>
  <div class="container-fluid">
  <form action="/webscanner/main/admin/pattern.do" method="get">
			<div class="row justify-content-end">
				<div class="col-offset-4 col-md-3">
					<select name="attackweb">
						<option value="SQL Injection" selected="selected">SQL인젝션</option>
						<option value="BruteForce">BRUTE FORCE</option>
						<option value="XSS">XSS(크로스사이트스크립트)</option>
					</select>
				</div>
				<div class="col-md-3">
					<input name="pattern" type="text" class="form-control" name="msg"
						placeholder="패턴" />
				</div>
				<div>
					<button type="submit" class="btn btn-outline-primary pull-left"
						style="font-size: 8pt">추가</button>
				</div>
			</div>
		</form>
		</div>
  <div class="container-fluid border" style="padding: 10px">
  <table id="patternlist"class="table table-bordered">
    <thead class="thead-dark">
      <tr>
        <th scope="col">#</th>
        <th scope="col">공격명</th>
        <th scope="col">패턴</th>
        <th scope="col">삭제</th>
      </tr>
    </thead>
    <tbody id="myTable">
    <% for(int i=0;i<patternList.size();i++){
    	PartternDTO p = patternList.get(i);
    %>
      <tr>
        <th scope="col"><%=i+1 %></th>
        <th class="text-primary"><%=p.getName() %></th>
        <th class="text-danger"><%=p.getPattern() %></th>
        <th><Button class="btn btn-outline-info btn-sm" type="button"
			onclick="userDelete('<%=p.getPattern()%>');trDelete(this)">삭제</Button></th>
      </tr>
      <%} %>
    </tbody>
  </table>
  </div>
  </div>
  	<script src="/webscanner/js/scan/pdelete.js" charset='UTF-8'></script>
</body>
</html>