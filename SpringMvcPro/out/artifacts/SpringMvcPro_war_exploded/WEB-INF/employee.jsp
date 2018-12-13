<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>雇员</title>
</head>
<body>
    <form:form commandName="emp" action="/add-emp" method="post">
        <form:input path="firstName" /><br>
        <form:input path="secondName" /><br>
        <form:input path="birthDate" /><br>
        <input type="submit" value="提交" />
    </form:form>
</body>
</html>
