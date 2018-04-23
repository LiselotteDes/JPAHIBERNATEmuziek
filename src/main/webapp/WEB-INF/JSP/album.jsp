<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
<head>
	<title>${album.naam}</title>
	<link rel="stylesheet" href="<c:url value='/css/muziek.css'/>"/>
</head>
<body>
	<h1>${album.naam}</h1>
	<h2>${album.artiest.naam}</h2>
	<c:if test="${not empty album.tracks}">
		<ul>
		<c:forEach var="track" items="${album.tracks}">
			<li>${track.naam} (${track.tijd})</li>
		</c:forEach>
		</ul>
	</c:if>
	Totale tijd: ${album.totaleTijd}
</body>
</html>