<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Edycja zajęć</h1>
        <%--        <a href="/reservation/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i--%>
        <a href="/reservation/add" class="d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i>Dodaj zajęcia do grafiku</a>
    </div>
    <form:form method="post" modelAttribute="reservation" action="/reservation/update">
        <form:input type="hidden" path="id"/>
        <label style="display: inline-block; vertical-align: top">
            Dzień tygodnia<br/>
            <form:select path="day" items="${days}"/>
        </label>
        &nbsp;&nbsp;
        <label style="display: inline-block; vertical-align: top">
            Godzina <br/>
            <form:select path="hour" items="${hours}"/>
        </label>
        &nbsp;&nbsp;&nbsp;
        <label style="display: inline-block; vertical-align: top">
            Zajęcia<br/>
            <form:select path="groupActivity.id" items="${activities}" itemValue="id" itemLabel="name"/>
        </label>
        &nbsp;&nbsp;&nbsp;
        <label style="display: inline-block; vertical-align: top">
            Trener<br/>
            <form:select path="persons" items="${trainers}" itemLabel="name"/>
        </label>
        <br/><br/><br/>
        <button class="d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit">Zapisz</button>
        <br/>
    </form:form>
    ${error}

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>

