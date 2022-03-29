<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
</head>
<body>

<%--Your name: ${param.employeeName}--%>

Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Your department: ${employee.department}
<br>
Your car: ${employee.carBrand}
<br>
Your language(s):
<ul>
    <c:forEach var="lang" items="${employee.languages}">
        <li>${lang}</li>
    </c:forEach>
</ul>
<br>
Phone number: ${employee.phoneNumber}
<br>
Email: ${employee.email}

</body>
</html>
