<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="product" method="post">
			<table>
				<tr>
					<td>Key Word</td>
					<td><input type="text" name="kword" ></td>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div>
		<table>	
			<tr>
				<th>Reference</th>
				<th>Title</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${modelProduct}" var="p">
				<tr>
					<td>${p.reference }</td>
					<td>${p.title }</td>
					<td>${p.price }</td>
					<td>${p.quantity }</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>