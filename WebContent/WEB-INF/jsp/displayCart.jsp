<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_order.jsp" /> 


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<content>

<h1>Your cart</h1>
<c:choose>
<c:when test="${cart.items.size()==0 }">
<h1>Your cart is empty</h1>
</c:when>
<c:otherwise>
<table>
	<tr>
		<th align="left">Qty</th>
		<th align="left">Description</th>
		<th align="left">Price</th>
		<th align="left">Total</th>
		<th align="left">Remove</th>
	</tr>

	<c:forEach var="item" items="${cart.items}">
	
		<tr>
			<td>
				<form action="<c:url value='/displayCart.html' />" method="post">
					<input type="hidden" name="productCode" value="${item.product.code}">
					<input type="text" size="2" name="quantity" value="${item.quantity }">
					<input type="submit" value="Update">
				</form>
			</td>
			<td><%-- ${item.product.description} --%><a href="<c:url value='/displayProduct.html?productCode=${item.product.code}' />">${item.product.description}	</a></td>
			<td>${item.product.getPrice()}</td>
			<td>${item.calculateItemTotal()}</td>
			<td><form action="<c:url value='/displayCart.html' />" method="post">
					<input type="hidden" name="productCode" value="${item.product.code}">
					
					<input type="submit" name="removeButton" value="Remove">
				</form></td>
		</tr>			
	
	</c:forEach>
	<tr>
	<td></td>
	<td></td>
	
	<td>Cart Total</td>
	<td>${cart.getTotalAmount()}</td>
	<td></td>
	</tr>
	
</table>
<p><b>To change the quantity for an item</b>, enter the new quantity
				and click on the Update button.</p>
			<p><b>To remove an item</b>, click on the Remove button.</p>
</c:otherwise>
</c:choose>
<br><br>

<form action="<c:url value='/catalog.html' />" method="post">
	<input type="submit" value="Continue Shopping">
</form>
<br><br>
<form action="<c:url value='/checkout.html' />" method="post">
	<input type="submit" value="Checkout">
</form>

</content>
<jsp:include page="/includes/footer.jsp" />