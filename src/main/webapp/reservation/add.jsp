<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Dodaj zajęcia do grafiku</h1>
        <a href="/reservation/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i>Dodaj zajęcia do grafiku</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <td>
                <form:form method="post" modelAttribute="reservation">
                    <table>
                        <tr>
                            <td style="border: none">Dzień tygodnia<br/>
                                <form:select path="day" items="${days}"/>
                            </td>
                            <td style="border: none">
                                Godzina <br/>
                                <form:select path="hour" items="${hours}"/>
                            </td>
                            <td style="border: none">
                                Zajęcia <br/>
                                <form:select path="groupActivity.id" items="${activities}" itemValue="id"
                                             itemLabel="name"/>
                            </td>
                            <td style="border: none">
                                Trener <br/>
                                <form:select path="persons" items="${trainers}" itemLabel="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="border: none">
                                <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit">
                                    Zapisz
                                </button>
                            </td>
                        </tr>
                    </table>
                    <br/>
                </form:form>
            </td>
        </tr>
    </table>
    ${error}

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>
