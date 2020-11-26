<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Lista użytkowników</h1>
        <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <th>Id</th>
            <th>Nazwa użytkownika</th>
            <th>Email</th>
            <th>Rola</th>
            <th>Akcja</th>
        </tr>

        <c:forEach items="${users}" var="user">
            <c:set var="userID" value="${user.getId()}"/>
            <c:set var="userName" value="${user.getUsername()}"/>
            <c:set var="userEmail" value="${user.getEmail()}"/>
            <tr style="background-color: white">
                <td>${userID}</td>
                <td>${userName}</td>
                <td>${userEmail}</td>
                <td>
                    <form action="/user/show"
                          method="post" style="display:inline; font-size: 10px;">
                        <input type="hidden" name="id" value="${userID}">
                        <input type="hidden" name="username" value="${userName}">
                        <input type="hidden" name="email" value="${userEmail}">
                        <button type="submit" style="background-color: lightgreen; border:none">Pokaż</button>
                    </form>
                    <form action="/users/edit.jsp"
                          method="post" style="display:inline; font-size: 10px;">
                        <input type="hidden" name="id" value="${userID}">
                        <input type="hidden" name="username" value="${userName}">
                        <input type="hidden" name="email" value="${userEmail}">
                        <button type="submit" style="background-color: gold; border:none">Edytuj</button>
                    </form>
                    <form action="/user/delete"
                          method="post" style="display:inline; font-size: 10px;">
                        <input type="hidden" name="id" value="${userID}">
                        <button type="submit" style="background-color: lightcoral; border:none">Usuń</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
