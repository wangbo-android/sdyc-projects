<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="save_product" commandName="product" method="post">
		<fieldset>
			<legend>Add a product</legend>
			
			<p>
				<form:errors path="name"></form:errors>
			</p>
			
			<p>
				<label for="name">Product Name:</label>
				<form:input path="name" tabindex="1"/>
			</p>
			
			<p>
				<form:errors path="description"></form:errors>
			</p>
			
			<p>
				<label for="description">Description:</label>
				<form:input path="description" tabindex="2"/>
			</p>
			
			<p>
				<form:errors path="price"></form:errors>
			</p>
			
			<p>
				<label for="price">Price:</label>
				<form:input path="price" tabindex="3"/>
			</p>
			
			<p>
				<form:errors path="productionDate"></form:errors>
			</p>
			
			<p>
				<label for="productionDate">Production Date:</label>
				<form:input path="productionDate" tabindex="4"/>
			</p>
			
			<p>
				<input type="reset" tabindex="5" value="Reset"/>
				<input type="submit" tabindex="6" value="Add"/>
			</p>
		</fieldset>
	</form:form>
</body>
</html>