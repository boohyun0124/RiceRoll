<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#search {
		position: fixed;
		top:0px;
		background-color:white;
		width:100%;
		z-index: 1000;
	}
	
	#menu_tbody_table > tr {
		display:block;"
	}
	
	#tableDiv  td,th{
		width:10%;
	}
</style>
<script>
$(function() {
	var url="SearchBox_menu.Ajax";
	$.getJSON(url, function(rData){
		$.each(rData, function() {
			var href1="";
			var href2="";
			if (this.community == "김밥 소식") {
				href2="news_form.gimppab";
			}else if (this.community == "고객의 소리") {
				href2="customer_board_form.gimppab";
			}
			if (this.menu == "오리지널 김밥"){
				href1="menu_form.gimppab?menu=오리지널 김밥";
			}else if (this.menu == "치즈 김밥"){
				href1="menu_form.gimppab?menu=치즈 김밥";
			}else if (this.menu == "참치마요 김밥"){
				href1="menu_form.gimppab?menu=참치마요 김밥";
			}else if (this.menu == "돈까스 김밥"){
				href1="menu_form.gimppab?menu=돈까스 김밥";
			}else if (this.menu == "새우 김밥"){
				href1="menu_form.gimppab?menu=새우 김밥";
			}else if (this.menu == "매운 김밥"){
				href1="menu_form.gimppab?menu=매운 김밥";
			}else if (this.menu == "떡갈비 김밥"){
				href1="menu_form.gimppab?menu=떡갈비 김밥";
			}
			var tr ="<tr style='width:921px'>";
			tr += "<td>" + "<a href='"+ href1 +"'>"+this.menu+"</a>"+"</td>";
			tr += "<td>" + "<a href='"+ href2 +"'>"+this.community +"</a>"+"</td>";
			tr += "<td>" + this.event + "</td>";
			tr += "</tr>";
			$("#menu_table2").append(tr);
		});
	}); // $.getJSON
	
	
	$("#menu_table").on({
		"mouseenter": function(e){
			$("#menu_table2").show();
			
		}
	});
	
	$("#search").on("mouseleave", "#menu_table2", function(e) {
// 			console.log("menu_table2 mouseout");
			$("#menu_table2").hide();
		
	});	
});
</script>
</head>
<body>
<div id="search">
<div class="container-fluid">
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-2">
			<img class="LogoImage" src="images/LogoImage.png" width=270/>
		</div>
		<div class="col-md-6" >
		<div id="tableDiv">
			<table class="table" id="menu_table">
				<tr id="menu_thead_table">
					<th>메뉴</th>
					<th>커뮤니티</th>
					<th>이벤트</th>
				</tr>
			</table>
			<table class="table" id="menu_table2" style="width:921px;display:none;">
				
			</table>
		</div>
		</div>
		<div class="col-md-2">
			<c:choose>
				<c:when test="${not empty user_id}">
					${user_nickname}님 반갑습니다.
					<a href="logout_pro.PPabMember">로그아웃</a>
				</c:when>
				<c:otherwise>
					<a href="login_form.gimppab">로그인</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-md-1">
		</div>
	</div>
</div>
	<hr>
</div>