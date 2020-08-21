<%@include file="/common/taglib.jsp" %>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="DELETEAPI" value="/v1/api/admin/news"></c:url>
<c:url var="URL" value="/v1/admin/news?pageNo=1&pageSize=10"></c:url>
<c:url var="URLCHANGE" value="/v1/admin/news/add"></c:url>
<c:url var="URLSearch" value="/v1/admin/news/searchs"></c:url>
<html>
<head>
    <title></title>
</head>
<body>

<div>
    <form id="formSearch" action="${URLSearch}" method="get">
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
                                    <td style="${padding}">Danh mục</td>
                                    <td style="${padding}">Tiêu đề</td>
                                    <td style="${padding}">Tác giả</td>
                                    <td style="${padding}">Người tạo</td>

                                    <td style="width: 150px;"></td>
                                </tr>
                                <tr>
                                    <c:set var="width" value="110px;"/>
                                    <td>
                                        <select style=" width:180px;
                                        height:35px;
                                        font-size: small;"
                                                name="danhMuc"
                                                class="form-control">

                                            <option value="">select</option>
                                            <c:forEach var="item" items="${types}">
                                                <option value="${item.ID}">${item.tenDanhMuc} </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><input style="width: 180px;
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
                                            height: 35px; " type="text" name="tieuDe"></td>
                                    <td><input style="width:180px;
                                            box-sizing: border-box;
                                            border: 2px solid #ccc;
                                            border-radius: 4px;
                                            font-size: 16px;
                                            background-color: white;
                                            background-position: 10px 10px;
                                            background-repeat: no-repeat;
                                            padding: 12px ;
                                            -webkit-transition: width 0.4s ease-in-out;
                                            transition: width 0.4s ease-in-out;
                                            height: 35px; " type="text" name="tacGia"></td>
                                    <td><input style="width: 140px;
                                            box-sizing: border-box;
                                            border: 2px solid #ccc;
                                            border-radius: 4px;
                                            font-size: 16px;
                                            background-color: white;
                                            background-position: 10px 10px;
                                            background-repeat: no-repeat;
                                            padding: 12px ;
                                            -webkit-transition: width 0.4s ease-in-out;
                                            transition: width 0.4s ease-in-out;
                                            height: 35px; " type="text" name="nguoiTao"></td>


                                    <td>
                                        <button id="btnSearch" style="margin-top: 3px; width:120px; margin-left: 5px;"
                                                type="submit" class="btn btn-success"><i class="fa fa-search"
                                                                                         aria-hidden="true"></i>&nbsp
                                            Tìm kiếm
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="${padding}">Ngày tạo BĐ</td>
                                    <td style="${padding}">Ngày tạo KT</td>
                                    <td style="text-align:left">Trạng thái</td>
                                </tr>
                                <tr>
                                    <td><input style="width: 180px;
                                            box-sizing: border-box;
                                            border: 2px solid #ccc;
                                            border-radius: 4px;
                                           font-size: 13px;
                                            background-color: white;
                                            background-position: 10px 10px;
                                            background-repeat: no-repeat;
                                            padding: 12px;
                                            -webkit-transition: width 0.4s ease-in-out;
                                            transition: width 0.4s ease-in-out;
                                            height: 35px; " type="date" name="ngayTaoBD"></td>
                                    <td><input style="width: 180px;
                                            box-sizing: border-box;
                                            border: 2px solid #ccc;
                                            border-radius: 4px;
                                            font-size: 13px;
                                            background-color: white;
                                            background-position: 10px 10px;
                                            background-repeat: no-repeat;
                                            padding: 12px ;
                                            -webkit-transition: width 0.4s ease-in-out;
                                            transition: width 0.4s ease-in-out;
                                            height: 35px; " type="date" name="ngayTaoKT"></td>
                                    <td>
                                        <select style=" width:100px;
                                        height:35px;
                                        font-size: small;"
                                                name="trangThai"
                                                class="form-control">

                                            <option value="">select</option>
                                            <c:forEach var="item" items="${status}">
                                                <option value="${item.ID}">${item.trangThai} </option>
                                            </c:forEach>
                                        </select>
                                    </td>

                                </tr>
                            </table>
                        </div>
                    </td>
                    <td style="width: 25%; text-align: right;">
                        <div>
                            <table>
                                <tr>
                                    <td style="width:${width}"></td>
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
    <form id="formSubmit" action="${URL}" method="get">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Tiêu đề</th>
                <th>Tác giả</th>
                <th>Tên danh mục</th>
                <th>Người tạo</th>
                <th>Ngày tạo</th>
                <th>Người sửa</th>
                <th>Ngày sửa</th>
                <th>Trạng thái</th>
                <th>Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr style="height: 30px">
                    <td>${item.tieuDe}</td>
                    <td>${item.tacGia}</td>
                    <td>${item.danhMucBaiViet.tenDanhMuc}</td>
                    <td>${item.nguoiTao}</td>
                    <td>${item.ngayTao}</td>
                    <td>${item.nguoiSua}</td>
                    <td>${item.ngaySua}</td>
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
                        <input type="checkbox" id="cbx_${item.ID}" value="${item.ID}">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <ul style="margin-left: 160px;" class="pagination" id="pagination"></ul>
        <input type="hidden" id="pageNo" name="pageNo" value="1"/>
        <input type="hidden" id="pageSize" name="pageSize" value="10"/>
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

            if ( ids.length < 1 ) {
                alert("Chưa chọn dữ liệu")
            } else {

                var isActive = confirm("Chắn chắn muốn xóa mục này?");

                if (isActive) {
                    data['ids'] = ids;
                    deleteMany(data);
                }

            }

        })
    );

    function deleteMany(data) {
        $.ajax({
                url: '${DELETEAPI}',
                type: 'DELETE',
                contentType: 'application/json',    //chi dinh loai data de gui ve server
                data: JSON.stringify(data),      //chi dinh data de gui toi server
                dataType: 'json',       //chi dinh loai data khi server tra ve
                success: function (result) {
                    alert("Xóa thành công !")
                    window.location.href = "${URL}";
                },
                error: function (error) {
                    alert("Xóa thất bại!")
                }
            }
        );
    }

</script>
</body>
</html>
