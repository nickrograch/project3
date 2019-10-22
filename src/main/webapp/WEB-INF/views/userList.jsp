<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>БД пользователей</h1><br/>
<form:form method="post">
    <p><b>Выберите действие c пользователем</b></p>
    <p><input type="submit" value="Добавить" name="add" formaction="/add">
    <input type="submit" value="Изменить" name="edit" formaction="/edit"></p>

    <table width='100%' cellspacing='0' cellpadding='4' items="${requestScope.userEdit}" var="userEdit">
        <tr>
            <td align='right' width='100'>Имя</td>
            <td><input type='text' name='name' maxlength='50' size='20' value= ${userEdit.name}></td>
        </tr>
        <tr>
            <td align='right'>Пароль</td>
            <td><input type='text' name="password" maxlength='50' size='20' value=${userEdit.password}></td>
        </tr>
    </table>
    <input type="hidden" name="id" value="${userEdit.id}">
</form:form>


<table table border="1" cellspacing="0" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Пароль</th>
        <th>Роль</th>
    </tr>
    <c:forEach items="${requestScope.users}" var="appUser">

            <tr>
                <td> ${appUser.id} </td>
                <td> ${appUser.name} </td>
                <td> ${appUser.password} </td>
                <td> ${appUser.roles.toString()} </td>
                <td>
                    <form method="get">
                        <input type="submit" value="Изменить" name="edit">
                        <input type="hidden" name="id" value="${appUser.id}">
                    </form>
                    <form method="post" action="/delete">
                        <input type="submit" value="Удалить" name="delete">
                        <input type="hidden" name="id" value="${appUser.id}">
                    </form>
                </td>
            </tr>

    </c:forEach>
</table>


</body>

</html>
