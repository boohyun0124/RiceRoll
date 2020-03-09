<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id ="LeftLoginBar">
<c:choose>
	<c:when test="${not empty user_id}">
		<div id="card-357460">
			<div class="card">
				<div class="card-header">
					<a class="card-link collapsed" data-toggle="collapse"
						data-parent="#card-357460" href="#card-element-100">내정보관리</a>
				</div>
				<div id="card-element-100" class="collapse">
					<div class="card-body"><a href="check_pass_form.PPabMember?path=privacy">개인정보 변경</a></div>
				</div>
				<div id="card-element-100" class="collapse">
					<div class="card-body"><a href="check_pass_form.PPabMember?path=pass">비밀번호 변경</a></div>
				</div>		
				<div id="card-element-100" class="collapse">
					<div class="card-body"><a href="check_pass_form.PPabMember?path=Withdrawal">회원탈퇴</a></div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<a class="card-link collapsed" data-toggle="collapse"
						data-parent="#card-357460" href="#card-element-101">김밥 관리</a>
				</div>
				<div id="card-element-101" class="collapse">
					<div class="card-body"><a href="customer_order_list_form.gimppab">주문 내역</a></div>
				</div>
				<div id="card-element-101" class="collapse">
					<div class="card-body"><a href="customer_basket_form.gimppab">장바구니</a></div>
				</div>
			</div>
		</div>
	</c:when>
</c:choose>
</div>