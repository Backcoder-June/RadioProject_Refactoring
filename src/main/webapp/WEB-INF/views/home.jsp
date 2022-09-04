<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.container {
		position: relative;
		display: flex;
		justify-contents: space-around;
		width: 100%;
		max-width: 1000px;
		margin: 0 auto;
	}
	
	.mainImg {
		display: inline-block;
		padding-top: 50px;
		flex-basis: 70%;
	}
	
	.mainText {
		position: absolute;
		top: 35%;
		right: 5%;
		font-weight: bold;
		font-size: 35px;
	}
</style>
<title>라디오세상</title>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
	<div class="container">
		<img class="mainImg" src="images/radioMain.svg">
		<p class="mainText" >라디오 사연 신청과<br>방청 후기를 남겨보세요<p>
	</div>
</body>
</html>
