<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solo Project</title>
    <link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet" id="bootstrap-css"/>

</head>
<body>
<form method="post">
    <div class="container">

        <form class="form-signin">
            <div class="noclass">
                <h1 class="form-signin-heading text-muted">Please sign In</h1>
                <input type="text" name="name" class="form-control" placeholder="Name" required="" autofocus="">
                <input type="password" name="password" class="form-control" placeholder="Password" required="">
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign In
                </button>
            </div>
        </form>

    </div>
</form>
<script src="<c:url value="/resources/jquery.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap.js" />"></script>
</body>
</html>
