<%@include file="/common/taglib.jsp" %>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="URL" value="/v1/admin/courses?pageNo=1&pageSize=10"></c:url>


<html>
<head>
    <title></title>
</head>
<body>

<div>

    ${obj.noiDung}
    <form id="formSearch" action="${URL}" method="GET">
        <button id="btnSearch" style="margin-top: 3px; width:200px; margin-left: 5px; height: 40px;"
                type="submit" class="btn btn-success"><i class="fa fa-search"
                                                         aria-hidden="true"></i>&nbsp
            Xem danh sách
        </button>
    </form>
</div>
</body>
</html>
