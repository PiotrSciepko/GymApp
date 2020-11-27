<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Lista użytkowników</h1>
        <a href="/person/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
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

        <c:forEach items="${persons}" var="person">
            <tr style="background-color: white">
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.email}</td>
                <td>${person.role}</td>
                <td>

                    <a href="<c:url value="/person/show/${person.id}"/>">pokaż &nbsp</a>
<%--                    <form action="/person/show"--%>
<%--                          method="post" style="display:inline; font-size: 10px;">--%>
<%--                        <input type="hidden" name="personId" value="${person.id}">--%>
<%--                        <button type="submit" style="background-color: lightgreen; border:none">Pokaż</button>--%>
<%--                    </form>--%>
                    <a href="<c:url value="/person/update/${person.id}"/>">edytuj &nbsp</a>
<%--                    <form action="/person/update"--%>
<%--                          method="get" style="display:inline; font-size: 10px;">--%>
<%--                        <input type="hidden" name="personId" value="${person.id}">--%>
<%--                        <button type="submit" style="background-color: gold; border:none">Edytuj</button>--%>
<%--                    </form>--%>
                    <a href="<c:url value="/person/delete/${person.id}"/>">usuń</a>
<%--                    <form action="/person/delete"--%>
<%--                    method="post" style="display:inline; font-size: 10px;">--%>
<%--                    <input type="hidden" name="personId" value="${person.id}">--%>
<%--                    <button type="submit" style="background-color: lightcoral; border:none">Usuń</button>--%>
<%--                    </form>--%>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
