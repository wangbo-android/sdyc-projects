<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form commandName="productpaper" action="save_productpaper" enctype="multipart/form-data">
		Name:<form:input path="name"/><br/>
		Description:<form:input path="desciption"/><br/>
		<input type="file" name="images[0]"/><br/>
		<input type="submit" value="提交"/>
		
	</form:form>
	
</body>
</html>