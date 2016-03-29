<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/leftcolumn.jsp"/>

<section id="center">
	<h1>Download registration</h1>

	<p>Before you can download and listen to these sound files, you
		must register with us by entering your name and email address below</p> <!-- Import the core JSTL library  -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- Use the JSTL url tag to encode the URL which is determined by that page that led us here -->
	<form name="login" method="post"	action="<c:url value='/register.html' />"
		onSubmit="return formValidation();" class="login">
		<input type="hidden" name="preUrl" value="${preUrl}">
		<input type="hidden" name="proCode" value="${proCode}" >
		<input type="hidden" name="trackNum" value="${trackNum}" >
		<p>
			<label for="firstName">FirstName:</label> <input type="text"
				name="firstName" id="firstName" placeholder="Enter your firstname"
				required> <span id="firstName"></span>
		</p>
		<p>
			<label for="lastName">LastName:</label> <input type="text"
				name="lastName" id="lastName" placeholder="Enter your firstname"
				required> <span id="lastName"></span>
		</p>

		<p>
			<label for="emailAddress">Email:</label> <input type="email"
				name="emailAddress" id="emailAddress" placeholder="Enter Email Id"
				required>
		</p>

		<p class="login-submit">
			<button type="submit" class="login-button">Register</button>
		</p>


		<p class="forgot-password">
			<a href="<c:url value='login.html?preUrl=${preUrl}&proCode=${procode}&trackNum=${trackNum}' />">Login</a>
		</p>
	</form>
	
</section>

<jsp:include page="/includes/footer.jsp" />