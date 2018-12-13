<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Input Item</title>
</head>
<body>
    <form:form commandName="productItem" action="/add-item" method="post">
        <form:errors path="name" /><<br>
        <form:input path="name" /><br>
        <form:errors path="itemDate" /><br>
        <form:input path="itemDate" /><br>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>
