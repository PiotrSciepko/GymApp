<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Grafik zajęć</h1>
        <a href="/reservation/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i>Dodaj zajęcia do grafiku</a>
    </div>
    <table class="table">
        <c:forEach items="${days}" var="day">
            <tr>
                <th style="border: none">${day}</th>
            </tr>
            <c:forEach items="${hours}" var="hour">
                <c:forEach items="${reservations}" var="reservation">
                    <c:if test="${reservation.day == day and reservation.hour == hour}">
                        <tr style="background-color: white">
                            <td style="text-align: right; padding-right: 40px; width:60px">${reservation.hour}:00</td>
                            <td>${reservation.groupActivity.name}</td>
                            <td>
                                <c:forEach items="${reservation.reservationTrainers}" var="trainer">
                                    ${trainer}<br/>
                                </c:forEach>
                            </td>
                            <td>
                                <a href="<c:url value="/reservation/show/${reservation.id}"/>">pokaż</a> &nbsp
                                <a href="<c:url value="/reservation/update/${reservation.id}"/>">edytuj</a> &nbsp
                                <a href="<c:url value="/reservation/delete/${reservation.id}"/>">usuń</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </c:forEach>


    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
