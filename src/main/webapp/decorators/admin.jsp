<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <sitemesh:write property="title" />
    <title>Quản trị viên</title>
    <link rel="icon" type="image/png" href="<c:url value='/template/login/images/icons/favicon.ico'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/admin/bootstrap/css/bootstrap.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/admin/bootstrap/css/bootstrap.min.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/template/admin/simple-sidebar.css'/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/template/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css'/>">
    <style>
        body {
            overflow-x: hidden;
        }

        #sidebar-wrapper {
            min-height: 100vh;
            margin-left: -15rem;
            -webkit-transition: margin .25s ease-out;
            -moz-transition: margin .25s ease-out;
            -o-transition: margin .25s ease-out;
            transition: margin .25s ease-out;
        }

        #sidebar-wrapper .sidebar-heading {
            padding: 0.875rem 1.25rem;
            font-size: 1.2rem;
        }

        #sidebar-wrapper .list-group {
            width: 15rem;
        }

        #page-content-wrapper {
            min-width: 100vw;
        }

        #wrapper.toggled #sidebar-wrapper {
            margin-left: 0;
        }

        @media (min-width: 768px) {
            #sidebar-wrapper {
                margin-left: 0;
            }

            #page-content-wrapper {
                min-width: 0;
                width: 100%;
            }

            #wrapper.toggled #sidebar-wrapper {
                margin-left: -15rem;
            }
        }
    </style>
</head>
<body>
<div class="d-flex" id="wrapper">
    <%@include file="/common/admin/menu.jsp" %>
    <div id="page-content-wrapper">
        <%@include file="/common/admin/header.jsp" %>
        <div class="container-fluid">
            <sitemesh:write property="body" />
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript -->
<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>
<script src="<c:url value='/template/admin/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
<script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
<script src="<c:url value='/template/paging/jquery.twbsPagination.min.js'/>"></script>
<script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
<script src="<c:url value='/views/function.js' />"></script>
<!-- Menu Toggle Script -->

<script>
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
</body>
</html>
