<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:url var="APIurl" value="/v1/api/admin/pictures/add"/>
<c:url var="NewURL" value="/v1/admin/pictures?pageNo=1&pageSize=10"/>
<html>
<head>
    <title></title>

    <style type="text/css">
        .containnner {

        }

        .form-control {
            width: 250px;
        }

    </style>
</head>
<body>
<div>
    <div class="containnner" style=" margin-left: 50px;
            margin-top: 30px;">
        <div class="dropdown-divider"></div>

        <form:form action="${APIurl}" modelAttribute="picture" method="POST" enctype="multipart/form-data">

            <label> Mô Tả ngắn:</label><br>
            <input type="text" style="width: 250px" class="form-control" name="description"><br>

            <label>Ảnh đăng tải</label>
            <div style="width: 250px; height: 190px;">
                <img style="width: 250px; height: 190px;" class="card-img-top" id="demo">
            </div>

            <input type="file" id="multipartFile" name="multipartFile" onchange="myfunction()"/>

            <br>

            <button style="margin-left: 50px; margin-top: 15px;" type="submit" class="btn btn-primary">Thêm mới</button>

            <button style="margin-top: 15px;" type="reset" class="btn btn-secondary"  onclick="reset()">Hủy bỏ</button>

        </form:form>
    </div>
</div>

<script>
    function myfunction() {

        var reader = new FileReader();
        console.log($('#multipartFile')[0].files[0]);
        document.images['demo'].src = reader.readAsDataURL($('#multipartFile')[0].files[0]);
        console.log(reader.readAsDataURL($('#multipartFile')[0].files[0]));
    }

    function reset() {
        location.reload();
    }

</script>
</body>
</html>
