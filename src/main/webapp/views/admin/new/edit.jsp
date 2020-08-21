
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="APIurl" value="/v1/api/admin/news"/>
<c:url var="NewURL" value="/v1/admin/news?pageNo=1&pageSize=10"/>
<c:url var="UploadURL" value="/v1/api/uploads"/>

<html>
<head>
    <title></title>
    <style type="text/css">
        .containnner {
        }

        .form-control {
            width: 250px;
        }
    </style>
</head>
<body>

<div>
    <div class="containnner" style=" margin-left: 50px;
            margin-top: 30px;">
        <div class="dropdown-divider"></div>
        <form id="formSubmit" enctype="multipart/form-data">
            <div class="row">
                <div class="col">
                    <label>Tiêu đề</label>

                    <c:if test="${not empty obj.ID }">
                        <textarea rows="5" cols="6" style="width: 250px" class="form-control"
                                   name="tieuDe" >${obj.tieuDe}</textarea><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <textarea rows="5" cols="6" style="width: 250px" class="form-control" name="tieuDe" required></textarea><br>
                    </c:if>

                    <label>Mô tả ngắn</label>
                    <c:if test="${not empty obj.ID }">
                        <textarea rows="5" cols="6" style="width: 250px" class="form-control"
                                  name="moTaNgan" >${obj.moTaNgan}</textarea><br>
                    </c:if>
                    <c:if test="${empty obj.ID }">
                        <textarea rows="5" cols="6" style="width: 250px" class="form-control" name="moTaNgan"
                                  required></textarea><br>
                    </c:if>

                    <label>Tác giả</label>
                    <c:if test="${ not empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control" value="${obj.tacGia}"
                               name="tacGia"><br>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="text" style="width: 250px" class="form-control" name="tacGia"><br>
                    </c:if>


                </div>

                <div class="col" style="margin-left:-250px; ">


                    <div class="col-sm-9" style="margin-left: -20px;width: 250px">
                        <label>Danh mục bài viết</label>
                        <select class="form-control" name="danhMuc">
                            <c:if test="${empty obj.ID}">
                                <c:forEach var="item" items="${types}">
                                    <option value="${item.ID}">${item.tenDanhMuc}</option>
                                </c:forEach>
                            </c:if>

                            <c:if test="${not empty obj.ID}">
                                <c:forEach var="item" items="${types}">
                                    <c:if test="${item.ID == obj.danhMucBaiViet.ID}">
                                        <option value="${item.ID}" selected="selected">${item.tenDanhMuc}</option>
                                    </c:if>
                                    <c:if test="${item.ID != obj.danhMucBaiViet.ID}">
                                        <option value="${item.ID}">${item.tenDanhMuc}</option>
                                    </c:if>

                                </c:forEach>
                            </c:if>
                        </select>
                    </div>
                    <br>

                    <label>Ảnh mô tả</label><br>
                        <c:if test="${not empty obj.ID}">
                            <img id = "thumnail" src="<c:url value="/pictures/${obj.anhMoTa}"/>" style="width: 250px; height: 200px;" ><br><br>
                            <input type="file" id="multipartFile" onchange="imageChange()" ><br>
                        </c:if>
                        <c:if test="${empty obj.ID}">
                            <img id = "thumnail" style="width: 250px; height: 200px;"><br><br>
                            <input type="file" id="multipartFile" onchange="imageChange()" ><br>
                        </c:if>
                        <br>

                    <br>
                    <div class="form-check-inline">
                        <label>Trạng thái:</label>&ensp;
                        <label class="form-check-label">
                            <c:forEach items="${status}" var="item">
                                <c:if test="${not empty obj.ID}">
                                    <c:if test="${item.ID == obj.trangThai.ID}">
                                        <input type="radio" class="form-check-input" name="trangThai" value="${item.ID}"
                                               checked> ${item.trangThai}
                                    </c:if>
                                    <c:if test="${item.ID != obj.trangThai.ID}">
                                        <input type="radio" class="form-check-input" name="trangThai"
                                               value="${item.ID}"> ${item.trangThai}
                                    </c:if>
                                </c:if>
                                <c:if test="${empty obj.ID}">
                                    <input type="radio" class="form-check-input" name="trangThai"
                                           value="${item.ID}"> ${item.trangThai}
                                </c:if>
                            </c:forEach>
                        </label>
                    </div>&ensp;

                    <br>
                    <c:if test="${not empty obj.ID}">

                        <input type="hidden" value="${obj.ID}" id="id" name="ID"/>

                        <button id="btnAddOrUpdateAcc" style="margin-left: 50px; margin-top: 15px;" type="button"
                                class="btn btn-primary">Cập nhập
                        </button>
                    </c:if>
                    <c:if test="${empty obj.ID}">
                        <input type="hidden" id="id" name="ID"/>
                        <button id="btnAddOrUpdateAcc" style="margin-left: 50px; margin-top: 15px;" type="button"
                                class="btn btn-primary">Thêm mới
                        </button>
                    </c:if>
                    <button style="margin-top: 15px;" type="reset" class="btn btn-secondary">Hủy bỏ</button>

                </div>

            </div>
            <label>Nội dung:</label>
            <c:if test="${not empty obj.ID }">
                <textarea id="noiDung" style="width: 1000px; height: 1000px;" class="form-control"
                          name="noiDung">${obj.noiDung}</textarea>
            </c:if>
            <c:if test="${empty obj.ID }">
                <textarea id="noiDung" style="width: 1000px; height: 1000px;" class="form-control"
                          name="noiDung"></textarea><br>
            </c:if>

        </form>
    </div>
</div>

<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>

<script>

    var imageLink = "${obj.anhMoTa}";
    var editor = '';
    $(document).ready(function(){
        editor = CKEDITOR.replace('noiDung');
    });

    $('#btnAddOrUpdateAcc').click(function (e) {

        e.preventDefault();

        var data = {};

        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            console.log(v);
            data["" + v.name + ""] = v.value;
        });

        data["noiDung"] = editor.getData();

        var id = $('#id').val();

        data["anhMoTa"] = $('#multipartFile')[0].files[0].name;

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
                alert("Thêm thành công !");
                window.location.href = "${NewURL}";
            },
            error: function (error) {
                alert("Thêm thất bại !");

            }
        });
    }
    function imageChange() {

            document.images['thumnail'].src = "/pictures/" + $('#multipartFile')[0].files[0].name;



    }

    function updateAcc(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                alert("Cập nhập thành công!");
                window.location.href = "${NewURL}";
            },
            error: function (error) {
                alert("Cập nhập thất bại !");
            }
        });
    }
</script>
</body>
</html>
