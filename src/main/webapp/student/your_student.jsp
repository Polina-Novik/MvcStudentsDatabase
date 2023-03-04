<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1>Student by id: <h1/>
        <br>
        <c:out value="id : ${student.id}, name: ${student.description}, course id: ${student.courseId}" />

</body>
</html>
