<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%> <!-- ...<head> -->
<style>
	#body {
		margin-top:100px;
	}
</style>
<script>
var v = "${param.msg}";
if (v == "mem_join_success") {
	alert("회원 가입 성공");
}else if (v == "login_success") {
	alert("어서와");
}else if (v == "logout_success") {
	alert("잘가");
}else if (v == "pass_fail") {
	alert("비밀번호가 틀렸습니다.");
}else if (v == "member_update_success") {
	alert("수정 완료 되었습니다.");
}else if (v == "member_update_fail") {
	alert("수정 실패");
}
</script>
<%@ include file="include/SearchBox.jsp" %> <!-- </head><body> -->
<div id="body">
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<%@ include file="include/Left_loginBar.jsp" %>
			<img id="backgroundimage" src="images/SideBackground.png" />
		</div>
		<div class="col-md-8">
			<div class="carousel slide" id="carousel-495202">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-495202" class="active">
					</li>
					<li data-slide-to="1" data-target="#carousel-495202">
					</li>
					<li data-slide-to="2" data-target="#carousel-495202">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img class="d-block w-100" alt="ShrimpAndRib" src="images/Main_ShrimpAndRib.PNG" />
						<div class="carousel-caption">
							<p>
							</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="SpicyAndCutlet" src="images/Main_SpicyAndCutlet.PNG" />
						<div class="carousel-caption">
							<p>
							</p>
						</div>
					</div>
					<div class="carousel-item">
						<img class="d-block w-100" alt="TunaAndCheese" src="images/Main_TunaAndCheese.PNG"  />
						<div class="carousel-caption">
							<p>
							</p>
						</div>
					</div>
				</div> <a class="carousel-control-prev" href="#carousel-495202" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-495202" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
			</div>
		</div>
		<div class="col-md-2">
			<img id="backgroundimage" src="images/SideBackground.png" />
		</div>
	</div>
</div>
</div>

<%@ include file="include/footer.jsp" %> <!-- </body> </html> -->