<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="APIurl" value="/v1/api/admin/accounts"/>
<c:url var ="NewURL" value="/v1/admin/accounts?pageNo=1&pageSize=10"/>
<html>
<head>
    <title></title>
    <style type="text/css">
        .containnner{
        }
        .form-control{
            width:  250px;
        }
    </style>
</head>
<body>
<div>
    <div class= "containnner" style=" margin-left: 50px;
            margin-top: 30px;">
        <div class="dropdown-divider"></div>
        <form id = "formSubmit">
            <div class="row">
                <div class="col">
                    <label> Họ và tên:</label>
                    <c:if test="${ not empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.hoVaTen}" name="hoVaTen" readonly ><br>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  name="hoVaTen" placeholder="Họ và tên" required><br>
                    </c:if>


                    <label>Giới tính:</label>&ensp;
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <c:forEach items="${genders}" var="item">

                                <c:if test="${not empty obj.ID}">
                                    <c:if test="${item.id == obj.gioiTinh.id}">
                                        <input type="radio" class="form-check-input" name="gioiTinh" value="${item.id}" checked > ${item.gioiTinh}
                                    </c:if>
                                    <c:if test="${item.id != obj.gioiTinh.id}">
                                        <input type="radio" class="form-check-input" name="gioiTinh" value="${item.id}"> ${item.gioiTinh}
                                    </c:if>
                                </c:if>

                                <c:if test="${empty obj.ID}">
                                    <input type="radio" class="form-check-input" name="gioiTinh" value="${item.id}" > ${item.gioiTinh}
                                </c:if>
                            </c:forEach>

                        </label>
                    </div>&ensp;
                    <br>

                    <label>Tên đăng nhâp:</label>
                    <c:if test="${not empty obj.ID }">
                    <input type="text" style="width: 250px" class="form-control"  value="${obj.taiKhoan}"  name="taiKhoan" readonly><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Tài khoản"   name="taiKhoan" required><br>
                    </c:if>


                    <c:if test="${not empty obj.ID }">
                        <label>Mật khẩu mới:</label>
                        <input type="text" style="width: 250px" class="form-control" placeholder="Mật khẩu mới" name="matKhau" required><br>
<%--                        <input type="text" style="width: 250px" class="form-control" placeholder="xác nhận lại"><br>--%>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <label>Mật khẩu:</label>
                        <input type="text" style="width: 250px" class="form-control" placeholder="Mật khẩu" name="matKhau" required><br>
                    </c:if>

                    <label>Email:</label>
                    <c:if test="${not empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control" value="${obj.email}" name="email" required><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Email" name="email" required><br>
                    </c:if>

                    <label>Số điện thoại:</label>
                    <c:if test="${not empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control" value="${obj.soDienThoai}" name="soDienThoai" required><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Số điện thoại" name="soDienThoai"><br>
                    </c:if>

                    <c:if test="${not empty obj.ID }">
                        <label>Người Sửa:</label>
                        <input type="text" style="width: 250px" class="form-control" name="nguoiSua" required><br>
                    </c:if>

                    <label>Người tạo:</label>
                    <c:if test="${not empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control" value="${obj.nguoiTao}" name="nguoiTao" readonly><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Người tạo" name="nguoiTao" required><br>
                    </c:if>
                </div>

                <div class="col" style="margin-left:-250px; ">
                    <h4>Quyền</h4>
                    <div class="form-check">
                            <c:forEach items="${roles}" var="itemRole">
                                <c:if test="${not empty obj.ID}">
                                    <c:set var="check" value="false"/>
                                    <c:forEach items="${tk_roles}" var="item_tk">
                                        <c:if test="${itemRole.ID == item_tk}">
                                            <c:set var="check" value="true"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${check == true}">
                                        <div class="form-check">
                                            <label class="form-check-label" >
                                                <input type="checkbox" class="form-check-input"  value="${itemRole.ID}" checked>${itemRole.moTa}
                                            </label>
                                        </div>
                                    </c:if>
                                    <c:if test="${check == false}">
                                        <div class="form-check">
                                            <label class="form-check-label" >
                                                <input type="checkbox" class="form-check-input"  value="${itemRole.ID}">${itemRole.moTa}
                                            </label>
                                        </div>
                                    </c:if>
                                </c:if>

                                <c:if test="${empty obj.ID}">
                                    <div class="form-check"  >
                                        <label class="form-check-label" >
                                            <input type="checkbox" class="form-check-input"  value="${itemRole.ID}">${itemRole.moTa}
                                        </label>
                                    </div>
                                </c:if>
                            </c:forEach>
                    </div>

                    <div class="form-check-inline">

                        <c:if test="${not empty obj.ID}">
                            <label>Trạng thái:</label>&ensp;
                        </c:if>
                        <label class="form-check-label">
                            <c:forEach items="${status}" var="item">
                                <c:if test="${not empty obj.ID}">

                                    <c:if test="${item.ID == obj.trangThai.ID}">
                                        <input type="radio" class="form-check-input" name="trangThai" value="${item.ID}" checked > ${item.trangThai}
                                    </c:if>
                                    <c:if test="${item.ID != obj.trangThai.ID}">
                                        <input type="radio" class="form-check-input" name="trangThai" value="${item.ID}"> ${item.trangThai}
                                    </c:if>
                                </c:if>
                            </c:forEach>

                        </label>
                    </div>&ensp;

                    <c:if test="${not empty obj.ID}">
                        <input type="hidden" value="${obj.ID}" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin: 150px 0 0 0;" type="button" class="btn btn-primary">Cập nhập</button>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="hidden" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin: 150px 0 0 0;" type="button" class="btn btn-primary">Thêm tài khoản</button>
                    </c:if>
                    <button style="margin: 150px 0 0 0;" type="reset" class="btn btn-secondary">Hủy bỏ</button>

                </div>
            </div>
        </form>
    </div>
</div>
<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>

<script>

    Object.keys(a);


    $('#btnAddOrUpdateAcc').click(function (e) {
        e.preventDefault();//de tranh submit nham vao URL hien tai
        var data = {};//khoi tao 1 mang chua du lieu
        var formData = $('#formSubmit').serializeArray();//lay tuan tu gia trong form theo ten (name) da dat theo dang array roi chuyen vao bien formdata
        $.each(formData, function (i, v) { //su dung vong for trong jquery gom 3 tham so lan luot la listData, function( vi tri, gia tri)
            console.log(v); //lenh in ra man hinh console tren web
            data[""+v.name+""] = v.value;//gan gia tri cho mang data de gửi về sever
        });
        // data["content"] = editor.getData();
        var ids = $(' input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['ids'] = ids;
        var id = $('#id').val();
        if (id == "") {
            addAcc(data);
        } else {
            updateAcc(data);
        }
    });
    function addAcc(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),

            dataType: 'json',
            success: function (result) {
                alert("Addition infomation successful!");
                window.location.href = "${NewURL}";
            },
            error: function (error) {
                alert("Addition infomation faild!");

            }
        });
    }
    function updateAcc(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                alert("Update infomation successful!");
                window.location.href = "${NewURL}";
            },
            error: function (error) {
                alert("Update infomation faild!");
                window.location.href = "${NewURL}";
            }
        });
    }
</script>
</body>
</html>
