<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Poziom zajęć</h1>
<%--        <a href="/level/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i--%>
        <a href="/level/add" class="d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i>Dodaj poziom zajęć</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <th>Id</th>
            <th>Nazwa</th>
            <th>Akcja</th>
        </tr>

        <c:forEach items="${levels}" var="level">
            <tr style="background-color: white">
                <td>${level.id}</td>
                <td>${level.name}</td>
                <td>
                    <a href="<c:url value="/level/show/${level.id}"/>">pokaż</a> &nbsp
                    <a href="<c:url value="/level/update/${level.id}"/>">edytuj</a> &nbsp
                    <a href="<c:url value="/level/delete/${level.id}"/>">usuń</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
