<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_order.jsp" /> 


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<content>
<h1>Your Order</h1>
<c:choose>
<c:when test="${invoice==null}">
<h1>Your order failed</h1>
</c:when>
<c:otherwise>
<h1>Your order has been placed successfully.Thank you</h1>

<p> ${user.firstname} </p>
<p> ${user.lastname} </p>
<p> ${user.emailAddress} </p>
<p> ${invoice.invoiceId} </p>
<p> ${invoice.totalAmount}</p>

<table>
	<tr>
		<th align="left">Id</th>
		<th align="left">Description</th>
		<th align="left">Qty</th>
		<th align="left">Price</th>
		<th align="left">Amount</th>
	</tr>

	<c:forEach var="item" items="${invoice.getLineItems()}">
	
		<tr>
		    <td>${item.lineitemId}</td>
			<td>${item.product.description}</td>
			<td>${item.quantity}</td>
			<td>${item.product.getPrice()}</td>
			<td>${item.calculateItemTotal()}</td>
			
		</tr>			
	
	</c:forEach>
	
	
</table>
</c:otherwise>
</c:choose>
<br><br>
</content>

<jsp:include page="/includes/footer.jsp" />