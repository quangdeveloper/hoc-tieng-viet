<%@include file="/common/taglib.jsp" %>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="DELETEAPI" value="/v1/api/admin/lectures"></c:url>
<c:url var="URL" value="/v1/admin/lectures?pageNo=1&pageSize=10"></c:url>
<c:url var="URLCHANGE" value="/v1/admin/lectures/add"></c:url>
<c:url var="URLSearch" value="/v1/admin/lectures/search"></c:url>
<c:url var="URLPagination" value="/v1/admin/lectures"></c:url>
<html>
<head>
    <title></title>
</head>
<body>

<div>
    <form id="formSearch" action="${URLSearch}">
        <input type="hidden" value="1" name="pageNo"/>
        <input type="hidden" value="10" name="pageSize"/>
        <div style="margin-top: 5px; margin-bottom: 7px;">
            <table>
                <tr>
                    <td style="width: 75%">
                        <div>
                            <table>
                                <tr>
                                    <c:set var="padding" value="padding: 5px 5px 5 px 5px;
                                                                text-align: center"/>
                                    <td style="${padding}">Mã giảng viên</td>
                                    <td style="${padding}">Họ và tên</td>
                                    <td style="${padding}">Địa chỉ</td>
                                    <td style="${padding}">Nơi Sinh</td>
                                    <td style="${padding}">Số điện thoại</td>
                                    <td style="width: 150px;"></td>
                                </tr>
                                <tr>
                                    <c:set var="width" value="110px;"/>
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
                                            height: 20px; " type="text" name="maGiangVien"></td>
                                    <td><input style="width: 180px;
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
                                            height: 20px; " type="text" name="hoVaTen"></td>
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
                                            height: 20px; " type="text" name="diaChi"></td>
                                    <td><input style="width: 120px;
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
                                            height: 20px; " type="text" name="noiSinh"></td>
                                    <td><input style="width:${width};
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
                                            height: 20px; " type="text" name="soDienThoai"></td>

                                    <td>
                                        <button id="btnSearch" style="margin-top: 3px; width:120px; margin-left: 5px;"
                                                type="submit" class="btn btn-success"><i class="fa fa-search" aria-hidden="true"></i>&nbsp Tìm kiếm
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="${padding}">Email</td>

                                    <td style="${padding}">Ngày bắt đầu</td>
                                    <td style="${padding}">Ngày kết thúc</td>
                                    <td>Giới tính</td>
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
                                            height: 30px; " type="text" name="email"></td>
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
                                            height: 30px; " type="date" name="ngayBatDau"></td>
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
                                            height: 30px; " type="date" name="ngayKetThuc"></td>
                                    <td>
                                        <select style="
                                        width:100px;
                                        height:30px;
                                        font-size: small;"
                                                name="gioiTinh"
                                                class="form-control" >

                                            <option value="">select</option>
                                            <c:forEach var="item" items="${genders}">
                                                <option value="${item.id}">${item.gioiTinh} </option>
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
    <form id="formSubmit" action="${URLPagination}" >
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Mã giảng viên</th>
                <th>Họ và tên</th>
                <th>Địa chỉ</th>
                <th>Nơi sinh</th>
                <th>Email</th>
                <th>Số điện thoại</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr style="height: 30px">
                    <td>${item.maGiangVien}</td>
                    <td>${item.hoVaTen}</td>
                    <td>${item.diaChi}</td>
                    <td>${item.noiSinh}</td>
                    <td>${item.email}</td>
                    <td>${item.soDienThoai}</td>
                    <td>${item.ngayBatDau}</td>
                    <td>${item.ngayKetThuc}</td>
                    <td>
                            <%--                        sua bai viet--%>
                        <c:url var='EditURL' value="${URLCHANGE}">
                            <c:param name="id" value="${item.id}"/>
                        </c:url>
                        <a title="Edit" href="${EditURL}">
                            <button id="btnEdit" type="button" class="btn btn-primary">
                                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                            </button>
                        </a>
                        <input type="checkbox" id="cbx_${item.id}" value="${item.id}">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <ul style="margin-left: 160px;" class="pagination" id="pagination"></ul>
        <input type="hidden" id="pageNo"  value="1" name="pageNo"/>
        <input type="hidden" id="pageSize" value="10" name="pageSize"/>
    </form>
</div>
<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>
<script>

    var currentPage = ${pagination.pageNo};
    var totalPage = ${pagination.totalPage};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage ,
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
                if(ids.length > 0){
                    var isActive = confirm("Chắc chắn muốn xóa?");
                    if(isActive){
                        deleteMany(data);
                    }
                }else {
                    alert("Chưa chọn dữ liệu");
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
                    window.location.href = "${URL}";
                },
                error: function (error) {
                    window.location.href = "${URL}";
                }
            }
        );
    }
</script>


</body>
</html>
