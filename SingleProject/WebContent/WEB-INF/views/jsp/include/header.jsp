<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Rice Roll</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
#Notice {
	cursor: pointer;
}
#Company {
	cursor: pointer;
}
#Customer {
	cursor: pointer;
}
.LogoImage {
	cursor: pointer;
}
#LeftLoginBar {
		margin-top:50px;
		position: absolute;
		background-color:white;
		z-index:500;
		width:90%;
	}
#backgroundimage{
		width:100%;
	}
</style>
<script>
$(function(){
	$("#Notice").click(function() {
		alert("공지사항")
	});
	$("#Company").click(function() {
		alert("회사정보")
	});
	$("#Customer").click(function() {
		alert("고객센터")
	});
	$(".LogoImage").click(function(){
		location.href="Main.gimppab";
	});
});
</script>