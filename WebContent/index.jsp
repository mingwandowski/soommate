<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<title>index</title>
		<!-- metatags-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="creative multi forms A Flat Responsive Widget,Login form widgets, Sign up Web 	forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
		<script type="application/x-java script"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); }</script>
		<!-- Meta tag Keywords -->
		<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/><!--stylesheet-css-->
		<link href="//fonts.googleapis.com/css?family=Josefin+Slab:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
		<link href="//fonts.googleapis.com/css?family=Raleway" rel="stylesheet"> 
	</head>
<body>
	<h1>WELCOME TO <span>S</span><span>O</span><span>O</span><span>M</span><span>M</span><span>A</span><span>T</span><span>E</span></h1>
	<br><br>
		<div class="sign-in-room">
			<form action="roomController/signInRoom" method="post">
				<h3>sign in room</h3>
				<input type="text" name="roomName" placeholder="user name" required=""/>
				<input type="password" name="roomPassword" placeholder="password" required=""/>
				<input type="submit" class="btn" value="sign in"/>
				<h3>or</h3>
				<input type="button" class="btn" value="sign up" 
					onclick="location.href='roomController/toSignUpRoomPage'"/>
			</form>
		</div>

		<footer>
			<p>
				<a href="https://github.com/mingwandowski/soommate">user guide</a>
			</p>
			&copy; 2018 creative multi forms. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a>
		</footer>		
</body>
</html>