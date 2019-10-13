<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="Hello: ${user.name}"/>

<h2><a href="/userlist">UserList</a></h2>
</body>
</html>
