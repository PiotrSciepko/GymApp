<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Zajęcia</h1>
        <a href="/activity/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <th>Id</th>
            <th>Nazwa</th>
            <th>Kategoria</th>
            <th>Poziom</th>
            <th>Akcja</th>
        </tr>

        <c:forEach items="${activities}" var="activity">
            <tr style="background-color: white">
                <td>${activity.id}</td>
                <td>${activity.name}</td>
                <td>${activity.category.name}</td>
                <td>${activity.level.name}</td>
                <td>
                    <form action="/person/show"
                          method="post" style="display:inline; font-size: 10px;">
                        <input type="hidden" name="personId" value="${personId}">
                        <input type="hidden" name="personName" value="${personName}">
                        <input type="hidden" name="personEmail" value="${personEmail}">
                        <input type="hidden" name="personRole" value="${personRole}">
                        <button type="submit" style="background-color: lightgreen; border:none">Pokaż</button>
                    </form>
                    <form action="/person/edit.jsp"
                          method="post" style="display:inline; font-size: 10px;">
                        <input type="hidden" name="personId" value="${personId}">
                        <input type="hidden" name="personName" value="${personName}">
                        <input type="hidden" name="personEmail" value="${personEmail}">
                        <button type="submit" style="background-color: gold; border:none">Edytuj</button>
                    </form>
                    <form action="/person/delete"
                          method="post" style="display:inline; font-size: 10px;">
                        <input type="hidden" name="personId" value="${personId}">
                        <button type="submit" style="background-color: lightcoral; border:none">Usuń</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
