<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="URLChange" value="/v1/web/registers"></c:url>
<c:url var="URLNews" value="/v1/web/news/"></c:url>

<html>
<head>

</head>
<body>
<div style="margin-top: 20px;">

    <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
                <img style="width: 100%; height: 400px;" class="d-block img-fluid" src="/pictures/1581042372057.jpg" alt="Second slide">

            </div>
            <div class="carousel-item">
                <img style="width: 100%; height: 400px;"  class="d-block img-fluid" src="/pictures/662f95e27fa396fdcfb2.jpg" alt="First slide">

            </div>
            <div class="carousel-item">
                <img style="width: 100%; height: 400px;" class="d-block img-fluid" src="/pictures/t76892.jpg" alt="Third slide">
            </div>
        </div>

        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <div class="row">

        <div class="col-lg-3">
            <div>
                <img style="width: 300px; height: 500px;" class="d-block img-fluid" src="/pictures/web-home.jpg" alt="Second slide">
            </div>
            <a href="${URLChange}">
                <button style=" margin-top:20px;  width:250px  ; height: 60px; text-align: center; font-size: 18px"
                        type="button" class="btn btn-success">
                    Register now
                </button>
            </a>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
            ${obj.noiDung}
        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->
</div>
<br>
<br>
<br>
</body>
</html>
