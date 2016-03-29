<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="catalogURL" value="/catalog.html" />
	<c:url var="cartURL" value="/displayCart.html" />
	<c:url var="welcome" value="/welcome.html" />
<aside>
	<UL>	
	<LI><A class="header" HREF="${catalogURL}"> Browse Catalog </A> </LI>
	<LI><A class="header" HREF="${cartURL}"> Show Cart</A> </LI>	
	<LI><A class="header" HREF="${welcome}"> Back to Site Homepage</A></LI>
</UL>
</aside>