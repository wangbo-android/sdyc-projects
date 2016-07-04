<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
	${productpaper.name }<br/>
	${productpaper.desciption }<br/>
	
	
	<c:forEach items="${productpaper.images}" var="image">
		<li>${image.originalFilename }
			<img width="100" src="<c:url value='/image/'/>${image.originalFilename}"/>
		</li>
	</c:forEach>
</body>
</html>