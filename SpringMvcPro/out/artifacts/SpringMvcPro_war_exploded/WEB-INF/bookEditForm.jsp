<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑图书</title>
</head>
<body>
    <div id="global">
        <c:url value="/update-book" var="formAction" />
        <form:form commandName="book" method="post" action="${formAction}">
            <fieldset>
                <legend>编辑一本图书</legend>
                <form:hidden path="id" />
                <p>
                    <label for="category">Category:</label>
                    <form:select path="category.id" id="category" items="${categories}" itemLabel="name" itemValue="id" />
                </p>
                <p>
                    <label for="title">Title:</label>
                    <form:input path="title" id="title" />
                </p>
                <p>
                    <label for="author">Author:</label>
                    <form:input path="author" id="author" />
                </p>
                <p>
                    <label for="isbn">ISBN:</label>
                    <form:input path="isbn" id="isbn" />
                </p>
                <p id="buttons">
                    <input type="reset" id="reset" />
                    <input type="submit" id="submit" value="编辑图书" />
                </p>
            </fieldset>
        </form:form>
    </div>
</body>
</html>
