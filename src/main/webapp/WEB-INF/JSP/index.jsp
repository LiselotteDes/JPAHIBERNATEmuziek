<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="nl">
<head>
	<title>Muziek</title>
	<link rel="stylesheet" href="<c:url value='/css/muziek.css'/>"/>
</head>
<body>
	<h1>Albums</h1>
	<c:if test="${not empty albums}">
		<ul>
		<c:forEach var="album" items="${albums}">
			<spring:url value="/albums/{id}" var="url"><spring:param name="id" value="${album.id}"/></spring:url>
			<li><a href="${url}">${album.naam}</a> (${album.artiest.naam})</li>
		</c:forEach>
		</ul>
	</c:if>
</body>
</html>