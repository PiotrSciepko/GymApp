<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Dodaj użytkownika</h1>
        <a href="/person/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
    </div>
    <table class="table">
            <tr style="background-color: white">
                <td>
                    <form action="/person/add" method="post">
                        <label style="width:100%; padding-bottom: 15px;" >
                            Nazwa <br />
                            <input style="width:100%;" type="text" name="personName" placeholder="Nazwa użytkownika">
                        </label><br />
                        <label style="width:100%;padding-bottom: 15px;">
                            Email <br />
                            <input style="width: 100%;" type="text" name="personEmail" placeholder="Email użytkownika">
                        </label><br />
                        <label style="width:100%;padding-bottom: 15px;">
                            Hasło <br />
                            <input style="width: 100%;" type="text" name="personPassword" placeholder="Hasło użytkownika">
                        </label><br />
                        <label style="width:100%;padding-bottom: 15px;">
                            Rola <br />
                            <select name="personRole">
                                <option>admin</option>
                                <option>user</option>
                                <option>trainer</option>
                            </select>
<%--                            <input style="width: 100%;" type="text" name="personRole" placeholder="Rola">--%>
                        </label><br />
                        <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit">Zapisz</button>
                    </form>
                </td>
            </tr>
    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
