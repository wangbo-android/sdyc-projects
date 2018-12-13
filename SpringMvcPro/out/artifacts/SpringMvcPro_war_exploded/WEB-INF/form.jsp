<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form表单</title>
</head>
<body>
    <form:form commandName="student" action="/uploadInfo" method="post">
        <form:input path="name" /><br>
        <form:input path="age" /><br>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>
