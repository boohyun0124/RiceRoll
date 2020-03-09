<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/header.jsp"%>
<!-- ...<head> -->
<style>
#body {
	margin-top: 170px;
}
</style>
<script>
	$(function() {
		$("#list").click(function() {
			location.href = "customer_board_form.gimppab";
		});
		$("#btnUpdate").click(function() {
							location.href = "customer_content_update_form.gimppab?board_category_num=${board_category_num}";
						});
		$("#btnDelete").click(function() {
							location.href = "customer_content_delete_form.gimppab?board_category_num=${board_category_num}";
						});
		$("#btnlogin").click(function(){
			location.href = "login_form.gimppab";
		});
		$("#btnCommentInput").click(function(){
			var reply_text = $("textarea[name=reply_text]").val();
			var url = "comment-write.Ajax";
			var sData = {
					"reply_text" : reply_text,
					"board_category_num" : "${board_category_num}"
			};
			$.post(url, sData, function(rData){
				console.log(rData);
				if (rData.trim() == "success") {
					console.log("작동");
					getCommentList();
				}
			});
		});
		
		function getCommentList() {
			var url = "board_comment_list.Ajax";
			var sData = {
				"board_category_num" : "${board_category_num}"
			};
			$.getJSON(url, sData, function(rData) {
				console.log("getJSON");
				console.log(rData);
				$("#replyTable > tbody").empty();
				$.each(rData, function() {
					console.log(this.board_reply_num);
					var tr = "<tr>";
					tr += "<td>" + this.board_reply_num + "</td>";
					tr += "<td>" + this.user_id + "</td>";
					tr += "<td>" + this.reply_reg_date + "</td>";
					tr += "<td>" + this.reply_content + "</td>";
					
					$("#replyTable > tbody").append(tr);
				});
			});
		}
		
		getCommentList();
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
				<h1>상세 보기</h1>
				<button id="list">목록</button>
				<c:if test="${boardVo.user_id == sessionScope.user_id}">
								<button id="btnUpdate">수정</button>
								<button id="btnDelete">삭제</button>
				</c:if>
				<table id="content">
					<tr>
						<th>글 번호(${boardVo.board_read_count})</th>
						<td>${board_category_num}
						<td>
					</tr>
					<tr>
						<th>유저 아이디</th>
						<td>${boardVo.user_id}
						<td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${boardVo.board_subject}
						<td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${boardVo.board_content}
						<td>
					</tr>
					<tr>
						<th>사진</th>
						<td><c:choose>
								<c:when test="${empty boardVo.board_images}">
									<img src="images/default.jpg" width="500" />
								</c:when>
								<c:otherwise>
									<img src="upload/${boardVo.board_images}" width="500" />
								</c:otherwise>
							</c:choose>
						<td>
					</tr>
					<tr>
						<th>댓글(${boardVo.board_reply_count})</th>
						<td></td>
					</tr>
				</table>
				<textarea rows="3" cols="80" name="reply_text"></textarea>
				<c:choose>
					<c:when test="${not empty sessionScope.user_id}">
						<button id="btnCommentInput">입력</button>
					</c:when>
					<c:otherwise>
						<button id="btnlogin">로그인 필요</button>
					</c:otherwise>
				</c:choose>
				<table id="replyTable">
				<tbody></tbody>
				</table>
			</div>
			<div class="col-md-2">
				<img id="backgroundimage" src="images/SideBackground.png" />
			</div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>
<!-- </body> </html> -->