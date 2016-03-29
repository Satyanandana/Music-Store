<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="admin" value="/admin/adminWelcome.html" />
	<c:url var="user" value="/userWelcome.html" />
	<c:url var="welcome" value="/welcome.html" />
<aside>
	<UL>	
	<LI><A class="header" HREF="${admin}">Admin Service </A> </LI>
	<LI><A class="header" HREF="${user}">User Service</A> </LI>	
	<LI><A class="header" HREF="${welcome}"> Back to Site Homepage</A></LI>
</UL>
</aside>