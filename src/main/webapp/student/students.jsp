<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1>List of students: <h1/>

    <c:forEach var="student" items="${students}">
    <div><c:out value="id : ${student.id}, name: ${student.description}, course id: ${student.courseId}"/>
    </div>
    </c:forEach>
        <br>
        <c:out value="this page was visited ${count} times" />

</body>
</html>
