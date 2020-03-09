<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%>
<!-- ...<head> -->
<style>
#findresultId {
	margin-top:200px;
}
</style>
</head>
<body>
<div id="findresultId">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<img class="LogoImage" src="images/LogoImage.png" />
				<h1>아이디 찾기 결과</h1>
				<c:choose>
					<c:when test="${not empty list}">
						<table>
							<c:forEach items="${list}" var="memberVo">
								<tr>
									<th>아이디 :</th>
									<td>${memberVo.user_id}</td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<h2>정보와 일치하는 아이디가 없습니다.</h2>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>
	<!-- </body> </html> -->