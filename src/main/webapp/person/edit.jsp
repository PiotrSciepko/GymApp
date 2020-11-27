<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Edycja użytkownika</h1>
        <a href="/person/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <td>
                <form:form method="post" modelAttribute="person" action="/person/update">
                    <form:input type="hidden" path="id"/>
                    <label style="width:100%; padding-bottom: 15px;" >
                        Nazwa <br />
                        <form:input style="width:100%;" path="name"/>
                    </label><br />
                    <label style="width:100%;padding-bottom: 15px;">
                        Email <br />
                        <form:input style="width: 100%;" path="email"/>
                    </label><br />
                    <label style="width:100%;padding-bottom: 15px;">
                        Hasło <br />
                        <form:input style="width: 100%;" path="password"/>
                    </label><br />
                    <label style="width:100%;padding-bottom: 15px;">
                        Rola <br />
                        <form:select path="role">
                            <option>admin</option>
                            <option>user</option>
                            <option>trainer</option>
                        </form:select>
                    </label><br />
                    <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit">Zapisz</button>
                </form:form>
            </td>
        </tr>
    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>

