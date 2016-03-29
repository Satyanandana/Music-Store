<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/leftcolumn.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<content>
<h1>Admin Login</h1>
<section id="center">
		<p style="text-align:center;color: red">	${error}</p>

	<form name="login" method="post" action="<c:url value='${nextPageURL}' />"
		onSubmit="return formValidation();" class="login">
		<input type="hidden" name="preUrl" value="${preUrl}" >
		

		<p>
			<label for="username">Username:</label> <input type="text" name="username"
				id="username" placeholder="Enter Email ID" required> <span
				id="username"></span>
		</p>
		<p>
			<label for="password">Password:</label> <input type="text" name="password"
				id="password" placeholder="Enter Email ID" required> <span
				id="password"></span>
		</p>

		
		<p class="login-submit">
			<button type="submit" class="login-button">Login</button>
		</p>

</form>
</section>
</content>
<jsp:include page="/includes/footer.jsp" />