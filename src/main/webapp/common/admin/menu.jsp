<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="bg-light border-right" id="sidebar-wrapper" >
    <div class="sidebar-heading">Danh mục</div>
    <div class="list-group list-group-flush">
        <a href="/v1/admin/courses?pageNo=1&pageSize=10" class="list-group-item list-group-item-action bg-light">
            <span><i  class="fa fa-list-alt" aria-hidden="true" style="color: #007bff"></i></span>
            Khóa học</a>
        <a href="/v1/admin/students?pageNo=1&pageSize=10" class="list-group-item list-group-item-action bg-light">
            <span><i class="fa fa-floppy-o"  aria-hidden="true" style="color: #007bff"></i></span>
            Thông tin đăng kí</a>
        <a href="/v1/admin/categories" class="list-group-item list-group-item-action bg-light">
            <span><i class="fa fa-list" aria-hidden="true" style="color: #007bff"></i></span>
            Danh mục bài viết</a>
        <a href="/v1/admin/news?pageNo=1&pageSize=10" class="list-group-item list-group-item-action bg-light">
            <span><i class="fa fa-newspaper-o" aria-hidden="true" style="color: #007bff"></i></span>
            Bài viết</a>

        <a href="/v1/admin/lectures?pageNo=1&pageSize=10" class="list-group-item list-group-item-action bg-light">
            <span><i class="fa fa-address-book-o" aria-hidden="true" style="color: #007bff"></i></span>
            Giảng viên</a>

        <a href="/v1/admin/accounts?pageNo=1&pageSize=10" class="list-group-item list-group-item-action bg-light">
            <span><i class="fa fa-user-circle" aria-hidden="true" style="color: #007bff"></i></span>
            Người dùng</a>

        <a href="/v1/admin/roles" class="list-group-item list-group-item-action bg-light">
            <span><i class="fa fa-anchor" aria-hidden="true" style="color: #007bff"></i></span>
            Quyền</a>

        <a href="/v1/admin/pictures?pageNo=1&pageSize=9" class="list-group-item list-group-item-action bg-light">
            <span><i class="fa fa-picture-o" aria-hidden="true" style="color: #007bff"></i></span>
            Ảnh</a>

        </a>

<%--        <a href="/v1/admin/roles" class="list-group-item list-group-item-action bg-light">--%>
<%--            <span><i class="fa fa-building-o" aria-hidden="true" style="color: #007bff"></i></span>--%>
<%--            Báo cáo--%>
<%--        </a>--%>

    </div>
</div>
