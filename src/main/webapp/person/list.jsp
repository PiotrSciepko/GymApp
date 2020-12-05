<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4" style="min-width: 600px">
        <h1 class="h3 mb-0 text-gray-800">Lista użytkowników</h1>
        <a href="/person/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><em
                class="fas fa-download fa-sm text-white-50"></em> Dodaj użytkownika</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <th scope="col">Id</th>
            <th scope="col">Nazwa użytkownika</th>
            <th scope="col">Email</th>
            <th scope="col">Rola</th>
            <th scope="col">Akcja</th>
        </tr>

        <c:forEach items="${persons}" var="person">
            <tr style="background-color: white">
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.email}</td>
                <td>${person.role}</td>
                <td>
                    <a href="<c:url value="/person/show/${person.id}"/>">pokaż</a> &nbsp
                    <a href="<c:url value="/person/update/${person.id}"/>">edytuj</a> &nbsp
                    <a href="<c:url value="/person/delete/${person.id}"/>">usuń</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
