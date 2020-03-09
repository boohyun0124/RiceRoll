<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%>
<!-- ...<head> -->
<style>
#contentupdate{
	margin-top:150px;
}
</style>
<%@ include file="include/SearchBox.jsp" %> <!-- </head><body> -->
	<div id="contentupdate">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-1"></div>
				<div class="col-md-7">
					<h1>수정하기</h1>
					<form action="customer_content_update_pro.gimppab" method="post"
						enctype="multipart/form-data">
						<input type="hidden" value="${board_category_num}"
							name="board_category_num" />
						<table>
							<tr>
								<th>제목</th>
								<td><input type="text" name="subject" /></td>
							</tr>
							<tr>
								<th>내용</th>
								<td><textarea rows="20" cols="100" name="content"></textarea>
								</td>
							</tr>
							<tr>
								<th>사진</th>
								<td><input type="file" name="image" /></td>
							</tr>
						</table>
						<input type="submit" value="완료" />
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
	<%@ include file="include/footer.jsp"%>
	<!-- </body> </html> -->