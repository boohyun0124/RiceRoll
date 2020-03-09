<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<!-- ...<head> -->
<style>
#join {
	margin-top:150px;
}
#jointable {
	
}
</style>
<script>
	var v = "${param.msg}";
	if (v == "mem_join_fail") {
		alert("회원 가입 실패");
	} else if (v == "mem_join_checkPass_fail") {
		alert("비밀번호가 일치하지 않습니다.");
	} else if (v == "mem_join_checkDupId_fail") {
		alert("아이디가 중복입니다.");
	}
	$(function() {
		var isCheckId = false;
		$("#btnCheckId").click(function() {
			var user_id = $("input[name=user_id]").val();
			var url = "user_check_id.Ajax";
			var sData = {
				"user_id" : user_id
			}
			$.get(url, sData, function(rData) {
				var v = rData.trim();
				if (v == "used_id") {
					$("#resultSpan").text("사용중인 아이디");
				} else if (v == "available_id") {
					$("#resultSpan").text("사용 가능한 아이디");
					isCheckId = true;
				}
			});
		});

		$("#joinForm").submit(function() {
			var user_pass = $("input[name=user_pass]").val();
			var user_pass_check = $("input[name=user_pass_check]").val();
			if (user_pass != user_pass_check) {
				alert("패스워드를 확인해주세요.");
				return false;
			}
			if (isCheckId == false) {
				alert("아이디 중복 체크를 해주세요");
				return false;
			}
		});
	});
</script>
<%@ include file="include/SearchBox.jsp" %> <!-- </head><body> -->
<div id ="join">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<h1>회원 가입창</h1>
				<form id="joinForm" action="join_pro.gimppab" method="post">
					<table id="jointable">
						<tr>
							<th><span>아이디 : </span></th>
							<td><input name="user_id" type="text" required /> <input
								type="button" value="중복확인" id="btnCheckId" /> <span
								id="resultSpan"></span></td>
						</tr>
						<tr>
							<th><span>비밀번호 : </span></th>
							<td><input name="user_pass" type="password" required /></td>
						</tr>
						<tr>
							<th><span>비밀번호 확인:</span></th>
							<td><input name="user_pass_check" type="password" required />
							</td>
						</tr>
						<tr>
							<th><span>이름 : </span></th>
							<td><input name="user_name" type="text" required /></td>
						</tr>
						<tr>
							<th><span>닉네임 : </span></th>
							<td><input name="user_nickname" type="text" required /></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="submit" value="가입" /></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>
	<!-- </body> </html> -->