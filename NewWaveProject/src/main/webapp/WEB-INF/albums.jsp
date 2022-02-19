<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Police albums</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/albums.css"/>
</head>
<body>
		<div id = "container">
			<div id = "upper">	
				<img src = '<c:url value="/resources/Policebanner.jpg"/>' id = "banner" alt = "banner">
			</div>
			<div id = "header">
				<p class = "one"><a href = '/police45/playlist'>Playlist</a></p>
				
				<p class = "one"><a href="/logout">Logout</a></p>
			</div>
		<h1>Welcome <c:out value = "${person.firstname}" />!</h1>
		<h3>Here is a list of studio albums released by the Police:</h3>
		<p>Select an album below to add tracks to your custom playlist!</p>
		
		
	</div>
	
	<table class = "table table-bordered">
		<thead>
	        <tr>
	            <th scope = "col">Album Name</th>
	            <th scope = "col">Highest US Chart</th>
	            <th scope = "col">Highest UK Chart</th>
	            <th scope = "col">Year Released</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${allalbums}" var="onealbum">  
				<tr>
					<td><a href = "/police45/albums/${onealbum.id}"><c:out value="${onealbum.album_name}"/></a></td>
					<td><c:out value ="${onealbum.US_chart}"/></td>
					<td><c:out value = "${onealbum.UK_chart}"/></td>
					<td><c:out value = "${onealbum.year_released}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>