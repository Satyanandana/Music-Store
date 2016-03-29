<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/header.jsp"/>
<jsp:include page="/includes/leftcolumn.jsp"/>

<content>

<H1>Welcome to the Music Store!</H1>
<H2>Please select a Service:</H2>	
	

	<!-- Define relative links for various cases: 
		c:url handles URL rewriting if needed to maintain session -->
	<c:url var="catalogURL" value="/catalog.html" />
	<c:url var="cartURL" value="/displayCart.html" />
<UL>	
	<LI><A HREF="${catalogURL}"> Browse Catalog </A> </LI>
	<LI><A HREF="${cartURL}"> Show Cart</A> </LI>	
	<LI><A HREF="welcome.html"> Back to Site Homepage</A></LI>
</UL>
</content>
<jsp:include page="/includes/footer.jsp" />