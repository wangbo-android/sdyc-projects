<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书籍添加</title>
</head>
<body>
    <div id="global">
        <form:form commandName="book" action="/save-book" method="post">
            <fieldset>
                <legend>Add a Book</legend>
                <p>
                    <label for="category">Category:</label>
                    <form:select path="category.id" id="category" items="${categories}"
                                 itemLabel="name" itemValue="id"/>
                </p>
                <p>
                    <label for="title">Title:</label>
                    <form:input path="title" id="title"/>
                </p>
                <p>
                    <label for="author">Author:</label>
                    <form:input path="author" id="author"/>
                </p>
                <p>
                    <label for="isbn">Isbn:</label>
                    <form:input path="isbn" id="isbn"/>
                </p>
                <p id="buttons">
                    <input type="reset" id="reset" />
                    <input type="submit" id="submit" value="添加" />
                </p>
            </fieldset>
        </form:form>
    </div>
</body>
</html>
