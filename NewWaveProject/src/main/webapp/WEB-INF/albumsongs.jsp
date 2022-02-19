<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songs for each album</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/albumsongs.css"/>
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
			<h1>Welcome <c:out value = "${person.firstname}" />!</h1>

		</div>
<h1>Song list for the ${album.album_name} album</h1>
<h4>You may listen to each song on Spotify if you have an existing account</h4>
<h4>Or, click on the Spotify link to create a free account!</h4>
<p id = "updates"><c:out value = "${success}"/></p>
<p id = "updates"><c:out value = "${remove}"/></p>
<table class = "table table-bordered">
		<thead>
	        <tr>
	            <th scope = "col">Song title</th>
	            <th scope = "col">Spotify link</th>
	            <th scope = "col">Actions</th>
	        </tr>
	    </thead>
		<tbody>
			<c:forEach items="${mysongs}" var="onesong">  
				<tr>
					<td><c:out value="${onesong.song_title}"/></td>
					<td><a href = "${onesong.chart_notes}">Spotify link</a></td>
					<td>
						<c:choose>
		    				<c:when test = "${onesong.users.contains(person)}">
		    					<a href = "/song/unlike/${album.id}/${onesong.id}">Remove from playlist</a>
		    				</c:when>
		    				<c:otherwise>	
					    		<a href = "/song/like/${album.id}/${onesong.id}">Add to Playlist</a>
					    		
					    	</c:otherwise>
				    	</c:choose>		
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>