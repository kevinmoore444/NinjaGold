<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>   
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>

</head>
<body>

	<!-- Display activities in Red font if the activity contains the word lost, or Green front if it contains Green -->
	<c:forEach var="activity" items= "${activities}">
		<c:if test="${activity.contains('earned')}">
			<p style="color: green; font-size: 10px"><c:out value="${activity}"/></p>
		</c:if>
		<c:if test="${activity.contains('lost')}">
			<p style="color: red; font-size: 10px"><c:out value="${activity}"/></p>
		</c:if>
	</c:forEach>
</body>
</html>