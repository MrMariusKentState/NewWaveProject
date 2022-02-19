<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/playlist.css"/>

</head>
<body>
	<div id = "container">
			<div id = "upper">	
				<img src = '<c:url value="/resources/Policebanner.jpg"/>' id = "banner" alt = "banner">
			</div>
			<div id = "header">
				<p class = "one"><a href = '/police45/albums'>Albums</a></p>
				<p class = "one"><a href="/logout">Logout</a></p>
			</div>
		<h1>Welcome <c:out value = "${person.firstname}" />!</h1>
		<h3>Here is your custom playlist of Police tracks !</h3>
		<p>Go to the Albums menu above, and select an album to add more songs!
		If you have an existing Spotify account, click on the link next to each song to listen to each track! Otherwise, you may use Spotify links to create a FREE Spotify account!</p>
		
		
					<table class = "table table-bordered">
				    <thead>
				        <tr>
				            <th scope = "col">Song</th>
				            <th scope = "col">Album</th>
				            <th scope = "col">Spotify link</th>
				            <th scope = "col">Action</th>
				        </tr>
				    </thead>
					<tbody>
					<c:forEach items="${allsongs}" var="onesong">  
						<tr>
							<td><c:out value="${onesong.song_title}"/></td>
							<td><c:out value="${onesong.a}"/></td>
							<td><a href = "${onesong.chart_notes}">Spotify link</a></td>
							<td><a href = "/song/unlike/${onesong.id}">Remove from playlist</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			
		
	</div>
	

</body>
</html>