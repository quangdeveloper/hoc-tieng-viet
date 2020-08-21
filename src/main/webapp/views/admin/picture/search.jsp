<%@include file="/common/taglib.jsp" %>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="DELETEAPI" value="/v1/api/admin/pictures"></c:url>
<c:url var="URL" value="/v1/admin/pictures?pageNo=1&pageSize=9"></c:url>
<c:url var="URLCHANGE" value="/v1/admin/pictures/add"></c:url>
<c:url var="URLSearch" value="/v1/admin/pictures/search"></c:url>
<c:url var="URLPagination" value="/v1/admin/pictures"></c:url>

<html>
<head>
    <title></title>
</head>
<body>

<div>
    <form id="formSearch" action="${URLSearch}" method="GET">
        <input type="hidden"  name="pageNo" value="1"/>
        <input type="hidden"  name="pageSize" value="9"/>
        <div style="margin-top: 5px; margin-bottom: 7px;">
            <table>
                <tr>
                    <c:set var="padding" value="padding: 5px 5px 5 px 5px;
                                                                text-align: center"/>
                    <td >
                        Trạng thái:
                    </td>
                    <td>

                        <select style="width:150px;height:36px;font-size: small;" name="status" class="form-control" >
                            <option value="0" <c:if test="${infoSearch  == 0}">selected</c:if> >non-active</option>
                            <option value="1" <c:if test="${infoSearch  == 1}">selected</c:if> >active</option>
                        </select>
                    </td>
                    <td>
                        <button id="btnSearch" style="margin-top: 3px; width:120px; margin-left: 5px;"
                                type="submit" class="btn btn-success"><i class="fa fa-search"
                                                                         aria-hidden="true"></i>&nbsp
                            Tìm kiếm
                        </button>
                    </td>
                    <td>

                        <a href="${URLCHANGE}">
                            <button style=" margin-top: 3px;  width:100px  ;margin-left: 5px;"
                                    type="button" class="btn btn-success">
                                Thêm
                            </button>
                        </a>
                    </td>
                    <td>
<%--                        <button id="btnDeleteMany"--%>
<%--                                style=" margin-top: 5px;  width:100px  ;margin-left: 5px;" type="button"--%>
<%--                                class="btn btn-danger">Xóa--%>
<%--                        </button>--%>
                    </td>

                </tr>
            </table>
        </div>
    </form>
        <form id="formSubmit" action="${URLPagination}" method="GET">
            <div class="row">

                <div class="col-lg-9">

                    <div class="row" >
                        <c:forEach items="${pictures}" var="item">
                            <div class="col-lg-4 col-md-6 mb-4" id ="course">
                                <div class="card h-100">
                                    <img class="card-img-top" src="/pictures/${item.linkImage}" alt="Error">

                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

            </div>
        <ul style="margin-left: 160px;" class="pagination" id="pagination"></ul>
        <input type="hidden" id="pageNo" name="pageNo"/>
        <input type="hidden" id="pageSize" name="pageSize"/>
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
                    $('#pageSize').val(9);
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
                    alert("Delete successful !!!");
                    window.location.href = "${URL}";
                },
                error: function (error) {
                    alert("Delete faild !!!");
                    window.location.href = "${URL}";
                }
            }
        );
    }


</script>
</body>
</html>
