<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<!-- ...<head> -->
<style>
#login {
	margin-top:200px;
}
</style>
<script>
var v = "${param.msg}";
if (v == "login_fail") {
	alert("아이디 또는 비밀번호가 잘못 되었습니다.");
}
</script>
</head>
<body>
<div id="login">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<img class="LogoImage" src="images/LogoImage.png" />
				<form action="login_pro.gimppab">
					<table>
						<tr>
							<th><h5>아이디 : </h5></th>
							<td><input name="user_id" type="text" required /></td>
						</tr>
						<tr>
							<th><h5>비밀 번호 : </h5></th>
							<td><input name="user_pass" type="password" required /></td>
						</tr>
					</table>
					<input type="submit" value="로그인">
				</form>
				<a href="find_user_form.gimppab">아이디 찾기</a> | <a href="find_user_form.gimppab">비밀번호 찾기</a> | <a href="join_form.gimppab">회원
					가입</a>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</div>
	<%@ include file="include/footer.jsp"%>
	<!-- </body> </html> -->