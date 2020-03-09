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
		$("#chkAll").change(function() {
			var isChecked = $(this).is(":checked");
			var chkOrders = $(".chkOrder");
			if (isChecked == true) {
				chkOrders.prop("checked", true);
			} else {
				chkOrders.prop("checked", false);
			}
		});
		$("#btnOrderDelete")
				.click(
						function() {
							var chkOrders = $(".chkOrder");
							var order_nums = "";
							var arrCheckedIndex = [];
							var i = 0;
							$.each(chkOrders, function(index) {
								var isChecked = $(this).is(":checked");
								if (isChecked == true) {
									order_nums += $(this)
											.attr("data-order-num")
											+ ",";
									arrCheckedIndex[i] = index;
									i++;
								}
							});
							var v = order_nums.substring(0,
									order_nums.length - 1);
							var url = "order_delete.Ajax";
							var sData = {
								"order_nums" : v
							}
							$
									.post(
											url,
											sData,
											function(rData) {
												if (rData.trim() == "success") {
													for (var arrI = 0; arrI < arrCheckedIndex.length; arrI++) {
														chkOrders
																.eq(
																		arrCheckedIndex[arrI])
																.parent()
																.parent()
																.remove();
													}
													var stauts_index = $(".stauts_index");
													for (var v = 0; v < stauts_index.length; v++) {
														stauts_index.eq(v)
																.text(v + 1);
													}
												}
											});
						});
		$("#btnOrder").click(function() {
			location.href = "customer_basket_pro.gimppab";
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
			<div class="col-md-8">
				<h1>장바구니</h1>
				<button id="btnOrderDelete">선택 삭제</button>
				<table>
					<tr>
						<th><input type="checkbox" id="chkAll" /></th>
						<th>번호</th>
						<th>김밥</th>
						<th>갯수</th>
						<th>가격</th>
						<th>담은 날짜</th>
					</tr>
					<c:forEach items="${list}" var="basketVo">
						<tr>
							<td><input type="checkbox" class="chkOrder"
								data-order-num="${basketVo.order_num}" /></td>
							<td class="stauts_index">${basketVo.order_num}</td>
							<td>${basketVo.menu_desc}</td>
							<td>${basketVo.menu_count}</td>
							<td>${basketVo.menu_price}</td>
							<td>${basketVo.order_reg_date}</td>
						</tr>
					</c:forEach>
				</table>
				<button id="btnOrder">주문하기</button>
			</div>
			<div class="col-md-2">
				<img id="backgroundimage" src="images/SideBackground.png" />
			</div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>
<!-- </body> </html> -->