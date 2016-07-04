<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="book" method="post" action="saveBook">
		<form:input path="id" id="book_id"/><br/>
		<form:input path="name" id="name"/><br/>
		<form:input path="price" id="price"/><br/>
		<form:password path="password" showPassword="false"/><br/>
		<form:hidden path="id"/><br/>
		<form:textarea path="text" id="textArea" rows="5" cols="80" tabindex="4"/>
	</form:form>
</body>
</html> 