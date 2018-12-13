<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
    <div id="global">
        <h1>Book List</h1>
        <a href="<c:url value="/input-book" />">添加书籍</a>
        <table>
            <tr>
                <th>Category</th>
                <th>Title</th>
                <th>ISBN</th>
                <th>Author</th>
                <th>Price</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <th>${book.category.name}</th>
                    <th>${book.title}</th>
                    <th>${book.isbn}</th>
                    <th>${book.author}</th>
                    <th>${book.price}</th>
                    <th><a href="/edit-book/${book.id}">编辑</a></th>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>