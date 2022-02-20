<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biography</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resources/Bio.css"/>

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
		
		<h1>A short biography of the Police:</h1>
		<p class = "bodyparagraph"> The Police are a band that blended rock and new-wave music genres in the late 1970s and early 1980s.  Spawned by the post-'punk' era,
		the band consisted of Steward Copeland (drums), Andy Summers (guitar), and Gordon Sumner alias Sting (bass, vocals). </p>
		
		<p class = "bodyparagraph"> The band first formed in Essex County in London in 1977. Their first album (Outlandos D'Amour) was released the very next year, and spawned the
		band's first charting U.S. hit "Roxanne."  In 1979, the band's sophomore effort (Regatta de Blanc) spawned the hits "Message in a Bottle" and
		"Walking on the Moon."  In 1980, the band released their breakthrough U.S. album Zenyatta Mondatta, 
		which spawned two Top 10 U.S. Billboard Hits "Don't Stand So Close To Me" and "De Do Do Do De Da Da Da."  The band's fourth album "Ghost In the Machine"
		resulted in the hit "Every Little Thing She Does Is Magic", which charted at #3 on the U.S. Billboard. </p>
		
		<p class = "bodyparagraph"> The band experienced considerable tension in the months leading up to their fifth and final album "Synchronicity," released in 1983.  It was the band's most successful album, and sales
		reached eight-time Platinum status in the U.S.  The album spawned the Top 10 hits "Every Breath You Take" (#1 in the US and UK),
		"King of Pain" (#3 in the US), and "Wrapped Around Your Finger"(#8 in the US).  Following the band's successful world tour, which
		consisted of sold-out crowds worldwide, the band began to embark on a sixth album project which was ultimately scrapped.
		The Police managed to released one final single ("Don't Stand So Close to Me '86") before disbanding.  The band did briefly reunite for a successful 
		world tour in 2007.
		</p>
		
		<div id = "header">
					<p class = "one"><a href = '/returnpolice45'>Return to the Login page!</a></p>
			</div>
		
		
		</div>
		
		
	</div>

</body>
</html>