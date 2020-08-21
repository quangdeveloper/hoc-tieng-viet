<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="APIurl" value="/v1/api/admin/roles"/>
<c:url var ="NewURL" value="/v1/admin/roles"/>
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
                    <label> Tên quyền:</label>
                    <c:if test="${ not empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.tenQuyen}" name="tenQuyen" readonly ><br>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  name="tenQuyen" placeholder="Tên quyền" required><br>
                    </c:if>
                    <label> Mô tả:</label>
                    <c:if test="${ not empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.moTa}" name="moTa" ><br>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  name="moTa" placeholder="Mô tả" required><br>
                    </c:if>

                    <label>Người tạo:</label>
                    <c:if test="${not empty obj.ID }">
                    <input type="text" style="width: 250px" class="form-control"  value="${obj.nguoiTao}"  name="nguoiTao" readonly><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <input type="text" style="width: 250px" class="form-control" placeholder="Người tạo"   name="nguoiTao" required><br>
                    </c:if>


                    <c:if test="${not empty obj.ID }">
                        <label>Người sửa:</label>
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.nguoiSua}"  name="nguoiSua" required><br>

                        <label>Ngày tạo:</label>
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.ngayTao}"  name="ngayTao" readonly><br>
                    </c:if>

                </div>

                <div class="col" style="margin-left:-250px; ">
                    <label>Nhóm quyền:</label>
                    <div class="col-sm-9" style="margin-left: -20px;width: 250px">
                        <select class="form-control"  name="nhomQuyen">
                            <c:if test="${empty obj.ID}">
                                <option >Chọn nhóm quyền</option>
                                <c:forEach var="item" items="${nhomQuyenList}">
                                    <option value="${item.ID}">${item.tenNhom}</option>
                                </c:forEach>
                            </c:if>

                            <c:if test="${not empty obj.ID}">
                                <c:forEach var="item" items="${nhomQuyenList}">
                                    <c:if test="${item.ID == obj.nhomQuyen.ID}">
                                        <option value="${item.ID}" selected="selected">${item.tenNhom}</option>
                                    </c:if>
                                    <c:if test="${item.ID != obj.nhomQuyen.ID}">
                                        <option value="${item.ID}">${item.tenNhom}</option>
                                    </c:if>


                                </c:forEach>
                                <option >Chọn nhóm quyền</option>
                            </c:if>
                        </select>
                    </div>

                    <c:if test="${not empty obj.ID}">
                        <input type="hidden" value="${obj.ID}" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin: 150px 0 0 0;" type="button" class="btn btn-primary">Cập nhập</button>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="hidden" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin: 150px 0 0 0;" type="button" class="btn btn-primary">Thêm quyền</button>
                    </c:if>
                    <button style="margin: 150px 0 0 0;" type="reset" class="btn btn-secondary">Hủy bỏ</button>

                </div>
            </div>
        </form>
    </div>
</div>
<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>
<script>
    // var editor = '';
    // $(document).ready(function(){
    //     editor = CKEDITOR.replace( 'content');
    // });

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
                alert("Create successful !!!")
                window.location.href = "${NewURL}?message=insert_success";
                // console.log(data);
            },
            error: function (error) {
                alert("Create fail !!!")
                // console.log(data);
                window.location.href = "${NewURL}?message=error_system";
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
                alert("Update information successful !!!")
                window.location.href = "${NewURL}?&message=update_success";
            },
            error: function (error) {
                alert("Update information fail !!!")
                window.location.href = "${NewURL}?message=error_system";
            }
        });
    }
</script>
</body>
</html>
