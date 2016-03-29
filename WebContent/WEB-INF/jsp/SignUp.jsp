<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>CATIA TRAINING SIGNUP</title>
<link rel="stylesheet" href="styles/signupStyle.css">
<script src="Js/signupvalidationscript.js"></script>
<!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
	<form name="signup" method="post" action="<c:url value='${nextPageURL}' />"
		onSubmit="return formValidation();" class="login">
		<p>
			<label for="Name">Name:</label> <input type="text" name="Name"
				id="Name" placeholder="Enter your name" required>
		</p>


		<p>
			<label for="Email">Email:</label> <input type="text" name="Email"
				id="Email" placeholder="Enter your Email ID" required>
		</p>
		<p>
			<label for="Mobile">Mobile:</label> <input type="text" name="Mobile"
				id="Mobile" placeholder="Enter your mobile number" required>
		</p>

		<p>
			<label for="password">Password:</label> <input type="password"
				name="Password" id="Password" placeholder="Enter password" required>
		</p>
		<p>
			<label for="repassword">Retype Password:</label> <input
				type="password" name="repassword" id="repassword"
				placeholder="Enter password again" required>
		</p>

		<p class="login-submit">
			<button type="submit" class="login-button">Sign Up</button>
		</p>

		<p class="forgot-password">
			<a href="/CATIA_TRAINING/Login.jsp">Login</a>
		</p>
	</form>
</body>
</html>