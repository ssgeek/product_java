<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Product Tutorial</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<section  class="row">
		<form action="product" method="post">
			<table>
				<tr>
					<td>Key Word</td>
					<td><input type="text" name="kword" ></td>
					<td><input type="submit" value="search" name="action"></td>
				</tr>
			</table>
		</form>
	</section>
	<br>
	<div class="row">
		<table class="table">	
			<tr>
				<th>Reference</th>
				<th>Title</th>
				<th>Price</th>
				<th>Quantity</th>
				<th></th>
			</tr>
			<c:forEach items="${modelProduct.products}" var="p">
				<tr>
					<td>${p.reference}</td>
					<td>${p.title }</td>
					<td>${p.price }</td>
					<td>${p.quantity }</td>
					<td><a href="product?action=delete&reference=${p.reference}">Delete</a></td>
					<td><a href="product?action=edit&reference=${p.reference}">Edit</a></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	<br>
	<div class="row">
	
		<form action="product" method="post">
			
			<div class="form-group">
				<label for="reference">Reference:</label>
				<input class="form-control" type="text" name="reference" >
			</div>
			<div class="form-group">
				<label for="title">Title:</label>
				<input class="form-control" type="text" name="title" >
			</div>
			<div class="form-group">
				<label for="price">Price:</label>
				<input class="form-control" type="text" name="price" >
			</div>
			<div class="form-group">
				<label for="quantity">Quantity:</label>
				<input class="form-control" type="text" name="quantity" >
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" value="save" name="action">Save </button>
			</div>

		
		</form>
	
	</div>
</div>
</body>
</html>