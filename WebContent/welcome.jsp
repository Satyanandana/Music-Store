<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/includes/header.jsp" />
  
    <c:url var="admin" value="/admin/adminWelcome.html" />
	<c:url var="user" value="/userWelcome.html" />
  <H1> Welcome to the Music Store</H1>
  <H2> Please select a Service</H2>
<div id="home-buttons">
    <A class="home" HREF="${admin}">Admin Service</A>
    <A class="home" HREF="${user}">User Service</A>
 </div>   
    

<jsp:include page="/includes/footer.jsp" />