<%@include file="/common/taglib.jsp" %>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="DELETEAPI" value="/v1/api/admin/courses"></c:url>
<c:url var="URL" value="/v1/admin/courses?pageNo=1&pageSize=10"></c:url>
<c:url var="URLCHANGE" value="/v1/admin/courses/add"></c:url>
<c:url var="URLSearch" value="/v1/admin/courses/search"></c:url>
<c:url var="URLSearchStudent" value="/v1/admin/courses/students"></c:url>
<c:url var="URLPagination" value="/v1/admin/courses"></c:url>
<c:url var="URLExport" value="/v1/api/admin/courses/export"></c:url>

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
                                    <c:set var="padding" value="padding: 5px 5px 5 px 5px;
                                                                text-align: center"/>
                                    <td style="${padding}">Mã khóa học</td>
                                    <td style="${padding}">Tên khóa học</td>
                                    <td style="${padding}">Ngày bắt đầu</td>
                                    <td style="${padding}">Ngày kết thúc</td>
                                    <td style="${padding}"> Trạng thái</td>
                                    <td style="width: 150px;"></td>
                                </tr>
                                <tr>
                                    <c:set var="width" value="110px;"/>
                                    <td><input style="width: ${width};
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
                                            height: 20px; " name="maKhoaHoc" type="text"></td>
                                    <td><input style="width: 150px;
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
                                            height: 20px; " name="tenKhoaHoc" type="text"></td>
                                    <td><input style="width: 180px;
                                            height: 30px;
                                            border: 2px solid #ccc;
                                            border-radius: 4px;
                                            font-size: 13px;
                                             background-color: white;" name="ngayBatDau" type="date"></td>
                                    <td><input style="width: 180px;
                                            height: 30px;
                                            border: 2px solid #ccc;
                                            border-radius: 4px;
                                            font-size: 13px;
                                             background-color: white;" name="ngayKetThuc" type="date"></td>
                                    <td>
                                        <select style="width:100px;height:30px;font-size: small;" name="trangThai"
                                                class="form-control">
                                            <option value="">select</option>
                                            <c:forEach var="item" items="${status}">
                                                <option value="${item.ID}">${item.trangThai} </option>
                                            </c:forEach>
                                        </select>
                                    </td>
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
                    <td style="width: 25%; text-align: right;">
                        <div>
                            <table>
                                <tr>

                                    <td>
                                        <c:url var="AddURL" value="${URLCHANGE}">
                                            <c:param name="id"/>
                                        </c:url>
                                        <a href="${AddURL}">
                                            <button style=" margin-top: 3px;  width:100px  ;margin-left: 5px;"
                                                    type="button" class="btn btn-success">
                                                Thêm
                                            </button>
                                        </a>
                                    </td>
                                    <td style="width:${width}">
                                        <a href="${URLExport}">
                                            <button style=" margin-top: 3px;  width:100px  ;margin-left: 5px;"
                                                    type="button" class="btn btn-success">
                                                Export
                                            </button>
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: ${width}"></td>
                                    <td>
                                        <button id="btnDeleteMany"
                                                style=" margin-top: 5px;  width:100px  ;margin-left: 5px;" type="button"
                                                class="btn btn-danger">Xóa
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
                <th>Mã khóa học</th>
                <th>Tên khóa học</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Học phí</th>
                <th>Trạng thái</th>
                <th>Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr style="height: 30px">
                    <td>${item.maKhoaHoc}</td>
                    <td>${item.tenKhoaHoc}</td>
                    <td>${item.ngayBatDau}</td>
                    <td>${item.ngayKetThuc}</td>
                    <td>${item.hocPhi}</td>
                    <td>${item.trangThai.trangThai}</td>
                    <td>
                            <%--                        sua bai viet--%>
                        <c:url var='EditURL' value="${URLCHANGE}">
                            <c:param name="id" value="${item.ID}"/>
                        </c:url>
                        <a title="Edit" href="${EditURL}">
                            <button id="btnEdit" type="button" class="btn btn-primary">
                                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                            </button>
                        </a>
                        <c:url var='StatisticalURL' value="${URLSearchStudent}">
                            <c:param name="id" value="${item.ID}"/>
                        </c:url>
                        <a title="Edit" href="${StatisticalURL}">
                            <button id="btnStatistical" type="button" class="btn btn-primary">
                                <i class="fa fa-address-book-o" aria-hidden="true"></i>
                            </button>
                        </a>
                        <input type="checkbox" id="cbx_${item.ID}" value="${item.ID}">
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

    $(document).ready(
        $('#btnDeleteMany').click(function e() {
            var data = {};
            var ids = $('tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            data['ids'] = ids;
            if (ids.length > 0) {

                var isActive = confirm("Chắc chắn muốn xóa?");
                if (isActive) {
                    deleteMany(data);
                }
            } else {
                alert("Chưa chọn dữ liệu");
            }

        })
    );

    function deleteMany(data) {
        $.ajax({
                url: '${DELETEAPI}',
                type: 'DELETE',
                contentType: 'application/json',    //chi dinh loai data de gui ve server
                data: JSON.stringify(data),      //chuyển đổi sang định dạng json
                dataType: 'json',       //chi dinh loai data khi server tra ve
                success: function (result) {
                    alert("Delete successful !!!");
                    window.location.href = "${URL}";
                },
                error: function (error) {
                    alert("Delete faild !!!");
                    window.location.href = "${URL}";
                }
            }
        );
    }


</script>
</body>
</html>