<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>上传图片</title>
</head>
<body>
    <form:form method="post" commandName="image" action="/upload-image" enctype="multipart/form-data">
        <form:input cssErrorClass="error" path="name"/><br/>
        <input type="file" name="iamges" multiple="multiple"/><br>
        <input type="submit" value="上传">
    </form:form>
</body>
</html>
