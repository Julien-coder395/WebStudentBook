<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Student Book</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>ESILV Engineer School</h2>
	</div>
</div>
<div style="margin-top:10px">
	<form action="StudentList" method="post">
		<input type="submit" value="Add Student"/>
	</form>	
</div>
<div id="container">
	<div id="content">
		<table>
			<tr>
				<th>First name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			
			<c:forEach var="tempStudent" items="${STUDENT_LIST}">
				<c:url var="EditLink" value="EditStudentServlet">
				<c:param name="studentId" value="${ tempStudent.id }"/>
				</c:url>
					<tr>
						<td> ${tempStudent.firstName}</td>
						<td> ${tempStudent.lastName}</td>
						<td> ${tempStudent.email}</td>
						<td> <a href="${ EditLink }">Edit</a></td>				
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>