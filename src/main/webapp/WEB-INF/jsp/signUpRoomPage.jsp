<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>sign up room</title>
<!-- metatags-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="creative multi forms A Flat Responsive Widget,Login form widgets, Sign up Web 	forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-java script"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); }</script>
<!-- Meta tag Keywords -->
<link href="//fonts.googleapis.com/css?family=Josefin+Slab:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway" rel="stylesheet"> 
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/><!--stylesheet-css-->
<script type="text/javascript">
	var userNo;
	function numberChange(number){
		// alert(number);
		userNo = number;
		if(userNo == 2){
			room3Name.style.display="none";
			room4Name.style.display="none";
			room5Name.style.display="none";
		}
		if(userNo == 3){
			room3Name.style.display="block";
			room4Name.style.display="none";
			room5Name.style.display="none";
		}
		if(userNo == 4){
			room3Name.style.display="block";
			room4Name.style.display="block";
			room5Name.style.display="none";
		}
		if(userNo == 5){
			room3Name.style.display="block";
			room4Name.style.display="block";
			room5Name.style.display="block";
		}
	}
	
</script>
</head>
<body>
	<h1>creative <span>r</span><span>o</span><span>o</span><span>m</span> forms</h1>
	<br>
	<div class="sign-up-room">
		<form action="signUpRoom" method="post">
			<h3><span>room</span> sign up <span>here</span></h3>
			<input type="text" name="roomName" placeholder="room name" required=""/>
			<input type="password" name="roomPassword" placeholder="create a password" required=""/>
			<input type="password" placeholder="confirm your password" required=""/>
			<input type="text" name="totalPrice" placeholder="total price" required=""/>
			<div class="opt">
				<label>user number: </label>
				<span>
					<select name="userNumber" onchange="numberChange(this.value);">
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</span>
			</div>
			<div class="clear"></div>
			<input type="text" id="room1Name" name="room1Name" placeholder="room1 name" />
			<input type="text" id="room2Name" name="room2Name" placeholder="room2 name"/>
			<input type="text" id="room3Name" name="room3Name" placeholder="room3 name" style="display: none"/>
			<input type="text" id="room4Name" name="room4Name" placeholder="room4 name" style="display: none"/>
			<input type="text" id="room5Name" name="room5Name" placeholder="room5 name" style="display: none" />
			<input type="submit" class="btn" name="button" value="sign up"/>
		</form>
	</div>
		<footer>
			&copy; 2018 creative multi forms. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a>
		</footer>		
	</body>
</html>