<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User info!</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/UserEdit.css"/>
</head>
<body>
	<div id = "container">
			<div id = "upper">	
				<img src = '<c:url value="/resources/Policebanner.jpg"/>' id = "banner" alt = "banner">
			</div>
			<div id = "header">
				<p class = "one"><a href = '/police45/albums'>Albums</a></p>
				<p class = "one"><a href = '/police45/playlist'>Playlist</a></p>
				<p class = "one"><a href="/logout">Logout</a></p>
			</div>
		<h1>Welcome <c:out value = "${user.firstname}" />!</h1>
		<h3>Update your account information below!</h3>
		<form:form method="POST" action="/police45/update/${user.id}" modelAttribute="edituser">
		     	<p id = "updates"><c:out value = "${success}"/></p>
		     	<p>
		            <form:label path="firstname">First Name:</form:label>
		            <form:input type="text" value = "${user.firstname}" path="firstname"/>
		        	<br>
		        	
		        </p>
		        <p>
		            <form:label path="lastname">Last Name:</form:label>
		            <form:input type="text" value = "${user.lastname}" path="lastname"/>
		        	<br>
		        	
		        </p>
		        <p>
		            <form:label path="email">Email:</form:label>
		            <form:input type="text" value = "${user.email}" path="email"/>
		            <br>
		            
				            
		        </p>
		        <p>
		            <form:label path="password">New Password (will remain hidden):</form:label>
		            <form:password path="password"/>
		            <br>
		               
		        </p>
		        <p>
		            <form:label path="confirmpassword">Confirm Password (will remain hidden):</form:label>
		            <form:password path="confirmpassword"/>
		            <br>
		                
		        </p>
		        
		    <input type="submit" class="btn btn-primary" value="Update"/>
			</form:form>
		
	</div>
</body>
</html>