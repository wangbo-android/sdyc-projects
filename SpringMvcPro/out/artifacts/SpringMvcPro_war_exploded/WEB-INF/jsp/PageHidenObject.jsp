<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Page Hiden</title>
</head>
<body>
    <h1>${pageContext.request.method}</h1>
    <h1>${pageContext.request.protocol}</h1>
    <h1>${pageContext.request.locales}</h1>
    <h1>${pageContext.request.contentType}</h1>
    <h1>${pageContext.request.serverPort}</h1>
    <%--<h2>${[1,2,3,10].stream().max().get()}</h2>--%>
</body>
</html>
