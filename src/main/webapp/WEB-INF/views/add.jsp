<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap.css" />"/>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="leftBarAdmin.jsp" %>
<div class="container-userList">
    <h1>Admin panel</h1><br/>
    <div class="container-header-admin-panel">
        <div class="container-custom container-header-admin-panel-tab">
            <a href="/userlist"><h4 class="text-blue">Users table</h4></a>
        </div>
        <div class="shadow-lg container-white container-header-admin-panel-tab">
            <a href="/add"><h4 class="text-black-50">New User</h4></a>
        </div>
    </div>
    <div class="shadow-lg container-my">
        <h4 class="text-black-50">Add new user</h4>
    </div>
    <div class="container-white">
        <form method="post">
            <div class="container-add">
                <h4 class="text-black-50">Email</h4>
                <input type="email" name="email" class="form-control" placeholder="Email" style="width: 400px"
                       required="">
                <h4 class="text-black-50">Login</h4>
                <input type="text" name="name" class="form-control" placeholder="Login" required="">
                <h4 class="text-black-50">Password</h4>
                <input type="password" name="password" class="form-control" placeholder="Password" required="">
                <h4 class="text-black-50">Role</h4>
                <input type="text" name="role" class="form-control" placeholder="Role" required="">
                <button class="btn btn-lg btn-success btn-block" type="submit" style="width: 200px">Add new user
                </button>
            </div>
        </form>
    </div>
</div>
<script src="<c:url value="/resources/jquery.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap.js" />"></script>
</body>
</html>
