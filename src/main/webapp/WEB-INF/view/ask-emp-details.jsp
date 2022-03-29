<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fomr" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ask</title>
</head>
<body>

<h2>Please enter your details</h2>

<br>
<br>

<form:form action="/showDetails" modelAttribute="employee">

    Name: <form:input path="name"/>
    <fomr:errors path="name"/>
    <br><br>
    Surname: <form:input path="surname"/>
    <fomr:errors path="surname"/>
    <br><br>
    Salary: <form:input path="salary"/>
    <fomr:errors path="salary"/>
    <br><br>
    Department: <form:select path="department">
    <form:options items="${employee.departmentMap}"/>
</form:select>
    <br><br>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${employee.carBrandMap}"/>
    <br><br>
    Foreign Language(s)
    <form:checkboxes path="languages" items="${employee.languageMap}"/>
    <br><br>
    Phone number: <form:input path="phoneNumber"/>
    <fomr:errors path="phoneNumber"/>
    <br><br>
    Email: <form:input path="email"/>
    <fomr:errors path="email"/>
    <br><br>

    <input type="submit" value="OK">

</form:form>

</body>
</html>
