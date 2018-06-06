<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Book</title>
</head>
<body>
Welcome Page

    <c:forEach items="${customerList}" var="x">
        <span>
            ${x.name} -- <spring:eval expression="x.address" />
        </span>
        <br/>
    </c:forEach>

</body>
</html>