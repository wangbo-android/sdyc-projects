<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Input Product</title>
</head>
<body>
    <form:form commandName="product" action="/add-product" method="post">

        <form:errors path="name" cssClass="default-color1" /><br>
        name:<form:input path="name" cssClass="default-color1"/><br>
        <form:errors path="price" cssClass="default-color1" /><br>
        price:<form:input path="price" cssClass="default-color1" /><br>
        <form:errors path="productDate" cssClass="default-color1" /><br>
        productDate:<form:input path="productDate" cssClass="default-color1" /><br>
        <form:errors path="description" cssClass="default-color1" /><br>
        description:<form:input path="description" cssClass="default-color1" /><br>
        <input type="submit" value="提交" />
    </form:form>
</body>
</html>
