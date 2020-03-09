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
		var price = ${menuVo.menu_price};
		var count = 1;
		$("#count_minus").click(function() {
			--count;
			price -= ${menuVo.menu_price};
			if (count <= 0 || price <= 0) {
				count = 0;
				price = 0;
			}
			var url = "count_menu.Ajax";
			var sData = {
				"count" : count,
				"price" : price
			};
			$.getJSON(url, sData, function(rData) {
				$.each(rData, function() {
					$("#count").text(this.count);
					$("#price").text(this.price);
					$("input[name=count]").val(this.count);
					$("input[name=price]").val(this.price);
				});
			});
		});
		$("#count_plus").click(function() {
			++count;
			price += ${menuVo.menu_price};
			var url = "count_menu.Ajax";
			var sData = {
				"count" : count,
				"price" : price
			};
			$.getJSON(url, sData, function(rData) {
				$.each(rData, function() {
					$("#count").text(this.count);
					$("#price").text(this.price);
					$("input[name=count]").val(this.count);
					$("input[name=price]").val(this.price);
				})

			});
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
			<div class="col-md-2"></div>
			<div class="col-md-4">
				<c:choose>
					<c:when test="${menuVo.menu_code=='M1'}">
						<img alt="original.PNG" src="images/original.PNG">
					</c:when>
					<c:when test="${menuVo.menu_code=='M2'}">
						<img alt="cheese.PNG" src="images/cheese.PNG">
					</c:when>
					<c:when test="${menuVo.menu_code=='M3'}">
						<img alt="tuna.PNG" src="images/tuna.PNG">
					</c:when>
					<c:when test="${menuVo.menu_code=='M4'}">
						<img alt="cutlet.PNG" src="images/cutlet.PNG">
					</c:when>
					<c:when test="${menuVo.menu_code=='M5'}">
						<img alt="shrim.PNG" src="images/shrim.PNG">
					</c:when>
					<c:when test="${menuVo.menu_code=='M6'}">
						<img alt="spicy.PNG" src="images/spicy.PNG">
					</c:when>
					<c:when test="${menuVo.menu_code=='M7'}">
						<img alt="rip.PNG" src="images/rip.PNG">
					</c:when>
				</c:choose>
				<br>
				<button id="count_minus">-</button>
				<div>
					수량 : <span id="count">1</span>
				</div>
				<div>
					가격 : <span id="price">${menuVo.menu_price}</span>
				</div>
				<button id="count_plus">+</button>
				<form action="menu_pro.gimppab">
					<input type="hidden" name="menu_code" value="${menuVo.menu_code}" />
					<input type="hidden" name="count" value="1" /> 
					<input type="hidden" name="price" value="${menuVo.menu_price}" />
					<c:if test="${not empty user_id}">
						<input type="submit" value="장바구니에 담기" />
					</c:if>
				</form>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<img id="backgroundimage" src="images/SideBackground.png" />
			</div>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>
<!-- </body> </html> -->