<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$("#logoutchk").click(function(ev){
		if(!confirm("로그아웃 하시겠습니까?")) {
			ev.preventDefault();
		}else {alert("로그아웃 되었습니다.")}
	});
	$("#deletechk").click(function(ev){
		 if(!confirm("회원탈퇴 하시겠습니까?")) {
			 ev.preventDefault();
		 }else {alert("회원탈퇴가 완료되었습니다.")}
	 });
});
</script>
<title>라디오세상</title>
<style type="text/css">
	* { 
		margin: 0; 
		padding:0; 
	}
	body {
		padding-bottom: 50px;
	}
	a:hover {
		opacity: 0.5;
		transition: all 0.3s;	
	}
	li, ul, ol { list-style : none }
	
	header { 
		padding: 20px 0; 
		margin-bottom: 30px;
		background: #2186db;  
	}  
	
	.homeBtn {
		margin-bottom: 0;
		padding: 20px 0;
		text-align: center;
	}
	
	.homeBtn>a {
		font-size: 30px !important;
		text-decoration: none;
	}
	
	.user {
		display: inline-block;
		position: absolute;
		left: 3%;
		top: 25px;
		font-size: 18px;
		font-weight: bold; 
	}
	
	.id {
		color: #4a85fd;
	}
	
	.loginBtn, .infoBtn {
		position: absolute;
		right: 20px;
		top: 15px;
		font-weight: bold;
		font-size: 14px;
		text-decoration: none;
		color: #222;
	}
	
	.infoBtn {
		disply: flex;
	}

	.infoBtn a {
		display: inline-block;
		padding: 0 5px;
		border-right: 1px solid gray;
		font-weight: bold;
		font-size: 14px;
		text-decoration: none;
		color: #222;
	}

	.infoBtn a:last-child {
		padding-right: 0;
		border-right: none;
	}
	
	.nav {
		background: #9f9f9f;  
		background: #2186db;  
	}
	
	.nav ul {
		display: flex;
		justify-content: center; 
		max-width: 1000px; 
		margin: 0 auto; 
		padding: 0;
	}

	.nav li {
		flex-basis: 30%;
		padding: 10px 0;
		text-align: center;
	}
	.nav a {
		font-size: 16px;
		text-decoration: none; 
		color: #fff;
		font-weight: bold;
	}
</style>
<script>
$(document).ready(function(){
	
});
</script>
</head>
<body>
<header>
	<h1 class="homeBtn"><a href='/'>라디오세상</a></h1>
	<% if(session.getAttribute("id") == null) { %>
		<a class="loginBtn" href="login">로그인</a>
	<% } else { %>
		<span class="user"><span class="id">${sessionScope.id}</span>님 환영합니다!</span>
		<div class='infoBtn'>
			<a href="/memberupdate" class="mypage">내정보확인/수정</a>
			<a id="deletechk" href="/deletemember" class="mypage">회원탈퇴</a>
			<a id="logoutchk" href="/logout" class="mypage">로그아웃</a>
		</div>
	<% } %>
	<div class="nav">
		<ul>
			<li><a href="/boardList">라디오 사연 게시판</a></li>
			<li><a href="/reviewBoardList">방청 후기 게시판</a></li>
		</ul>
	</div>
</header>
</body>
</html>
