<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>ESILV Engineer School</h2>
	</div>
</div>

<form method="post" action="AddStudent">
<table>
	<tbody>
	<tr>
	<td><label>FirstName: </label> </td>
	<td><input type="text" name = "firstName"/></td>
	</tr>
	<tr>
	<td><label>LastName: </label> </td>
	<td><input type="text" name = "lastName"/></td>
	</tr>
	<tr>
	<td><label>Email: </label> </td>
	<td><input type="text" name = "email"/></td>
	</tr>
	<tr>
	<td><label></label> </td>
	<td><input type="submit" value = "Save"/></td>
	</tr>
	</tbody>
</table>
	<a href="/WebStudentBook/StudentList">Back to list</a>
</form>
		
<c:if test="${ !empty statusMessage }"><p><c:out value="${ statusMessage }"/></p></c:if>
</body>
</html>