<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%> <!-- ...<head> -->
</head>
<body>
<h1>비밀 번호 변경</h1>
<form action="pass_update_pro.PPabMember">
<table>
	<tr>
		<th>
			비밀 번호 : 
		</th>
		<td>
			<input name="user_pass" type="text" value="${memberVo.user_pass}">
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