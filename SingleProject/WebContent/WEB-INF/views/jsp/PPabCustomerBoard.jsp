<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%>
<!-- ...<head> -->
<style>
#body {
	margin-top: 170px;
}

#customerBoard {
	width: 100%;
}
</style>
<script>
	$(function() {
		$("#write").click(function() {
			location.href = "customer_write_form.gimppab";
		});
	});
</script>
<%@ include file="include/SearchBox.jsp"%>
<!-- </head><body> -->
<div id="body">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="include/Left_loginBar.jsp" %>
				<img id="backgroundimage" src="images/SideBackground.png" />
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<h1>고객의 소리</h1>
				<input id="write" type="button" value="글쓰기">
				<table id="customerBoard">
					<tr>
						<th>글 번호</th>
						<th>이미지</th>
						<th>글 제목</th>
						<th>작성자(ID)</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					<c:forEach items="${list}" var="boardVo">
						<tr>
							<td>${boardVo.board_category_num}</td>
							<td><c:choose>
									<c:when test="${empty boardVo.board_images}">
										<img src="images/default.jpg" width="50" />
									</c:when>
									<c:otherwise>
										<img src="upload/${boardVo.board_images}" width="50" />
									</c:otherwise>
								</c:choose></td>
							<td><a
								href="customer_content_form.gimppab?board_category_num=${boardVo.board_category_num}"
								title="${boardVo.board_content}">${boardVo.board_subject}
									[${boardVo.board_reply_count}]</a></td>
							<td>${boardVo.user_id}</td>
							<td>${boardVo.board_reg_date}</td>
							<td>${boardVo.board_read_count}</td>
						</tr>
					</c:forEach>
				</table>
				<nav>
				<ul class="pagination">
					<li class="page-item">
						<a class="page-link" href="#">Previous</a>
					</li>
					
					<li class="page-item">
						<a class="page-link" href="#">1</a>
					</li>
					
					<li class="page-item">
						<a class="page-link" href="#">Next</a>
					</li>
				</ul>
			</nav>
			</div>
			<div class="col-md-2">
				<img id="backgroundimage" src="images/SideBackground.png" />
			</div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>
<!-- </body> </html> -->