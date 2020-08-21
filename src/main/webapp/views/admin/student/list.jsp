<%@include file="/common/taglib.jsp" %>

<%@include file="/common/taglib.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="DELETEAPI" value="/v1/api/admin/students"></c:url>

<c:url var="URL" value="/v1/admin/students?pageNo=1&pageSize=10"></c:url>

<c:url var="URLCHANGE" value="/v1/admin/students/details"></c:url>

<c:url var="URLSearch" value="/v1/admin/students/search"></c:url>

<c:url var="URLPagination" value="/v1/admin/students"></c:url>

<c:url var="URLExport" value="/v1/api/admin/students/exports"></c:url>

<html>
<head>
    <title></title>
</head>
<body>

<div>
    <form id="formSearch" action="${URLSearch}" method="GET">
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
                                    <%--                                    <td style="${padding}">Số lượng</td>--%>
                                    <td style="${padding}">Họ và tên</td>
                                    <td style="${padding}">Giới tính</td>
                                    <td style="${padding}">Quốc gia</td>
                                    <td style="${padding}">Đối tượng ưu tiên</td>
                                    <td style="${padding}">Loại học bổng</td>
                                    <td style="${padding}">Hệ dào tạo</td>
                                    <td style="${padding}">Nơi học</td>
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
                                            height: 20px; " name= "hoVaTen" type="text"></td>
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
                                    <td><input style="width: 110px;
                                            height: 30px;
                                            border: 2px solid #ccc;
                                            border-radius: 4px;
                                            font-size: 13px;
                                             background-color: white;" name="quocGia" type="text"></td>
                                    <td>
                                        <select style="width:100px;height:30px;font-size: small;" name="doiTuongUuTien" class="form-control" >
                                            <option value="">select</option>
                                            <c:forEach var="item" items="${prioritizes}">
                                                <option value="${item.ID}">${item.loaiUuTien} </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <select style="width:100px;height:30px;font-size: small;" name="hocBong" class="form-control" >
                                            <option value="">select</option>
                                            <c:forEach var="item" items="${scholarship}">
                                                <option value="${item.ID}">${item.loaiHocBong} </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <select style="width:100px;height:30px;font-size: small;" name="heDaoTao" class="form-control" >
                                            <option value="">select</option>
                                            <c:forEach var="item" items="${trainningTypes}">
                                                <option value="${item.ID}">${item.tenHeDaoTao} </option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td>
                                        <select style="width:100px;height:30px;font-size: small;" name="coSoDaoTao" class="form-control" >
                                            <option value="">select</option>
                                            <c:forEach var="item" items="${shools}">
                                                <option value="${item.tenCoSo}">${item.tenCoSo} </option>
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
                                        <a href="${URLExport}">
                                            <button style=" margin-top: 3px;  width:100px  ;margin-left: 5px;"
                                                    type="button" class="btn btn-success">
                                                Export
                                            </button>
                                        </a>
                                    </td>
                                    <td style="width: ${width}"></td>
                                </tr>
                                <tr>

                                    <td>
                                        <button id="btnDeleteMany"
                                                style=" margin-top: 5px;  width:100px  ;margin-left: 5px;" type="button"
                                                class="btn btn-danger">Xóa
                                        </button>

                                    </td>
                                    <td style="width: ${width}"></td>
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
                <th>Họ và tên</th>
                <th>Giới tính</th>
                <th>Ngày sinh</th>
                <th>Nơi sinh</th>
                <th>Quốc gia</th>
                <th>Địa chỉ</th>
                <th>Đối tượng ưu tiên</th>
                <th>Học bổng</th>
                <th>Số hộ chiếu</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr style="height: 30px">
                    <td>${item.hoVaTen}</td>
                    <td>${item.gioiTinh.gioiTinh}</td>
                    <td>${item.ngaySinh}</td>
                    <td>${item.noiSinh}</td>
                    <td>${item.quocGia}</td>
                    <td>${item.diaChi}</td>
                    <td>${item.doiTuongUuTien.loaiUuTien}</td>
                    <td>${item.loaiHocBong.loaiHocBong}</td>
                    <td>${item.soHoChieu}</td>
                    <td>
                            <%--                        sua bai viet--%>
                        <c:url var='EditURL' value="${URLCHANGE}">
                            <c:param name="id" value="${item.ID}"/>
                        </c:url>
                        <a title="Edit" href="${EditURL}">
                            <button id="btnEdit" type="button" class="btn btn-primary">
                                <i class="fa fa-folder-open-o" aria-hidden="true"></i>
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
                    alert("Delete successful !!!");
                },
                error: function (error) {
                    alert("Delete faild !!! \n" + error.toString());
                }
            }
        );
    }


</script>
</body>
</html>
