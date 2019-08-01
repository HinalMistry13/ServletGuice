<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="students" value="${studentList}" />
	<table border="1">
		<c:choose>
			<c:when test="${fn:length(students) gt 0}">
				<c:forEach items="${studentList}" var="student">
					<tr>
						<td>${student.rollNo}</td>
						<td>${student.name}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="2">NO Data found!!!</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>