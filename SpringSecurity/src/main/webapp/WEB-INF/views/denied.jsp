<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>access denied</title>
</head>

<body>
    Ups ${user} you can't visit this page because you're not admin
    <br/><br/>
    <a href="<c:url value="/home" />">Back to previous page</a>
</body>
</html>