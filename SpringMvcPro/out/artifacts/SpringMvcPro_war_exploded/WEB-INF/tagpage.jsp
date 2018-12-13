<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring标签练习</title>
</head>
<body>
    <form:form commandName="formPage" method="post" action="/getFormInfo">
        <form:checkbox path="check" value="out of stock" />选择<br>
        <form:radiobutton path="radio" value="yes" />是
        <form:radiobutton path="radio" value="no" />否<br>
        <form:checkboxes path="checks" items="${categoryList}" itemValue="id" itemLabel="name" /><br>
        <input type="submit" value="提交" />
    </form:form>
</body>
</html>
