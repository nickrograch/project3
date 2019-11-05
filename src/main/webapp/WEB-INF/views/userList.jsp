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
    <%--<form:form method="post">--%>
    <%--    <p><b>Выберите действие c пользователем</b></p>--%>
    <%--    <p><input type="submit" value="Добавить" name="add" formaction="/add">--%>
    <%--    <input type="submit" value="Изменить" name="edit" formaction="/edit"></p>--%>

    <%--    <table width='100%' cellspacing='0' cellpadding='4' items="${requestScope.userEdit}" var="userEdit">--%>
    <%--        <tr>--%>
    <%--            <td align='right' width='100'>Имя</td>--%>
    <%--            <td><input type='text' name='name' maxlength='50' size='20' value= ${userEdit.name}></td>--%>
    <%--        </tr>--%>
    <%--        <tr>--%>
    <%--            <td align='right'>Пароль</td>--%>
    <%--            <td><input type='text' name="password" maxlength='50' size='20' value=${userEdit.password}></td>--%>
    <%--        </tr>--%>
    <%--    </table>--%>
    <%--    <input type="hidden" name="id" value="${userEdit.id}">--%>
    <%--</form:form>--%>
    <div class="container-header-admin-panel">
        <div class="shadow-lg container-white container-header-admin-panel-tab">
            <a href="/userlist"><h4 class="text-black-50">Users table</h4></a>
        </div>
        <div class="container-custom container-header-admin-panel-tab">
            <a href="/add"><h4 class="text-blue">New User</h4></a>
        </div>
    </div>
    <div class="shadow-lg container-my">
        <h4 class="text-black-50">All Users</h4>
    </div>
    <div class="container-white">
        <table class="table table-striped container-white">
            <tr>
                <th>Id</th>
                <th>Role</th>
                <th>Login</th>
                <th>Password</th>
                <th>Email</th>
                <th>Действие</th>
            </tr>
            <c:forEach items="${requestScope.users}" var="appUser" varStatus="vs">

                <tr>
                    <td> ${appUser.id} </td>
                    <td> ${appUser.roles.toString()} </td>
                    <td> ${appUser.name} </td>
                    <td> ${appUser.password} </td>
                    <td> ${appUser.email} </td>
                    <td>

                        <button type="button" class="btn btn-primary active btn-custom"
                                data-toggle="modal" data-target="#myModal${vs.index}" data-whatever="${appUser}"
                                aria-pressed="true" name="edit">Edit
                        </button>
                        <form method="post" action="/edit">
                            <div class="modal fade" id="myModal${vs.index}" tabindex="-1" role="dialog"
                                 aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="modal-title" style="text-align: left" id="myModalLabel">Edit
                                                user ${appUser.name}</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="container-add">
                                                <h4 class="text-black-50" style="text-align: center">ID</h4>
                                                <input type="number" name="id" class="form-control"
                                                       value="${appUser.id}" style="width: 400px" disabled>
                                                <h4 class="text-black-50" style="text-align: center">Email</h4>
                                                <input type="email" name="email" class="form-control"
                                                       value="${appUser.email}">
                                                <h4 class="text-black-50" style="text-align: center">Login</h4>
                                                <input type="text" name="name" class="form-control"
                                                       value="${appUser.name}">
                                                <h4 class="text-black-50" style="text-align: center">Password</h4>
                                                <input type="password" name="password" class="form-control"
                                                       value="${appUser.password}">
                                                <h4 class="text-black-50" style="text-align: center">Role</h4>
                                                <input type="text" name="role" class="form-control"
                                                       value="${appUser.roles.toString()}">
                                                <input type="hidden" name="id" value="${appUser.id}">
                                            </div>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary">Close
                                                </button>
                                                <button type="submit" class="btn btn-primary">Edit user</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <form method="post" action="/delete">
                            <input type="submit" class="btn btn-primary active btn-custom" value="Удалить"
                                   role="button" aria-pressed="true" name="delete">
                            <input type="hidden" name="id" value="${appUser.id}">
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</div>

<script src="<c:url value="/resources/jquery.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap.js" />"></script>
</body>

</html>
