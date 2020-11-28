<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Edycja użytkownika</h1>
        <a href="/activity/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Dodaj</a>
    </div>
    <table class="table">
        <tr style="background-color: white">
            <td>
                <form:form method="post" modelAttribute="activity" action="/activity/update">
                    <form:input type="hidden" path="id"/>
                    Nazwa <br/>
                    <form:input style="width:100%;" path="name"/>
                    <br/> <br/>

                    Kategoria <br/>
                    <select name="categoryName">
                        <option>
                                ${activity.category.name}
                        </option>
                        <c:forEach var="category" items="${categories}">
                            <option>
                                    ${category.name}
                            </option>
                        </c:forEach>
                    </select>
                    <br/> <br/>

                    Poziom <br/>
                    <select name="levelName">
                        <option>
                                ${activity.level.name}
                        </option>
                        <c:forEach var="level" items="${levels}">
                            <option>
                                    ${level.name}
                            </option>
                        </c:forEach>
                    </select>


                    <br/> <br/> <br/>
                    <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit">Zapisz
                    </button>
                </form:form>
            </td>
        </tr>
    </table>

</div>
<!-- /.container-fluid -->

<%@ include file="/footer.jsp" %>

