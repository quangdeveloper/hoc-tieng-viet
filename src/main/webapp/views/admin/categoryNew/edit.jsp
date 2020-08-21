<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="APIurl" value="/v1/api/admin/categories"/>
<c:url var ="NewURL" value="/v1/admin/categories"/>
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
                    <label> Mã danh mục:</label>
                    <c:if test="${ not empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.maDanhMuc}" name="maDanhMuc" readonly ><br>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  name="maDanhMuc"  required><br>
                    </c:if>
                    <label> Tên danh mục:</label>
                    <c:if test="${ not empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  value="${obj.tenDanhMuc}" name="tenDanhMuc" ><br>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control"  name="tenDanhMuc"  required><br>
                    </c:if>



                    <c:if test="${not empty obj.ID}">
                        <input type="hidden" value="${obj.ID}" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin: 150px 0 0 0;" type="button" class="btn btn-primary">Cập nhập</button>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="hidden" id="id" name="id"/>
                        <button id = "btnAddOrUpdateAcc" style="margin: 150px 0 0 0;" type="button" class="btn btn-primary">Thêm mới</button>
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
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {

            data[""+v.name+""] = v.value;
        });

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
            },
            error: function (error) {
                alert("Create fail !!!")
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
            }
        });
    }
</script>
</body>
</html>
