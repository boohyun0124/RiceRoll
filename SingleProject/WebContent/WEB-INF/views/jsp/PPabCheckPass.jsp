<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%> <!-- ...<head> -->
</head>
<body>
<h1>비밀번호 확인</h1>
<form 
<c:choose>
	<c:when test="${path == 'privacy'}">
		action="privacy_update_form.PPabMember"
	</c:when>
	<c:when test="${path == 'pass'}">
		action="pass_update_form.PPabMember"
	</c:when>
	<c:when test="${path == 'Withdrawal'}">
		action="withdrawal_update_form.PPabMember"
	</c:when>
</c:choose>
>
	<input name="user_pass" type="password"/>
	<input type="submit" value="완료"/>
</form>
<%@ include file="include/footer.jsp" %> <!-- </body> </html> -->