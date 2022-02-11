<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Police at 45!</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/LoginRegister.css"/>
</head>


<body>
	<div id = "container">
		
		<div id = "upper">	
			<img src = '<c:url value="/resources/Policebanner.jpg"/>' id = "banner" alt = "banner">
		</div>
		<div id = "eighties">
			
				<div id = "header">
					<p class = "one"><a href = '/police45/albums'>Albums</a></p>
					<p class = "one"><a href = '/police45/biography'>Biography</a></p>
				</div>
			<h1>The Police at 45!</h1>
			<h3>Cataloging all the hits since 1977</h3>
			<div id = "middle">
				<div id = "leftcol">
					<p>Create an account and make your own custom Police track list! </p>
			 		<form:form method="POST" action="/registration/submit" modelAttribute="newuser">
				 
				        <p>
				            <form:label path="firstname">First Name:</form:label>
				            <form:input type="text" path="firstname"/>
				            <br>
				            <form:errors class = "text-danger" path = "firstname"/>
				        </p>
				        <p>
				            <form:label path="lastname">Last Name:</form:label>
				            <form:input type="text" path="lastname"/>
				            <br>
				            <form:errors class = "text-danger" path = "lastname"/>
				            
				        </p>
				        <p>
				            <form:label path="email">Email:</form:label>
				            <form:input type="text" path="email"/>
				            <br>
				            <form:errors class = "text-danger" path = "email"/>
				            
				        </p>
				        
				        <p>
				            <form:label path="password">Password:</form:label>
				            <form:password path="password"/>
				            <br>
				            <form:errors class = "text-danger" path = "password"/>
				            
				        </p>
				        <p>
				            <form:label path="confirmpassword">Confirm Password:</form:label>
				            <form:password path="confirmpassword"/>
				            <br>
				            <form:errors class = "text-danger" path = "confirmpassword"/>
				            
				        </p>
				        
				        <input type="submit" class="btn btn-primary" value="Register!"/>
		    		</form:form>
				</div>
				
				<div id = "rightcol">
					<p>Login and create a playlist of all your favorite Police tracks!:</p>
		    		<form:form method="POST" action="/login" modelAttribute="newuser">
		    			<p id = "loginconfirm"><c:out value = "${error}"/></p>
		     				<p>
					            <form:label path="email">Email:</form:label>
					            <form:input type="text" path="email"/>
			        		</p>
			    			<p>
					            <form:label path="password">Password:</form:label>
					            <form:password path="password"/>
			        		</p>
		
		        		<input type="submit" class="btn btn-primary" value="Login"/>
		     		</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>