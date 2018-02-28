<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div align="center">
	        <h1>Students List</h1>
	        <h2><a href="new1">New Student</a></h2>
	        
        	<table border="1">
	        	<th>Id</th>
				<th>name</th>
				<th>place</th>
                <th>Actions</th>
	        
	        	
				<c:forEach var="stud" items="${studentList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${stud.name}</td>
					
					<td>
						<a href="edit1?id=${stud.studentid}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete1?id=${stud.studentid}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
