<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<c:url var="APIurl" value="/v1/api/admin/courses"/>
<c:url var ="NewURL" value="/v1/admin/courses?pageNo=1&pageSize=10"/>
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
                    <label>Mã khóa học:</label>
                    <c:if test="${ not empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.maKhoaHoc}" name="maKhoaHoc" readonly ><br>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  name="maKhoaHoc" placeholder="Mã khóa học" required><br>
                    </c:if>

                    <label>Tên khóa học:</label>
                    <c:if test="${ not empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.tenKhoaHoc}" name="tenKhoaHoc" readonly ><br>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  name="tenKhoaHoc" placeholder="Tên khóa học" required><br>
                    </c:if>

                    <label>Mô tả:</label>
                    <c:if test="${not empty obj.ID }">
                        <textarea rows="5" cols="6" style="width: 250px" class="form-control"  name="moTa" >${obj.moTa}</textarea><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <textarea rows="5" cols="6" style="width: 250px" class="form-control" name="moTa" required></textarea><br>
                    </c:if>



                </div>

                <div class="col" style="margin-left:-250px; ">
                    <label>Ngày bắt đầu:</label>
                    <c:if test="${not empty obj.ID }">
                        <input type="date" style="width: 250px" class="form-control"  value="${obj.ngayBatDau}"  name="ngayBatDau" ><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <input type="date" style="width: 250px" class="form-control" placeholder="Ngày bắt đầu"   name="ngayBatDau" required><br>
                    </c:if>
                    <label>Ngày kết thúc:</label>
                    <c:if test="${not empty obj.ID }">
                        <input type="date" style="width: 250px" class="form-control"  value="${obj.ngayKetThuc}"  name="ngayKetThuc" ><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <input type="date" style="width: 250px" class="form-control" placeholder="Ngày kết thúc"   name="ngayKetThuc" required><br>
                    </c:if>
                    <label>Học phí:</label>
                    <c:if test="${not empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.hocPhi}"  name="hocPhi" ><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Học phí"   name="hocPhi" required><br>
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

                    <div class="form-check-inline">
                        <label>Trạng thái:</label>&ensp;
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
                                <c:if test="${empty obj.ID}">
                                    <input type="radio" class="form-check-input" name="trangThai" value="${item.ID}"> ${item.trangThai}
                                </c:if>
                            </c:forEach>
                        </label>
                    </div>&ensp;
                    <br>
                    <c:if test="${not empty obj.ID}">
                        <input type="hidden" value="${obj.ID}" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin-left: 50px; margin-top: 15px;" type="button" class="btn btn-primary">Cập nhập</button>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="hidden" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin-left: 50px; margin-top: 15px;" type="button" class="btn btn-primary">Thêm mới</button>
                    </c:if>
                    <button style="margin-top: 15px;" type="reset" class="btn btn-secondary">Hủy bỏ</button>

                </div>

            </div>
            <label>Nội dung:</label>
            <c:if test="${not empty obj.ID }">
                <textarea id ="noiDung"  style="width: 1000px; height: 1000px;" class="form-control"  name="noiDung" >${obj.noiDung}</textarea>
            </c:if>
            <c:if test="${empty obj.ID }">
                <textarea id ="noiDung"  style="width: 1000px; height: 1000px;" class="form-control"  name="noiDung" required></textarea><br>
            </c:if>
        </form>
    </div>
</div>
<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>

<script>
    //giong nhu ham main cua 1 chuongtrinh java nhung ham trong (document).ready() se chay trc khi load trang sau do moi chay toi cac ham khac
    var editor = '';
    $(document).ready(function(){
        editor = CKEDITOR.replace('noiDung');
    });

    $('#btnAddOrUpdateAcc').click(function (e) {

        e.preventDefault();//de tranh submit nham vao URL hien tai

        var data = {};//khoi tao 1 mang chua du lieu

        var formData = $('#formSubmit').serializeArray();//lay tuan tu gia trong form theo ten (name) da dat theo dang array roi chuyen vao bien formdata

        $.each(formData, function (i, v) { //su dung vong for trong jquery gom 3 tham so lan luot la listData, function( vi tri, gia tri)

            console.log(v); //lenh in ra man hinh console tren web
            data[""+v.name+""] = v.value;//gan gia tri cho mang data de gửi về sever
        });

        data["noiDung"] = editor.getData();

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
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                alert("Create successful!");
                window.location.href = "${NewURL}";
            },
            error: function (error) {
                alert("Create fail!\n");
            }
        });
    }

    function updateAcc(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {

                alert("Update successful!");
                window.location.href = "${NewURL}";
            },
            error: function (error) {

                console.log(error.toString());
                alert("Update fail!");
            }
        });
    }
</script>
</body>
</html>
