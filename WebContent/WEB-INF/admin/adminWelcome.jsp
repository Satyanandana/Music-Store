<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/header.jsp"/>
<jsp:include page="/includes/leftcolumn.jsp"/>

<content>

<H1>Welcome to the Music Store!</H1>
<H2>Please select a Service:</H2>	
	

	<!-- Define relative links for various cases: 
		c:url handles URL rewriting if needed to maintain session -->
	<c:url var="allinvoices" value="/admin/allinvoices.html" />
	<c:url var="unproinvoices" value="/admin/unprocessedinvoices.html" />
	<c:url var="downloads" value="/admin/downloads.html" />
	<c:url var="initialize" value="/admin/reInitializeDb.html" />
	<c:url var="welcome" value="/welcome.html" />
<UL>	
	<LI><A HREF="${allinvoices}"> All Invoices </A> </LI>
	<LI><A HREF="${unproinvoices}">Unprocessed Invoices</A> </LI>	
	<LI><A HREF="${downloads}">Downloads</A> </LI>	
	<LI><A HREF="${initialize}">ReInitialize Database</A> </LI>	
	<LI><A HREF="${welcome}"> Back to Site Homepage</A></LI>
</UL>
</content>
<jsp:include page="/includes/footer.jsp" />