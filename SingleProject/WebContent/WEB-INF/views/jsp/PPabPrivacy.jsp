<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%> <!-- ...<head> -->

</head>
<body>
<h1>개인정보 수정</h1>
<form action="privacy_update_pro.PPabMember">
<input name="user_pass" type="hidden" value="${memberVo.user_pass}"/>
<table>
	<tr>
		<th>
			이름 : 
		</th>
		<td>
			<input name="user_name" type="text" value="${memberVo.user_name}">
		</td>
	</tr>
	<tr>
		<th>
			닉네임 : 
		</th>
		<td>
			<input name="user_nickname" type="text" value="${memberVo.user_nickname}">
		</td>
	</tr>
	<tr>
		<th>
		</th>
		<td>
			<input type="submit" value="수정"/>
		</td>
	</tr>
</table>
</form>
<%@ include file="include/footer.jsp" %> <!-- </body> </html> -->