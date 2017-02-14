<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
</head>
<body>
	<p align="center"><b>hello ${user} this is example spring security app</b><p>
    <br/><br/>
    <!-- This part is visible for everyone -->
    <div>
        <p align="center">THIS MESSAGE IS VISIBLE FOR ALL USERS</p>
    </div>
    
    
    <!-- This part is visible for admins -->
    <div>
        <sec:authorize access="hasRole('ADMIN')">
            <p align="center"> THIS MESSAGE IS VISIBLE JUST FOR ADMINS </p>
        </sec:authorize>
    </div>
    <br/>
    <p align="center"><a href="<c:url value="/logout" />">Logout</a></p>   
    <br/>
</html>