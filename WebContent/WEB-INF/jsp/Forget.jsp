<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
<link rel="stylesheet" href="css/forget.css">
<%
	String error = (String) request.getAttribute("Errormsg");
%>
</head>
<body>
	<div>
		<img alt="forget password" src="images/lock.svg" width="200px">
		<div id=errormsg>
			<p>
				<%
				out.println(error);
			%>
			</p>
		</div>
		<script type="text/javascript">
var s="<%=error%>";

if(s == "null"){
	var elid=document.getElementById("errormsg");
	elid.style.display = "none";
	}	
	
</script>
		<form method="post" action="ForgetPass">
			<p>Forget your password ?</p>
			<p>
				<input type="email" id="email" name="email"
					placeholder=" Enter your email Id" required>
			</p>
			<p>
				<input type="submit" value="Submit" id="button" />
			</p>

		</form>
	</div>

</body>
</html>