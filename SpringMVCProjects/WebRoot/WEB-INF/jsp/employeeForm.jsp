<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="employee" action="save_employee" method="post">
		<fieldset>
			<legend>Add an employee</legend>
			<p>
				<label for="firstName">First Name:</label>
				<form:input path="firstName" tabindex="1"/>
			</p>
			
			<p>
				<label for="lastName">Last Name:</label>
				<form:input path="lastName" tabindex="2"/>
			</p>
			
			<p>
				<form:errors path="birthDate"></form:errors>
			</p>
			
			<p>
				<label for="birthDate">Birth Date:</label>
				<form:input path="birthDate" tabindex="3"/>
			</p>
			
			<p>
				<input type="reset" tabindex="4" value="Reset"/>
				<input type="submit" tabindex="5" value="Add"/>
			</p>
		</fieldset>
	</form:form>
</body>
</html>