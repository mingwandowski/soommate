<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Result</title>

<!-- For-Mobile-Apps -->
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="E Shop Cart Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Android Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps -->

<!-- Custom-Theme-Files -->
	<link rel="stylesheet" href="../css/re-style.css" type="text/css" media="all" />
<!-- //Custom-Theme-Files -->

<!-- Remove-Item-JavaScript -->
	<script type="text/javascript">
		var userNo;
		function chooseNumber(){
	    	userNo = ${signInRoom.userNumber};
	    	// alert(userNo);
	    	if(userNo == 2){
				room3.style.display="none"; 
				room4.style.display="none"; 
				room5.style.display="none"; 
			}
			if(userNo == 3){
				room3.style.display="block";
				room4.style.display="none"; 
				room5.style.display="none"; 
			}
			if(userNo == 4){
				room3.style.display="block";
				room4.style.display="block";
				room5.style.display="none"; 
			}
			if(userNo == 5){
				room3.style.display="block";
				room4.style.display="block";
				room5.style.display="block";
			}
		}
	</script>
<!-- //Remove-Item-JavaScript -->

</head>

<!-- Body-Starts-Here -->
<body onload="chooseNumber()">

	<h1>You Saved $ <span style="color:red">${result.averageSaved}</span> Each!</h1>

	<!-- Content-Starts-Here -->
	<div class="container">

		<!-- Mainbar-Starts-Here -->
		<div class="main-bar">
			<div class="product">
				<h3>Room</h3>
			</div>
			<div class="quantity">
				<h3>User</h3>
			</div>
			<div class="price">
				<h3>Price</h3>
			</div>
			<div class="clear"></div>
		</div>
		<!-- //Mainbar-Ends-Here -->

		<!-- Items-Starts-Here -->
		<div class="items">

			<!-- Item1-Starts-Here -->
			<div class="item1" id="room1">
				<div class="close1">
					<div class="title1">
						<p>${signInRoom.room1Name}</p>
					</div>
					<div class="quantity1">
						<p>${result.room1User}</p>
					</div>
					<div class="price1">
						<p>$ ${result.room1Price}</p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<!-- //Item1-Ends-Here -->

			<!-- Item2-Starts-Here -->
			<div class="item2" id="room2">
				<div class="close2">
					<div class="title2">
						<p>${signInRoom.room2Name}</p>
					</div>
					<div class="quantity2">
						<p>${result.room2User}</p>
					</div>
					<div class="price2">
						<p>$ ${result.room2Price}</p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<!-- //Item2-Ends-Here -->

			<!-- Item3-Starts-Here -->
			<div class="item3" id="room3">
				<div class="close3">
					<div class="title3">
						<p>${signInRoom.room3Name}</p>
					</div>
					<div class="quantity3">
						<p>${result.room3User}</p>
					</div>
					<div class="price3">
						<p>$ ${result.room3Price}</p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<!-- //Item3-Ends-Here -->

			<!-- Item3-Starts-Here -->
			<div class="item4" id="room4">
				<div class="close4">
					<div class="title4">
						<p>${signInRoom.room4Name}</p>
					</div>
					<div class="quantity4">
						<p>${result.room4User}</p>
					</div>
					<div class="price4">
						<p>$ ${result.room4Price}</p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<!-- //Item3-Ends-Here -->

			<!-- Item5-Starts-Here -->
			<div class="item5" id="room5">
				<div class="close5">
					<div class="title5">
						<p>${signInRoom.room5Name}</p>
					</div>
					<div class="quantity5">
						<p>${result.room5User}</p>
					</div>
					<div class="price5">
						<p>$ ${result.room5Price}</p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<!-- //Item5-Ends-Here -->

		</div>
		<!-- //Items-Ends-Here -->

		<!-- Total-Price-Starts-Here -->
		<div class="total">
			<div class="total1">Total Price</div>
			<div class="total2">$ ${signInRoom.totalPrice}</div>
			<div class="clear"></div>
		</div>
		<!-- //Total-Price-Ends-Here -->

	</div>
	<!-- Content-Ends-Here -->

	<!-- Copyright-Starts-Here -->
	<div class="copyright">
	    <p>&copy; 2016 E Shop Cart. All Rights Reserved | Template by <a href="http://w3layouts.com/"> W3layouts </a></p>
	</div>
	<!-- //Copyright-Ends-Here -->

</body>
<!-- Body-Ends-Here -->

</html>