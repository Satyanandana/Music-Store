<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/leftcolumn.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="center">
		<p style="text-align:center;color: red">	${error}</p>

	<form name="login" method="post" action="<c:url value='${nextPageURL}' />"
		onSubmit="return formValidation();" class="login">
		<input type="hidden" name="preUrl" value="${preUrl}" >
		<input type="hidden" name="proCode" value="${proCode}" >
		<input type="hidden" name="trackNum" value="${trackNum}" >

		<p>
			<label for="Email">Email:</label> <input type="text" name="Email"
				id="Email" placeholder="Enter Email ID" required> <span
				id="email"></span>
		</p>

		
		<p class="login-submit">
			<button type="submit" class="login-button">Login</button>
		</p>

		
		<p class="forgot-password">
			<a href="<c:url value='register.html?preUrl=${preUrl}&proCode=${proCode}&trackNum=${trackNum}' />">Register</a>
		</p>
	</form>
</section>
<jsp:include page="/includes/footer.jsp" />