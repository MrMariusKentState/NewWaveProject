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
			<marquee behavior="slide" direction="left">
				<img class = "bottom" src = '<c:url value ="/resources/Logo.jpg"/>'  id = "banner2" alt = "banner2">
				<img class = "bottom" src = '<c:url value="/resources/Policebanner.jpg"/>' id = "banner" alt = "banner">
				<img class = "top" src = '<c:url value ="/resources/Ghost.jpg" />' id = "banner3" alt = "banner3">
				<img class = "top" src = '<c:url value ="/resources/zenyatta.jpg" />' id = "banner4" alt = "banner4">
				<img class = "top" src = '<c:url value ="/resources/outlandos.jpg" />' id = "banner5" alt = "banner5">
			</marquee>
			</div>
		<div id = "eighties">
			<div id = "header">
				<p class = "one"><a href = '/police45/albums'>Albums</a></p>
				<p class = "one"><a href = '/police45/playlist'>Playlist</a></p>
				
				<p class = "one"><a href="/logout">Logout</a></p>
			</div>
			<h1>Welcome <c:out value = "${person.firstname}" />!</h1>

		
		<h1>Song list for the album: ${album.album_name} </h1>
		<h4>Add songs to your playlist, or click on any of the embedded Spotify audio links to listen to your favorite songs!</h4>
		<p>You must have an existing Spotify account to listen to the full tracks.  If you are unable to listen to a full track, click on the Spotify links
		to listen to track excerpts, to login to Spotify, or to create a FREE Spotify account!</p>

	
	<p id = "updates"><c:out value = "${success}"/></p>
	<p id = "updates"><c:out value = "${remove}"/></p>
	<table class = "table table-bordered">
			<thead>
		        <tr>
		            <th scope = "col"  class = "header">SONG TITLE</th>
		            <th scope = "col"  class = "header">ACTIONS</th>
		            <th scope = "col"  class = "header">LISTEN!</th>
		    
		        </tr>
		    </thead>
			<tbody>
				<c:forEach items="${mysongs}" var="onesong">  
					<tr>
						<td class = "bold"><c:out value="${onesong.song_title}"/></td>
						<td class = "bold">
							<c:choose>
			    				<c:when test = "${onesong.users.contains(person)}">
			    					<a href = "/song/unlike/${album.id}/${onesong.id}">Remove from playlist</a>
			    				</c:when>
			    				<c:otherwise>	
						    		<a href = "/song/like/${album.id}/${onesong.id}">Add to Playlist</a>
						    		
						    	</c:otherwise>
					    	</c:choose>		
						</td>
						<td>
						<iframe style="border-radius:5px" src="https://open.spotify.com/embed/track/${onesong.song_albumname}?utm_source=generator" width="100%" height="25%" frameBorder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"></iframe>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</body>
</html>