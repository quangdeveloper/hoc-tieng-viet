<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <sitemesh:write property="title" />
    <title>Trang chủ</title>
    <link rel="icon" type="image/png" href="<c:url value='/template/login/images/icons/favicon.ico'/>"/>

    <link href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<c:url value='/template/web/shop-homepage.css' />" type="text/css" rel="stylesheet">
</head>
<body>

    <%@include file="/common/web/header.jsp"%>

    <div  class="container">
        <sitemesh:write property="body" />
    </div>
    <%@include file="/common/web/footer.jsp"%>
    <script src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>
