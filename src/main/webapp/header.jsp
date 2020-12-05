<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Piotr Ściepko">

    <title>Gym App</title>

    <!-- Custom fonts for this template-->
    <%--  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">--%>
    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css" />" rel="stylesheet" type="text/css">
    <%--  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">--%>
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"/>"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">

</head>
<body style="max-width:1300px; min-width:575px; margin: 0 auto;
background-image: url('/img/gym1.jpg'); background-attachment: fixed;
        /*url('http://www.bialystokonline.pl/gfx_prezentacje/kat/11215/6806_11215.jpg'); background-attachment: fixed;*/
         background-size: cover; background-repeat: no-repeat">
<%--; background:#3a3b45--%>
<!-- Page Wrapper -->
<div id="wrapper" style="margin: 0 auto;">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/reservation/list">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Gym App</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="/reservation/list">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Grafik zajęć</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Nav Item - Users -->
        <li class="nav-item active">
            <a class="nav-link" href="/person/list">
                <%--                <i class="fas fa-fw fa-tachometer-alt"></i>--%>
                <span>Użytkownicy</span></a>
        </li>

        <%--        <!-- Divider -->--%>
        <%--        <hr class="sidebar-divider d-none d-md-block">--%>

        <!-- Nav Item - Activities -->
        <li class="nav-item active">
            <a class="nav-link" href="/activity/list">
                <%--                <i class="fas fa-fw fa-tachometer-alt"></i>--%>
                <span>Zajęcia</span></a>
        </li>
        <br/> <br/>
        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">
        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <p class="nav-link collapsed" style="padding-bottom:0; padding-top: 0">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Ustawienia:</span>
            </p>
        </li>

        <!-- Nav Item - Categories -->
        <li class="nav-item active">
            <a class="nav-link" href="/category/list">
                <%--                <i class="fas fa-fw fa-tachometer-alt"></i>--%>
                <span>Kategoria zajęć</span></a>
        </li>

        <li class="nav-item active">
            <a class="nav-link" href="/level/list">
                <%--                <i class="fas fa-fw fa-tachometer-alt"></i>--%>
                <span>Poziom zajęć</span></a>
        </li>

    </ul>
    <!-- End of Sidebar -->

    <!--  Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <%--            <!-- Topbar -->--%>
            <%--            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">--%>

            <%--                <!-- Sidebar Toggle (Topbar) -->--%>
            <%--                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">--%>
            <%--                    <i class="fa fa-bars"></i>--%>
            <%--                </button>--%>

            <%--            </nav>--%>
            <!-- End of Topbar -->
