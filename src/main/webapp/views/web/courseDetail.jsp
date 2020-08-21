<%@include file="/common/taglib.jsp" %>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="URLChange" value="/v1/web/registers"></c:url>

<html>
<head>
    <title></title>
</head>
<body>
<div>
    ${obj.noiDung}<br><br>
    <div>
        <a href="${URLChange}">
            <button style=" margin-left:370px; margin-top:20px;  width:300px  ; height: 80px; text-align: center; font-size: 20px"
                    type="button" class="btn btn-primary">
                Register now
            </button>
        </a>
    </div><br><br>
</div>
</body>
</html>
