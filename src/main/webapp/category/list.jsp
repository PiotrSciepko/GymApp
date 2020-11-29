<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Zajęcia</h1>
        <a href="/category/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj kategorię</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <th>Id</th>
            <th>Nazwa</th>
            <th>Akcja</th>
        </tr>

        <c:forEach items="${categories}" var="category">
            <tr style="background-color: white">
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>
                    <a href="<c:url value="/category/show/${category.id}"/>">pokaż &nbsp</a>
                    <a href="<c:url value="/category/update/${category.id}"/>">edytuj &nbsp</a>
                    <a href="<c:url value="/category/delete/${category.id}"/>">usuń</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
