<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/leftcolumn.jsp" /> 


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<content>
<h1>All downloads</h1>
<c:choose>
<c:when test="${downloads.size()==0 }">
<h1>No downloads to show</h1>
</c:when>
<c:otherwise>
<table>
	<tr>
		<th>Download Id</th>
		<th>Download Date</th>
		<th>Track Id</th>
		<th>User Id</th>
	</tr>
	
	<c:forEach var="download" items="${downloads}">
	<tr>
		<td>${download.downloadId }</td>
		<td>${download.downloadDate }</td>
		<td>${download.track.trackId }</td>
		<td>${download.getUser().getUserId()}</td>
	</tr>
	</c:forEach>
	
</table>
</c:otherwise>
</c:choose>
</content>

<jsp:include page="/includes/footer.jsp" /> 