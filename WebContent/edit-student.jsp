<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Edit a student</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>ESILV Engineer School</h2>
	</div>
</div>
<div id="container">
	<h3> Edit a Student</h3>
<form action="EditStudentServlet" method = "post">
<table>
	<tbody>
	<tr>
	<td><label>FirstName: </label> </td>
	<td><input type="text" name = "firstName" value="${Student.firstName}"/></td>
	</tr>
	<tr>
	<td><label>LastName: </label> </td>
	<td><input type="text" name = "lastName" value="${Student.lastName}"/></td>
	</tr>
	<tr>
	<td><label>Email: </label> </td>
	<td><input type="text" name = "email" value="${Student.email}"/></td>
	</tr>
	<tr>
	<td><label></label> </td>
	<td><input type="submit" value = "Save"/></td>
	</tr>
	</tbody>
</table>
</form>
<div style="clear:both;"></div>
	<a href="StudentControllerServlet">Back to List</a>
</div>
</body>
</html>
