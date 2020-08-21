<%@include file="/common/taglib.jsp" %>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="URL" value="/v1/web/courses?pageNo=1&pageSize=10"></c:url>
<c:url var="URLChange" value="/v1/web/courses"></c:url>
<c:url var="URLSearch" value="/v1/web/courses/search"></c:url>
<c:url var="URLPagination" value="/v1/web/courses"></c:url>

<html>
<head>
    <title></title>
</head>
<body>

<div>
    <form id="formSearch" action="${URLSearch}" method="GET">
        <input type="hidden" name="pageNo" value="1"/>
        <input type="hidden" name="pageSize" value="10"/>
        <div style="margin-top: 5px; margin-bottom: 7px;">
            <table>
                <tr>
                    <td style="width: 75%">
                        <div>
                            <table>

                                <tr>
                                    <td><input style="width: 500px;
                                            box-sizing: border-box;
                                            border: 2px solid #ccc;
                                            border-radius: 4px;
                                            font-size: 16px;
                                            background-color: white;
                                            background-position: 10px 10px;
                                            background-repeat: no-repeat;
                                            padding: 12px;
                                            -webkit-transition: width 0.4s ease-in-out;
                                            transition: width 0.4s ease-in-out;
                                            height: 35px; " name="name" type="text" placeholder="enter keyword..."></td>
                                    <td>
                                        <button id="btnSearch" style="margin-top: 3px; width:120px; margin-left: 5px;"
                                                type="submit" class="btn btn-success"><i class="fa fa-search"
                                                                                         aria-hidden="true"></i>&nbsp
                                            Tìm kiếm
                                        </button>
                                    </td>

                                </tr>
                            </table>
                        </div>
                    </td>

                </tr>
            </table>
        </div>
    </form>
    <form id="formSubmit" action="${URLPagination}" method="GET">
        <table class="table table-striped">
            <thead>
            <tr>

                <th>Tên khóa học</th>
                <th>Mô tả</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Học phí</th>
                <th>Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr style="height: 30px">

                    <td>${item.name}</td>
                    <td>${item.des}</td>
                    <td>${item.startAt}</td>
                    <td>${item.endAt}</td>
                    <td>${item.fee}</td>
                    <td>
                        <a href="${URLChange}/${item.id}">
                            <button style=" margin-top:10px;  width:160px  ; height: 40px; text-align: center; font-size: 15px"
                                    type="button" class="btn btn-warning">
                                Xem chi tiết
                            </button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <ul style="margin-left: 160px;" class="pagination" id="pagination"></ul>
        <input type="hidden" id="pageNo" name="pageNo"/>
        <input type="hidden" id="pageSize" name="pageSize"/>
    </form>
</div>
<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>
<script>
    var currentPage = ${pagination.pageNo};
    var totalPage = ${pagination.totalPage};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 5,
            startPage: currentPage,//vi tri page dang dung
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#pageNo').val(page);
                    $('#pageSize').val(10);
                    $('#formSubmit').submit();
                }
            }
        });
    });

</script>
</body>
</html>
