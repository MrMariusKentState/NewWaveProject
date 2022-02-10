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
<link rel="stylesheet" href="/Bio.css"/>

</head>
<body>
	<div id = "container">
	
		<div id = "upper">	
			<img src = '<c:url value="/resources/Policebanner.jpg"/>' id = "banner" alt = "banner">
		</div>
	
		<div id = "header">
					<p class = "one"><a href = '/police45/albums'>Albums</a></p>
					<p class = "one"><a href = '/returnpolice45'>Login</a></p>
				</div>
		<h1>A short biography of the Police:</h1>
		<p> The Police are a new-wave band that were spawned from the post-punk era of the late 1970s. 
		The band consisted of Steward Copeland (drums), Andy Summers (guitar), and Gordon Sumner alias Sting (bass, vocals). 
		The band first formed in Essex County in London in 1977.  The first album was released in 1978 (Outlandos D'Amour), which launched the
		band's first charting U.S. hit "Roxanne."  The band's sophomore effort Regatta de Blanc spawned the hits "Message in a Bottle" and
		the band's first #1 hit in the U.K. "Walking on the Moon."  In 1980, the band released their breakthrough U.S. album Zenyatta Mondatta, 
		which spawned two Top 10 U.S. Billboard Hits "Don't Stand So Close To Me" and "De Do Do Do De Da Da Da."  The band's fourth album "Ghost In the Machine"
		resulted in the hit "Every Little Thing She Does Is Magic", which charted at #3 on the U.S. Billboard.  The band experienced considerable tension
		in the months leading up to their fifth and final album "Synchronicity," released in 1983.  It was the band's most successful album, and sales
		reached eight-time Platinum status in the U.S.  The album spawned the Top 10 hits "Every Breath You Take" (#1 in the US and UK),
		"King of Pain" (#3 in the US), and "Wrapped Around Your Finger"(#8 in the US).  Following the band's successful world tour, which
		consisted of sold-out crowds in stadiums worldwide, the band began to embark on a sixth album project which was ultimately scrapped.
		The band managed to released one final single ("Don't Stand So Close to Me '86") before disbanding.  The Police did reunite for a successful 
		world tour in 2007.
		
			
		
		</p>
	</div>

</body>
</html>