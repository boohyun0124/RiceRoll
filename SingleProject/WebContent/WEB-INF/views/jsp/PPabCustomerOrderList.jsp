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
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<%@ include file="include/Left_loginBar.jsp" %>
				<img id="backgroundimage" src="images/SideBackground.png" />
			</div>
			<div class="col-md-8">
				<h1>주문내역</h1>
				<table>
					<tr>
						<th>번호</th>
						<th>종류</th>
						<th>갯수</th>
						<th>가격</th>
						<th>주문 날짜</th>
					</tr>
					<c:forEach items="${list}" var="orderlistVo">
						<tr>
							<td>${orderlistVo.order_list_num}</td>
							<td>${orderlistVo.menu_desc}</td>
							<td>${orderlistVo.menu_count}</td>
							<td>${orderlistVo.menu_price}</td>
							<td>${orderlistVo.order_list_reg_date}</td>
						</tr>
					</c:forEach>
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