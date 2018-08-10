<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>WebScanner - 로그인</title>
<!-- Bootstrap core CSS-->
<link href="/webscanner/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="/webscanner/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="/webscanner/css/sb-admin.css" rel="stylesheet">
<style type="text/css">
body {
	background-image:
		url("https://post-phinf.pstatic.net/MjAxNzAzMjdfMTY0/MDAxNDkwNTc2ODExNDQy.53oCxWZ0zWW3JvBWmOhkQQguVYe9lrH2MNnzd2hLWtQg.-ntAGaWH-WZ9-aUdQmuyfOezMGHc-qvMbzNpm_fKYqIg.JPEG/LG-CNS_%EB%B3%B4%EC%95%88_1.jpg?type=w1200");
	background-size: cover;
}
</style>
<%
	Cookie[] cookies = request.getCookies();
	String id = "";
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("id")) {
				id = cookies[i].getValue();
			}
		}
	}
%>
</head>
<body>
	<form name="login_frm" action="/webscanner/webmain.do" method="post">
		<div class="container">
			<div class="card card-login mx-auto mt-5">
				<div class="card-header"
					style="background-color: #006DCC; color: white;">로그인</div>
				<div class="card-body">
					<div class="form-group">
						<label for="InputEmail1">아이디</label> <input class="form-control"
							name="userID" id="userID" type="text" maxLength="20"
							placeholder="아이디" value=<%=id%>>
					</div>
					<div class="form-group">
						<label for="InputPassword1">비밀번호</label> <input
							class="form-control" id="userPassword" name="userPassword"
							type="password" maxLength="20" placeholder="비밀번호">
					</div>
					<div class="form-group">
						<div class="form-check">
							<label class="form-check-label"> <input
								class="form-check-input" id="id_remeber" name="id_remeber"
								type="checkbox" value="T" <%if (id.length() != 0)%>
								<%="checked"%>> 아이디 기억하기
							</label>
						</div>
					</div>
					<button class="btn btn-primary btn-block" type="submit">로그인</button>
					<div class="text-center">
						<a class="d-block small mt-3" href="/webscanner/template/register.jsp">회원가입</a>
					</div>
				</div>
			</div>
		</div>
		<script src="/webscanner/vendor/jquery/jquery.min.js"></script>
		<script src="/webscanner/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script src="/webscanner/vendor/jquery-easing/jquery.easing.min.js"></script>
	</form>
	<%
		String message = null;
		if (session.getAttribute("messageContent") != null) {
			message = (String) session.getAttribute("messageContent");
		}
		String messageType = null;
		if (session.getAttribute("messageType") != null) {
			messageType = (String) session.getAttribute("messageType");
		}
		if (message != null) {
	%>
	<div class="modal fade" id="messageModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="vertical-aligment-helper">
			<div class="modal-dialog vertical-align-center">
				<div
					class="modal-content <%if (messageType.equals("성공메세지"))
					out.println("panel-success");%>">
					<div class="modal-header panel-heading"
						style="background-color: #006DCC; color: white;">
						<h4 class="modal-title">
							<%=messageType%>
						</h4>
					</div>
					<div class="modal-body">
						<%=message%>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#messageModal').modal("show");
	</script>
	<%
		session.removeAttribute("messageContent");
			session.removeAttribute("messageType");
	%>
	<%
		}
	%>
	<%
		session.removeAttribute("messageContent");
		session.removeAttribute("messageType");
	%>
</body>
</html>