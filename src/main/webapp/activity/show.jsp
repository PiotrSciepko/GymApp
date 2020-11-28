<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Szczegóły użytkownika</h1>
        <a href="/activity/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <td>Id</td>
            <td>${activity.id}</td>
        </tr>
        <tr style="background-color: white">
            <td>Nazwa użytkownika</td>
            <td>${activity.name}</td>
        </tr>
        <tr style="background-color: white">
            <td>Email</td>
            <td>${activity.category.name}</td>
        </tr>

        <tr style="background-color: white">
            <td>Role</td>
            <td>${activity.level.name}</td>
        </tr>

    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
