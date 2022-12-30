<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1>Hello,
    <c:forEach var="student" items="${students}">
    <div><c:out value="${student.id}, ${student.description} $, ${student.courseId}"/>
    </div>
    </c:forEach>
</body>
</html>
