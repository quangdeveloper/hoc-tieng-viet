<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:url var="URL" value="/v1/admin/students?pageNo=1&pageSize=10"/>
<html>
<head>

    <style type="text/css">
        .containnner {

        }

        .form-control {
            width: 250px;
        }
    </style>
</head>
<body>
<div><br><br>

    <h1 style="text-align: center; color: #0069d9;">Information applicant</h1>


    <div class="containnner" style=" margin-left: 50px;
            margin-top: 30px;">

        <form id="formSubmit">
<%--    info basic--%>
            <table>
                <tr>
                    <td>Full name</td>
                    <td>Date of birth</td>
                    <td> &nbsp Gender</td>
                </tr>
                <tr>
                    <td>
                         <input type="text" style="width: 300px" class="form-control" name="hoVaTen" value="${obj.hoVaTen}"
                               readonly><br>
                    </td>
                    <td>
                        <input type="text" style="width: 250px" class="form-control" name="ngaySinh" value="${obj.ngaySinh}"
                                readonly><br>
                    </td>
                    <td>
                        <input type="text" style="width: 250px" class="form-control" name="ngaySinh" value="${obj.gioiTinh.gioiTinh}"
                               readonly><br>
                    </td>
                </tr><br><br>

                <tr>
                    <td>Place of birth</td>
                    <td>Nationality</td>
                    <td>Passport No</td>
                </tr>
                <tr>
                    <td>
                        <input type="text" style="width: 300px" class="form-control" name="noiSinh" value="${obj.noiSinh}" readonly><br>
                    </td>
                    <td>
                        <input type="text" style="width: 250px" class="form-control" name="quocGia" value="${obj.quocGia}" readonly><br>
                    </td>
                    <td>
                        <input type="text" style="width: 250px" class="form-control" name="soHoChieu"  value="${obj.soHoChieu}" readonly><br>
                    </td>

                </tr>
            </table><br><br>

<%--    adress sudent--%>
            <table>
                <b>Contact address in Viet Nam</b><br><br>
                <tr><td colspan="3" >Address</td></tr>
                <tr>
                    <td colspan="3">
                        <input type="text" style="width: 800px" class="form-control" name="diaChi" value="${obj.diaChi}" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td>Fax</td>
                    <td>Email</td>
                </tr>
                <tr>
                    <td>
                        <input type="text" style="width: 250px" class="form-control" name="soDienThoai"
                               value="${obj.soDienThoai}" readonly><br>
                    </td>
                    <td>
                        <input type="text" style="width: 250px" class="form-control" name="fax"
                               value="${obj.fax}" readonly><br>
                    </td>
                    <td>
                        <input type="text" style="width: 300px" class="form-control" name="email"
                               value="${obj.email}" readonly><br>
                    </td>
                </tr>
            </table><br><br>

<%--    person notified--%>

            <table>
                <b>Person to notified,in case emergency</b><br><br>
                    <tr>
                        <td colspan="2">Name in full</td>
                        <td colspan="2">Address</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="text" style="width: 500px" class="form-control" id="namePersonNotified"
                                   value="${obj_nguoiLienHe.ten}" readonly><br>
                        </td>
                        <td colspan="2" >
                            <input type="text" style="width: 300px" class="form-control" id="addressPersonNotified"
                                   value="${obj_nguoiLienHe.diaChi}" readonly><br>
                        </td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td>Fax</td>
                        <td colspan="2">Email</td>

                    </tr>
                    <tr>
                        <td>
                            <input type="text" style="width: 250px" class="form-control" id="phonePersonNotified"
                                   value="${obj_nguoiLienHe.soDienThoai}" readonly><br>
                        </td>
                        <td>
                            <input type="text" style="width: 250px" class="form-control" id="faxPersonNotified"
                                   value="${obj_nguoiLienHe.fax}" readonly><br>
                        </td>
                        <td colspan="2">
                            <input type="text" style="width: 300px" class="form-control" id="emailPersonNotified"
                                   value="${obj_nguoiLienHe.email}" readonly><br>
                        </td>

                    </tr>
                </table><br><br>

<%--    Family background--%>
            <table>

                   <b>Family background (Farther, mother, brother/sister)</b><br><br>

                    <tr>
                        <td style=" width:300px">Full name</td>
                        <td style=" width:200px">Relationship</td>
                        <td style=" width:50px">Age</td>
                        <td style=" width:200px">Occupation</td>
                        <td style=" width:300px">Address</td>
                    </tr>
                    <c:forEach var="item" items="${obj.thanNhanList}">
                        <tr>

                            <td>
                                <input type="text" style="width: 300px" class="form-control"  value="${item.hoVaTen}"
                                       readonly><br>
                            </td>
                            <td>
                                <input type="text" style="width: 200px" class="form-control" value="${item.quanHe}"
                                       readonly><br>
                            </td>
                            <td>
                                <input type="text" style="width: 50px" class="form-control" value="${item.tuoi}"
                                       readonly><br>
                            </td>
                            <td>
                                <input type="text" style="width: 200px" class="form-control" value="${item.ngheNghiep}"
                                       readonly><br>
                            </td>
                            <td>
                                <input type="text" style="width: 300px" class="form-control" value="${item.diaChi}"
                                       readonly><br>
                            </td>
                        </tr>
                    </c:forEach>

                </table><br><br>

<%--    School profile--%>
            <table>
                    <b>School profile</b><br>
                    <tr>
                        <td style="width: 350px">Name of high school you graduated</td>
                        <td style="width: 250px">Year of graduattion</td>
                        <td style="width: 250px">Classification</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" style="width: 350px" class="form-control" id="truongTHPT"
                                   value="${obj_thanhTich.truongTHPT}" readonly><br>
                        </td>
                        <td>
                            <input type="text" style="width: 250px" class="form-control" id="namTotNghiep"
                                   value="${obj_thanhTich.namTotNghiep}" readonly><br>
                        </td>
                        <td>
                            <input type="text" style="width: 250px" class="form-control" id="xepLoai"
                                   value="${obj_thanhTich.xepLoai}" readonly><br>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Special Results(if any)
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input readonly type="text" style="width: 850px" class="form-control" id="thanhTichDacBiet" value="${obj_thanhTich.thanhTichDacBiet}"><br>
                        </td>
                    </tr>

                </table><br><br>

<%--    Foreign language profiles--%>
            <table>
                    <b> Foreign language profiles </b><br><br>
                    <tr>
                        <td style="width: 200px">Languages</td>
                        <td style="width: 150px">Listening</td>
                        <td style="width: 150px">Reading</td>
                        <td style="width: 150px">Writing</td>
                        <td style="width: 150px">Speaking</td>
                    </tr>
                    <c:forEach var="i" items="${obj.ngoaiNguList}">
                        <tr>
                            <td>

                                <input type="text" style="width: 200px" class="form-control" value="${i.tenNgoaiNgu}" readonly>
                            </td>
                            <td>
                                <c:forEach items="${languageLevels}" var="j">
                                    <c:if test="${i.trinhDoNghe == j.ID}">
                                        <input type="text" style="width: 200px" class="form-control" value="${j.trinhDo}" readonly>
                                    </c:if>
                                </c:forEach>

                            </td>
                            <td>
                                <c:forEach items="${languageLevels}" var="j">
                                    <c:if test="${i.trinhDoDoc == j.ID}">
                                        <input type="text" style="width: 200px" class="form-control" value="${j.trinhDo}" readonly>
                                    </c:if>
                                </c:forEach>

                            </td>
                            <td>
                                <c:forEach items="${languageLevels}" var="j">
                                    <c:if test="${i.trinhDoViet == j.ID}">
                                        <input type="text" style="width: 200px" class="form-control" value="${j.trinhDo}" readonly>
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach items="${languageLevels}" var="j">
                                    <c:if test="${i.trinhDoNoi == j.ID}">
                                        <input type="text" style="width: 200px" class="form-control" value="${j.trinhDo}" readonly>
                                    </c:if>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
            </table><br><br>

<%--        School register--%>
    <table>
        <b>School register</b><br>
        <tr>
            <td>System training</td>
            <td>Course</td>
        </tr>
        <tr>
            <td>
                <input class="form-control" type="text" style="width: 250px; height: 40px" value="${obj.heDaoTao.tenHeDaoTao}" readonly>
            </td>
            <c:forEach items="${obj.khoaHocList}" var="i">
                <td>
                    <input class="form-control" type="text" style="width: 500px; height: 40px" value="${i.tenKhoaHoc}" readonly>
                </td>
            </c:forEach>
        </tr>
        <br>
        <tr>
            <td>Acedemic years</td>
            <td>Branch</td>
        </tr><br>
        <tr>
            <td>
                <input type="text" style="width: 250px" class="form-control" name="nienKhoa" value="${obj.nienKhoa}" readonly>
            </td>
            <td>
                <input type="text" style="width: 500px" class="form-control" value="${obj.noiHoc}" readonly>

            </td>

        </tr>
        <tr>
            <td>Applicant's category</td>
            <td>Budget</td>
        </tr>
        <tr>
            <td>
                <input class="form-control" type="text" readonly style="width: 250px; height: 40px;" value="${obj.doiTuongUuTien.loaiUuTien}">
            </td>
            <td>
                <input class="form-control" type="text" readonly style="width: 250px; height: 40px;" value="${obj.loaiHocBong.loaiHocBong}">

            </td>
        </tr>
    </table><br>

    <br><br>
    <a title="Edit" href="${URL}">
        <button style="width: 120px;" type="button" class="btn btn-primary">Back
        </button>
    </a>

        </form>
    </div>
</div>
</body>
</html>
