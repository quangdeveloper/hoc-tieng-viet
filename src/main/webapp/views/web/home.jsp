<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="URLChange" value="/v1/web/registers"></c:url>
<c:url var="URLNews" value="/v1/web/news"></c:url>

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
                <img style="width: 300px; height: 600px;" class="d-block img-fluid" src="/pictures/web-home.jpg" alt="Second slide">
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

            <div class="row" >
                <c:forEach items="${news}" var="item">
                <div class="col-lg-4 col-md-6 mb-4" id ="course">
                    <div class="card h-100">
                        <a href="${URLNews}/${item.ID}"><img class="card-img-top" src="/pictures/${item.anhMoTa}" alt="Error"></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="${URLNews}/${item.ID}">${item.tieuDe}</a>
                            </h4>
                        </div>
                        <div class="card-footer">
                            <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                        </div>
                    </div>
                </div>
                </c:forEach>

            </div>
            <!-- /.row -->

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
