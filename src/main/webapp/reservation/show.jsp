<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Szczegóły zajęć</h1>
<%--        <a href="/reservation/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i--%>
        <a href="/reservation/add" class="d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i>Dodaj zajęcia do grafiku</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <td>Id</td>
            <td>${reservation.id}</td>
        </tr>
        <tr style="background-color: white">
            <td>Dzień</td>
            <td>${reservation.day}</td>
        </tr>
        <tr style="background-color: white">
            <td>Godzina</td>
            <td>${reservation.hour}:00</td>
        </tr>
        <tr style="background-color: white">
            <td>Zajęcia</td>
            <td>${reservation.groupActivity.name}</td>
        </tr>

        <tr style="background-color: white">
            <td>Trenerzy</td>
            <td>
                <c:forEach items="${reservation.reservationTrainers}" var="trainer">
                    ${trainer}<br/>
                </c:forEach>
            </td>
        </tr>

    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
