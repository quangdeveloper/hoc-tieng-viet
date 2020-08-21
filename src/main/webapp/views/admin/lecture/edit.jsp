<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="APIurl" value="/v1/api/admin/lectures"/>
<c:url var ="NewURL" value="/v1/admin/lectures?pageNo=1&pageSize=10"/>
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
                    <label> Mã giảng viên:</label>
                    <c:if test="${ not empty obj.id}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.maGiangVien}" name="maGiangVien" readonly ><br>
                    </c:if>
                    <c:if test="${empty obj.id}">
                        <input type="text" style="width: 250px" class="form-control"  name="maGiangVien" placeholder="Mã giảng viên" required><br>
                    </c:if>
                    <label> Tên giảng viên:</label>
                    <c:if test="${ not empty obj.id}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.hoVaTen}" name="hoVaTen" readonly ><br>
                    </c:if>
                    <c:if test="${empty obj.id}">
                        <input type="text" style="width: 250px" class="form-control"  name="hoVaTen" placeholder="Tên giảng viên" required><br>
                    </c:if>

                    <label>Giới tính:</label>&ensp;
                    <div class="form-check-inline">
                        <label class="form-check-label">
                            <c:forEach items="${genders}" var="item">

                                <c:if test="${not empty obj.id}">
                                    <c:if test="${item.id == obj.gioiTinh.id}">
                                        <input type="radio" class="form-check-input" name="gioiTinh" value="${item.id}" checked > ${item.gioiTinh}
                                    </c:if>
                                    <c:if test="${item.id != obj.gioiTinh.id}">
                                        <input type="radio" class="form-check-input" name="gioiTinh" value="${item.id}"> ${item.gioiTinh}
                                    </c:if>
                                </c:if>

                                <c:if test="${empty obj.id}">
                                    <input type="radio" class="form-check-input" name="gioiTinh" value="${item.id}" > ${item.gioiTinh}
                                </c:if>
                            </c:forEach>

                        </label>
                    </div>&ensp;
                    <br>

                    <label>Địa chỉ:</label>
                    <c:if test="${not empty obj.id }">
                    <input type="text" style="width: 250px" class="form-control"  value="${obj.diaChi}"  name="diaChi" ><br>
                    </c:if>
                    <c:if test="${empty obj.id }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Địa chỉ"   name="diaChi" required><br>
                    </c:if>


                    <label>Nơi sinh:</label>
                    <c:if test="${not empty obj.id}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.noiSinh}"  name="noiSinh" readonly><br>
                    </c:if>
                    <c:if test="${empty obj.id }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Nơi sinh"   name="noiSinh" required><br>
                    </c:if>

                    <label>Email:</label>
                    <c:if test="${not empty obj.id }">
                        <input type="text" style="width: 250px" class="form-control" value="${obj.email}" name="email" required><br>
                    </c:if>
                    <c:if test="${empty obj.id }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Email" name="email" required><br>
                    </c:if>

<%--                    <label>Số điện thoại:</label>--%>
<%--                    <c:if test="${not empty obj.id }">--%>
<%--                        <input type="text" style="width: 250px" class="form-control" value="${obj.soDienThoai}" name="soDienThoai" required><br>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${empty obj.id }">--%>
<%--                        <input type="text" style="width: 250px" class="form-control" placeholder="Số điện thoại" name="soDienThoai"><br>--%>
<%--                    </c:if>--%>

                </div>

                <div class="col" style="margin-left:-250px; ">

                    <label>Số điện thoại:</label>
                    <c:if test="${not empty obj.id }">
                        <input type="text" style="width: 250px" class="form-control" value="${obj.soDienThoai}" name="soDienThoai" required><br>
                    </c:if>
                    <c:if test="${empty obj.id }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Số điện thoại" name="soDienThoai"><br>
                    </c:if>

                    <label>Ngày bắt đầu:</label>
                    <c:if test="${not empty obj.id }">
                        <input type="date" style="width: 250px" class="form-control" value="${obj.ngayBatDau}" name="ngayBatDau" ><br>
                    </c:if>
                    <c:if test="${empty obj.id }">
                        <input type="date" style="width: 250px" class="form-control" placeholder="Ngày bắt đầu" name="ngayBatDau"><br>
                    </c:if>
                    <label>Ngày kết thúc:</label>
                    <c:if test="${not empty obj.id }">
                        <input type="date" style="width: 250px" class="form-control" value="${obj.ngayKetThuc}" name="ngayKetThuc" ><br>
                    </c:if>
                    <c:if test="${empty obj.id }">
                        <input type="date" style="width: 250px" class="form-control" placeholder="Ngày kết thúc" name="ngayKetThuc"><br>
                    </c:if>



                    <c:if test="${not empty obj.id}">
                        <input type="hidden" value="${obj.id}" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin: 150px 0 0 0;" type="button" class="btn btn-primary">Cập nhập</button>
                    </c:if>
                    <c:if test="${empty obj.id}">
                        <input type="hidden" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin: 150px 0 0 0;" type="button" class="btn btn-primary">Thêm giảng viên</button>
                    </c:if>
                    <button style="margin: 150px 0 0 0;" type="reset" class="btn btn-secondary">Hủy bỏ</button>

                </div>
            </div>
        </form>
    </div>
</div>
<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>
<script>

    $('#btnAddOrUpdateAcc').click(function (e) {
        e.preventDefault();//de tranh submit nham vao URL hien tai
        var data = {};//khoi tao 1 mang chua du lieu
        var formData = $('#formSubmit').serializeArray();//lay tuan tu gia trong form theo ten (name) da dat theo dang array roi chuyen vao bien formdata
        $.each(formData, function (i, v) { //su dung vong for trong jquery gom 3 tham so lan luot la listData, function( vi tri, gia tri)
            console.log(v); //lenh in ra man hinh console tren web
            data[""+v.name+""] = v.value;//gan gia tri cho mang data de gửi về sever
        });
        // data["content"] = editor.getData();
        var id = $('#id').val();
        if (id == "") {
            add(data);
        } else {
            update(data);
        }
    });
    function add(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                alert(" Create successful !!!");
                window.location.href = "${NewURL}";
                // console.log(data);
            },
            error: function (error) {
                alert(" Create fail !!!");
                // console.log(data);

            }
        });
    }
    function update(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                alert("Update information successful !!!");
                window.location.href = "${NewURL}";
            },
            error: function (error) {
                alert("Update information fail !!!");

            }
        });
    }
</script>
</body>
</html>
