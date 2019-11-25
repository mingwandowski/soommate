<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- metatags-->
<meta name="viewport" content="width=device-width, initial-scale=0.7">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="creative multi forms A Flat Responsive Widget,Login form widgets, Sign up Web 	forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-java script"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); }</script>
<!-- Meta tag Keywords -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/><!--stylesheet-css-->
<link href="//fonts.googleapis.com/css?family=Josefin+Slab:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway" rel="stylesheet"> 
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all"/><!--stylesheet-css-->
<script type="text/javascript">
	var userNo;
	var currentUserNo;
	var totalPrice;
	var currentPrice;

	var submitOK = false;
	var calculateOK = false;
	
	function chooseNumber(){
    	//do something
    	userNo = ${signInRoom.userNumber};
    	currentUserNo = ${currentUserNo};
    	if(currentUserNo == userNo){
    		document.getElementById("submitButton").disabled=true;
    		calculateOK = true;
    	}
    	if(userNo == 2){
			room3Price.style.display="none"; r3pDouble.value=0.0;
			room4Price.style.display="none"; r4pDouble.value=0.0;
			room5Price.style.display="none"; r5pDouble.value=0.0;
		}
		if(userNo == 3){
			room3Price.style.display="block";
			room4Price.style.display="none"; r4pDouble.value=0.0; 
			room5Price.style.display="none"; r5pDouble.value=0.0; 
			// alert(room4Price.value);
			// alert(room5Price.value);
		}
		if(userNo == 4){
			room3Price.style.display="block";
			room4Price.style.display="block";
			room5Price.style.display="none"; r5pDouble.value=0;
		}
		if(userNo == 5){
			room3Price.style.display="block";
			room4Price.style.display="block";
			room5Price.style.display="block";
		}

		if(calculateOK){
			showResult.style.display="block";
		}else{
			showResult.style.display="none";
		}
	}

	function rightSum(){
		totalPrice = ${signInRoom.totalPrice};
		currentPrice = r1pDouble.value * 1 + r2pDouble.value * 1 + r3pDouble.value * 1 + r4pDouble.value * 1 + r5pDouble.value * 1;
		// alert(r1pDouble.value * 1 + r2pDouble.value * 1);
		if(totalPrice != currentPrice){
			alert("total price should be " + totalPrice);
			alert("current price is " + currentPrice);
			submitOK = false;
		}else{
			submitOK = true;
		}
		if(currentUserNo == userNo){
    		calculateOK = true;
    		showResult.style.display="block";
    	}
	}

	function subm(){
		return submitOK;
	}

</script>
</head>
<body onload="chooseNumber()">
	<h1>Welcome! tenant of <span style="color: blue">${signInRoom.roomName}</span></h1>
	<div class="room-center">
		<div class="room-page">
			<div class="room-page-left">
				<h2>total price: <span style="color: #fff000">${signInRoom.totalPrice}</span></h2>
				<h2><span style="color: #fff000">${signInRoom.userNumber}</span> rooms</h2>
				<h3>already signed up user:</h3>
				<div class="finished-user">
					<table>
						<c:forEach var="u" items="${signInUser}" varStatus="stauts">
							<tr>
								<td>${u.userName}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="room-page-right" id="roomPageRight">
				<form action="signUpUser" onsubmit="return subm()">
				<span>user name: </span>
					<input type="text" name="userName"><br>
				<br>
				<span>${signInRoom.room1Name}:</span>
					<input type="text" name="room1Price" id="r1pDouble"><br>
				<span>${signInRoom.room2Name}:</span>
					<input type="text" name="room2Price" id="r2pDouble"><br>
				<div id="room3Price">
					<span>${signInRoom.room3Name}:</span>
						<input type="text" name="room3Price" id="r3pDouble"><br>
				</div>
				<div id="room4Price">
					<span>${signInRoom.room4Name}:</span>
						<input type="text" name="room4Price" id="r4pDouble"><br>
				</div>
				<div id="room5Price">
					<span>${signInRoom.room5Name}:</span>
						<input type="text" name="room5Price" id="r5pDouble"><br>
				</div>
					<input type="submit" id="submitButton" value="submit" onclick="rightSum()">
					<input type="reset" value="reset">
			</form>
			</div>
		</div>
	</div>
		
	
	<div class="show-result" id="showResult">
		<button onclick="location.href='../algorithmController/startCalculate'"><h1>show result!</h1></button>
	</div>
	
	
</body>
</html>