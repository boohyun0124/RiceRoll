<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%>
<!-- ...<head> -->
<style>
#findresultPass{
	margin-top:200px;
}
</style>
</head>
<body>
<div id="findresultPass">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<img class="LogoImage" src="images/LogoImage.png" />
				<h2>비밀번호 찾기 결과</h2>
				<c:choose>
					<c:when test="${not empty list}">
						<table>
							<c:forEach items="${list}" var="memberVo">
								<tr>
									<th>비밀번호 :</th>
									<td>${memberVo.user_pass}</td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<h2>정보와 일치하는 비밀번호가 없습니다.</h2>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>
	<!-- </body> </html> -->