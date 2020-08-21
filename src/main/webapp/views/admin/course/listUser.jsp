<%@include file="/common/taglib.jsp" %>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="DELETEAPI" value="/v1/api/admin/students"></c:url>
<c:url var="URL" value="/v1/admin/courses/students"></c:url>
<html>
<head>
    <title></title>
</head>
<body>

<div>

    <form id="formSubmit" action="${URLPagination}" method="GET">
        <button id="btnDeleteMany"
                style=" margin-top: 5px;  width:100px  ;margin-left:90%;" type="button"
                class="btn btn-danger">Xóa
        </button>
        <table class="table table-striped table-bordered table-sm ">
            <thead>
            <tr>
                <th>Họ và tên</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Quốc gia</th>
                <th>Đối tượng ưu tiên</th>
                <th>Kiểu học bổng</th>
                <th>Nới học</th>
                <th>Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr style="height: 30px">
                    <td>${item.fullName}</td>
                    <td>${item.dateOfBirth}</td>
                    <td>${item.gender}</td>
                    <td>${item.national}</td>
                    <td>${item.priority}</td>
                    <td>${item.scholarship}</td>
                    <td>${item.placeLearn}</td>
                    <td>
                        <input type="checkbox" id="cbx_${item.id}" value="${item.id}">
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
                    alert("Delete successful !!!");
                    location.reload();
                },
                error: function (error) {
                    alert("Delete faild !!!");

                }
            }
        );
    }


</script>
</body>
</html>
