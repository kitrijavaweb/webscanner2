<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webscanner/css/custom.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>회원가입</title>
<script type="text/javascript">
	function registerCheck() {
		var userId = $('#userId').val();
		$.ajax({
			type : 'POST',
			url : '/webscanner/UserResgisterCheck',
			data : {
				userId : userId
			},
			success : function(result) {
				if (result == 1) {
					$('#checkMessage').html("사용할 수 있는 아이디 입니다.");
					$('#checkType')
							.attr('class', 'modal-content panel-success');
				} else {
					$('#checkMessage').html("사용할 수 없는 아이디 입니다.");
					$('#checkType')
							.attr('class', 'modal-content panel-warning');
				}
				$('#checkModal').modal("show");
			}
		})
	}
	function passwordCheck() {
		var userPassword1 = $('#userpassword1').val();
		var userPassword2 = $('#userpassword2').val();
		if (userPassword1 != userPassword2) {
			$('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');
		} else {
			$('#passwordCheckMessage').html('');
		}
	}
	function Loginpage() {
		window.location = "/webscanner/template/login.jsp";
	}
</script>
</head>
<body>
	<div class="container">
		<form method="post" action="/webscanner/Register.do">
			<table class="table table-bordered table-hober"
				style="text-align: center; border: 1px dolid #dddddd">
				<thead>
					<tr>
						<th colspan="3"><h4>회원 등록</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px;"><h5>아이디</h5></td>
						<td><input class="form-control" type="text" id="userId"
							name="userId" maxLength="20" placeholder="아이디를 입력해주세요."></td>
						<td style="width: 110px;"><button class="btn btn-primary"
								onclick="registerCheck()" type="button">중복확인</button></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>비밀번호</h5></td>
						<td colspan="2"><input class="form-control" type="password"
							onkeyup="passwordCheck()" id="userpassword1" name="userpassword1"
							maxLength="20" placeholder="비밀번호를 입력해주세요."></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>비밀번호 확인</h5></td>
						<td colspan="2"><input class="form-control" type="password"
							onkeyup="passwordCheck()" id="userpassword2" name="userpassword2"
							maxLength="20" placeholder="비밀번호를 입력해주세요."></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>이름</h5></td>
						<td colspan="2"><input class="form-control" type="text"
							id="userName" name="userName" maxLength="20"
							placeholder="이름을 입력해주세요."></td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>회원구분</h5></td>
						<td colspan="2">
							<div class="form-group"
								style="text-align: center; margin: 0 auto;">
								<div class="btn-group">
									<label class="btn btn-primary"> <input type="radio"
										name="usersort" value="개인">개인
									</label> <label class="btn btn-primary"> <input type="radio"
										name="usersort" value="기업">기업
									</label>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td style="width: 110px;"><h5>이메일</h5></td>
						<td colspan="2"><input class="form-control" type="email"
							aria-describedby="emailHelp" id="useremail" name="useremail"
							maxLength="20" placeholder="이메일을 입력해주세요."></td>
					</tr>
					<tr>
						<td style="text-align: left" colspan="3"><h5
								style="color: red;" id="passwordCheckMessage"></h5> <input
							class="btn btn-primary pull-right" type="submit" value="회원가입">
							<input class="btn btn-primary pull-right" type="button"
							onclick="Loginpage()" value="로그인페이지"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
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
					<div class="modal-header panel-heading">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
						</button>
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
	<div class="modal fade" id="checkModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="vertical-aligment-helper">
			<div class="modal-dialog vertical-align-center">
				<div class="modal-content panel-info" id="checkType">
					<div class="modal-header panel-heading">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
						</button>
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
</body>
</html>