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
<link rel="stylesheet" href="/resources/LoginRegister.css"/>
</head>


<body>
	<div id = "container">
		
		<div id = "upper">
		<marquee behavior="slide" direction="left">
				<img class = "bottom" src = '<c:url value ="/resources/Logo.jpg"/>'  id = "banner2" alt = "banner2">
				<img class = "bottom" src = '<c:url value="/resources/Policebanner.jpg"/>' id = "banner" alt = "banner">
				<img class = "top" src = '<c:url value ="/resources/Ghost.jpg" />' id = "banner3" alt = "banner3">
				<img class = "top" src = '<c:url value ="/resources/zenyatta.jpg" />' id = "banner4" alt = "banner4">
				<img class = "top" src = '<c:url value ="/resources/outlandos.jpg" />' id = "banner5" alt = "banner5">
		</marquee>
		</div>
		<div id = "eighties">
				<h1>THE POLICE</h1>
				<h3>45 years after first banding together, the Police remain as one of the most influential music acts in modern history.</h3>
				<div id = "header">
					<p id = "hello">Click on the <a href = '/police45/biography' id = "bio">Biography</a> link to learn more about the classic rock band the Police!
					Or, create a FREE account and make your own custom Spotify playlist of songs from the Police!</p>
				</div>
			
			<div id = "middle">
				<div id = "leftcol">
					<p class = "welcome">Create a free account! </p>
			 		<form:form method="POST" action="/registration/submit" modelAttribute="newuser">
				 
				        <p>
				            <form:label path="firstname">First Name:</form:label>
				            <form:input class = "label" type="text" path="firstname"/>
				            <br>
				            <form:errors class = "text-danger" path = "firstname"/>
				        </p>
				        <p>
				            <form:label path="lastname">Last Name:</form:label>
				            <form:input class = "label" type="text" path="lastname"/>
				            <br>
				            <form:errors class = "text-danger" path = "lastname"/>
				            
				        </p>
				        <p>
				            <form:label path="email">Email:</form:label>
				            <form:input class = "label" type="text" path="email" />
				            <br>
				            <form:errors class = "text-danger" path = "email"/>
				            
				        </p>
				        
				        <p>
				            <form:label path="password">Password:</form:label>
				            <form:password class = "label" path="password"/>
				            <br>
				            <form:errors class = "text-danger" path = "password"/>
				            
				        </p>
				        <p>
				            <form:label path="confirmpassword">Confirm Password:</form:label>
				            <form:password class = "label" path="confirmpassword"/>
				            <br>
				            <form:errors class = "text-danger" path = "confirmpassword"/>
				            
				        </p>
				        
				        <input type="submit" class="btn btn-primary" value="Register!"/>
		    		</form:form>
				</div>
				
				<div id = "rightcol">
					<p class = "welcome">Login to create a playlist of all your favorite Police tracks!:</p>
		    		<form:form method="POST" action="/login" modelAttribute="newuser">
		    			<p id = "loginconfirm"><c:out value = "${error}"/></p>
		     				<p>
					            <form:label path="email">Email:</form:label>
					            <form:input class = "label2" type="text" path="email"/>
			        		</p>
			    			<p>
					            <form:label path="password">Password:</form:label>
					            <form:password class = "label2" path="password"/>
			        		</p>
		
		        		<input type="submit" class="btn btn-primary" value="Login"/>
		     		</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>