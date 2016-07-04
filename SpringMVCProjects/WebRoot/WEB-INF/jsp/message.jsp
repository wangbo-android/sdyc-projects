<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	Current Locale : ${pageContext.response.locale }<br/>
	accept-language header : ${header["accept-language"] }<br/>
	
	<spring:message code="name" text="name"></spring:message><br/>
	<spring:message code="age"></spring:message><br/>
	<spring:message code="birth"></spring:message>
</body>
</html>