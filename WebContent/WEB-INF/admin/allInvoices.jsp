<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/leftcolumn.jsp" /> 


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<content>
<h1>All Invoices</h1>
<c:choose>
<c:when test="${invoices.size()==0 }">
<h1>No invoices to show</h1>
</c:when>
<c:otherwise>
<table>
	<tr>
		<th>Invoice Id</th>
		<th>User Id</th>
		<th>Invoice Date</th>
		<th>Processed</th>
		<th>Total Price</th>
	</tr>
	
	<c:forEach var="invoice" items="${invoices}">
	<tr>
		<td>${invoice.invoiceId }</td>
		<td>${invoice.getUser().getUserId()}</td>
		<td>${invoice.invoiceDate }</td>
		<td>${invoice.isProcessed }</td>
		<td>${invoice.totalAmount }</td>
	</tr>
	</c:forEach>
	
</table>
</c:otherwise>
</c:choose>
</content>

<jsp:include page="/includes/footer.jsp" /> 