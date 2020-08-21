<%@include file="/common/taglib.jsp" %>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="DELETEAPI" value="/v1/api/admin/roles"></c:url>
<c:url var="URL" value="/v1/admin/roles"></c:url>
<c:url var="URLCHANGE" value="/v1/admin/roles/add"></c:url>
<c:url var="URLSearch" value="/v1/admin/roles/searchs"></c:url>
<c:url var="URLSearchUser" value="/v1/admin/roles/users"></c:url>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <form id="formSubmit" action="${URLSearch}">

        <div style="margin-top: 5px; margin-bottom: 7px;">
            <table>
                <tr>
                    <td style="width: 75%">
                        <div>
                            <table>
                                <tr>
                                    <c:set var="padding" value="padding: 5px 5px 5 px 5px;
                                                                text-align: center"/>
                                    <td style="${padding}">Tên quyền</td>
                                    <td style="${padding}">Nhóm quyền</td>
                                    <td style="${padding}">Người tạo</td>
                                </tr>
                                <tr>
                                    <c:set var="width" value="120px;"/>
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
                                            height: 35px; " type="text" name="tenQuyen"></td>
                                    <td>
                                        <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                                name="nhomQuyen"
                                                class="form-control">
                                            <option value="">Chọn tất cả</option>
                                            <c:forEach var="item" items="${groups}">
                                                <option value="${item.ID}">${item.tenNhom} </option>
                                            </c:forEach>
                                        </select>

                                    </td>
                                    <td><input style="width:200px;
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
                                            height: 35px; " type="text" name="nguoiTao"></td>

                                    <td>
                                        <button id="btnSearch" style="margin-top: 3px; width:120px; margin-left: 5px;"
                                                type="submit" class="btn btn-success"><i class="fa fa-search"
                                                                                         aria-hidden="true"></i> &nbsp
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


        <table class="table table-striped">
            <thead>
            <tr>
                <th>Tên quyền</th>
                <th>Mô tả</th>
                <th>Người tạo</th>
                <th>Ngày tạo</th>
                <th>Người sửa</th>
                <th>Ngày Sửa</th>
                <th>Nhóm quyền</th>
                <th>Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr style="height: 30px">
                    <td>${item.tenQuyen}</td>
                    <td>${item.moTa}</td>
                    <td>${item.nguoiTao}</td>
                    <td>${item.ngayTao}</td>
                    <td>${item.nguoiSua}</td>
                    <td>${item.ngaySua}</td>
                    <td>${item.nhomQuyen.tenNhom}</td>
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
                        <c:url var='StatisticalURL' value="${URLSearchUser}">
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
    </form>
</div>
<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>
<script>
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
                data: JSON.stringify(data),      //chi dinh data de gui toi server
                dataType: 'json',       //chi dinh loai data khi server tra ve
                success: function (result) {
                    window.location.href = "${URLSearch}";
                    alert("Delete successful!!!");
                },
                error: function (error) {
                    window.location.href = "${URLSearch}";
                    alert("Delete faild !!!");
                }
            }
        );
    }
</script>


</body>
</html>
