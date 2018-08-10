<%@page import="userInfo.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
body {
	font: 16px "Montserrat", sans-serif;
	line-height: 1.8;
	color: #555555;
}
</style>
<%
ArrayList<UserDTO> userinfo = (ArrayList<UserDTO>) request.getAttribute("userlist");
System.out.println(userinfo.size());
%>
</head>
<body>
	<div class="container">
		<h4>회원목록</h4>
		<input class="form-control" id="myInput" type="text"
			placeholder="회원정보 검색  ex) test">
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">계정</th>
					<th scope="col">비밀번호</th>
					<th scope="col">이름</th>
					<th scope="col">회원구분</th>
					<th scope="col">이메일</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody id="myTable">
				<%for(int i=0;i<userinfo.size();i++){ 
    	UserDTO u=userinfo.get(i);
    %>
				<tr>
					<td scope="col"><%= i+1 %></td>
					<td class="text-primary"><%= u.getUserID() %></td>
					<td><%= u.getUserPassword() %></td>
					<td><%= u.getUserName() %></td>
					<td><%= u.getUserSort() %></td>
					<td><%= u.getUserEmail() %></td>
					<td><Button class="btn btn-outline-success btn-sm" type="button"
							onclick="userDelete('<%=u.getUserID()%>');trDelete(this)">삭제</Button></td>
				</tr>
				<%} %>
			</tbody>
		</table>

	</div>

	<div class="modal fade" id="checkModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="vertical-aligment-helper">
			<div class="modal-dialog vertical-align-center">
				<div class="modal-content panel-info" id="checkType">
					<div class="modal-header panel-heading">
						<h4 class="modal-title">확인 메시지</h4>
					</div>
					<div class="modal-body" id="checkMessage"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/webscanner/js/scan/delete.js" charset='UTF-8'></script>
</body>
</html>