
<jsp:include page="/includes/header.jsp" />
<!--  begin middle column -->


<jsp:include page="/includes/column_left_order.jsp" /> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<content>

<h1>Catalog</h1>


<table>
	<tr>
	    <th >Product Code</th>
		<th >Description</th>
		<th >Price</th>	
		<th >Add To Cart</th>	
		
	</tr>
	<c:forEach var="product" items="${products}">
	<tr>
	<td>${product.code}</td>
		<td>
			<a href="<c:url value='/displayProduct.html?productCode=${product.code}' />">${product.description}	</a>
		</td>
		<td>${product.getPrice()}</td>
		<td>
		<form action="<c:url value='/displayCart.html' />" method="post">
					<input type="hidden" name="productCode" value="${product.code}">
					<input type="submit" name="addtocart" value="Add To Cart">
				</form>
			<%-- <a href="<c:url value='/displayCart.html?productCode=${product.code}' />">Add to Cart	</a> --%>
		</td>
	</tr>
	</c:forEach>  	
</table> 


</content>
<!--  end middle column -->

<jsp:include page="/includes/footer.jsp" />