<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_order.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<content>
<br>
<h1>Product Info</h1>
<br>

<p >Product Code: ${product.getCode()} </p>

<p>Product Description: ${product.getDescription()} </p>

<p>Price: ${product.getPrice()} </p>
<h1>Tracks</h1>

	<table>
		<tr>
			<th align="left">Song</th>
			<th align="left">Listen</th>

		</tr>
		<c:forEach var="track" items="${product.tracks}">
			<tr>
				<td>${track.title}</td>
				<td><a href="<c:url value='/listen.html?proCode=${product.getCode()}&trackNum=${track.getTrackNumber()}' />">Listen</a></td>
			</tr>
		</c:forEach>
	</table>
	</content>
	<jsp:include page="/includes/footer.jsp" />