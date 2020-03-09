<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<!-- ...<head> -->
<style>
#finduser{
	margin-top:200px;
}
</style>
<%@ include file="include/SearchBox.jsp" %> <!-- </head><body> -->
<div id="finduser">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<h1>아이디 찾기</h1>
				<form action="find_user_id_pro.gimppab">
					<table>
						<tr>
							<th><span>이름</span></th>
							<td><input type="text" name="user_name" /></td>
						<tr>
						<tr>
							<th><span>닉네임</span></th>
							<td><input type="text" name="user_nickname" /></td>
						<tr>
						<tr>
							<th><input type="submit" value="아이디 찾기" /></th>
							<td></td>
						<tr>
					</table>
				</form>
				<hr>
				<h1>비밀번호 찾기</h1>
				<form action="find_user_pass_pro.gimppab">
					<table>
						<tr>
							<th><span>아이디</span></th>
							<td><input type="text" name="user_id" /></td>
						</tr>
						<tr>
							<th><span>이름</span></th>
							<td><input type="text" name="user_name" /></td>
						</tr>
						<tr>
							<th><span>닉네임</span></th>
							<td><input type="text" name="user_nickname" /></td>
						</tr>
						<tr>
							<th><input type="submit" value="비밀번호 찾기" /></th>
							<td></td>
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