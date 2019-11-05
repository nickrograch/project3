<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap.css" />"/>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="leftBarUser.jsp" %>

<div class="container-user">
    <h1>User page</h1>
    <br>
    <c:out value="Hello: ${user.name}"/>
</div>
<h2><a href="/userlist">UserList</a></h2>
</body>
</html>
