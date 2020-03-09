<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<!-- ...<head> -->
<style>
#body {
	margin-top: 170px;
}
</style>
<%@ include file="include/SearchBox.jsp"%>
<!-- </head><body> -->
<div id="body">
	<h1>글쓰기</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<form action="customer_write_pro.gimppab" method="post"
					enctype="multipart/form-data">
					<div>
						<label for="subject"> 제목 </label> <input type="text" id="subject"
							name="subjcet" />
					</div>
					<div>

						<label for="content"> 내용 </label>
						<textarea id="content" name="content" cols="100" rows="20"></textarea>
					</div>
					<div>

						<input type="file" id="image" name="image" />
						<p class="help-block">필요에 따라서 사진을 첨부해 주세요.</p>
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>
<!-- </body> </html> -->