<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><spring:message code="name" /></title>
</head>
<body>
    <h1>Current Locale : ${pageContext.response.locale}</h1>
    <h2><spring:message code="age" /></h2>
    <h2><spring:message code="name" /></h2>
</body>
</html>
