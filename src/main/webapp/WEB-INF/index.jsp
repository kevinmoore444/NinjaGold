<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css"/>

</head>
<body class="index">

		<div class="gold">
			<h1 style="color: gold">Your Gold</h1>
			<p><c:out value="${gold}"/></p>
		</div>
		
	<div class="container">
		<div class="findGold">

				<h3>Farm</h3>
				<p style="font-size: 10px"> Earn 10-20 gold</p>
			<form action="/ninja/action" method="POST">
				<input type="hidden" name="choice" value="farm" />
				<button type="submit">Find Gold!</button>
			</form>
		</div>

		<div class="findGold">
			<h3>Cave</h3>
			<p style="font-size: 10px"> Earn 5-10 gold</p>
			<form action="/ninja/action" method="POST">
				<input type="hidden" name="choice" value="cave" />
				<button type="submit">Find Gold!</button>
			</form>
		</div>
		
		<div class="findGold">
			<h3>House</h3>
			<p style="font-size: 10px"> Earn 2-5 gold</p>
			<form action="/ninja/action" method="POST">
				<input type="hidden" name="choice" value="house" />
				<button type="submit">Find Gold!</button>
			</form>
		</div>
	
		<div class="findGold">
			<h3>Quest</h3>
			<p style="font-size: 10px"> Win/Lose 0-50 gold</p>
			<form action="/ninja/action" method="POST">
				<input type="hidden" name="choice" value="quest" />
				<button type="submit">Find Gold!</button>
			</form>
		</div>
		
		<div class="findGold">
			<h3>Spa</h3>
			<p style="font-size: 10px"> Spend 5-20 gold</p>
			<form action="/ninja/action" method="POST">
				<input type="hidden" name="choice" value="spa" />
				<button type="submit">Spend Gold!</button>
			</form>
		</div>
	</div>
	
	
	
	
	<!-- Reset Button -->
		<div class="reset">	
			<form action="/ninja/action" method="POST">
				<input type="hidden" name="choice" value="reset" />
				<button type="submit">Reset</button>
			</form>
		</div>	
		
		
		
	<!--Activity List-->
	<div class=activities>
		<h1 style="color: blue">Activities</h1>
		  	<iframe src="ninja/activities/" title="Activities Iframe"></iframe>
	</div>
	

</body>
</html>