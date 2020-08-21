<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:url var="APIurl" value="/v1/api/admin/students"/>
<c:url var="NewURL" value="/v1/web/registers"/>
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

    <h1 style="text-align: center; color: #0069d9;">Information register</h1>

    <br>

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
                         <input type="text" style="width: 300px" class="form-control" name="hoVaTen"
                               required><br>
                    </td>
                    <td>
                        <input type="date" style="width: 250px" class="form-control" name="ngaySinh"
                                required><br>
                    </td>
                    <td>

                        <div class="form-check-inline">
                            <label class="form-check-label">
                                &nbsp <c:forEach items="${genders}" var="item">
                                    <input type="radio" class="form-check-input" name="gioiTinh"
                                           value="${item.id}"> ${item.gioiTinh}&nbsp
                            </c:forEach>

                            </label>
                        </div>
                    </td>
                </tr><br><br>

                <tr>
                    <td>Place of birth</td>
                    <td>Nationality</td>
                    <td>Passport No</td>
                </tr>
                <tr>
                    <td>
                        <input type="text" style="width: 300px" class="form-control" name="noiSinh" required><br>
                    </td>
                    <td>
                        <input type="text" style="width: 250px" class="form-control" name="quocGia" required><br>
                    </td>
                    <td>
                        <input type="text" style="width: 250px" class="form-control" name="soHoChieu"  required><br>
                    </td>

                </tr>
            </table><br><br>

<%--    adress sudent--%>
            <table>
                <b>Contact address in Viet Nam</b><br><br>
                <tr><td colspan="3" >Address</td></tr>
                <tr>
                    <td colspan="3">
                        <input type="text" style="width: 800px" class="form-control" name="diaChi" required>
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
                             required><br>
                    </td>
                    <td>
                        <input type="text" style="width: 250px" class="form-control" name="fax"
                             required><br>
                    </td>
                    <td>
                        <input type="text" style="width: 300px" class="form-control" name="email"
                               required><br>
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
                                   required><br>
                        </td>
                        <td colspan="2" >
                            <input type="text" style="width: 300px" class="form-control" id="addressPersonNotified"
                                   required><br>
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
                                   required><br>
                        </td>
                        <td>
                            <input type="text" style="width: 250px" class="form-control" id="faxPersonNotified"
                                   required><br>
                        </td>
                        <td colspan="2">
                            <input type="text" style="width: 300px" class="form-control" id="emailPersonNotified"
                                   required><br>
                        </td>

                    </tr>
                </table><br><br>

<%--    Family background--%>
            <table>

                   <b>Family background (Farther, mother, brother/sister)</b><br><br>

                    <tr>
                        <td style="width:50px" >Ord</td>
                        <td style=" width:300px">Full name</td>
                        <td style=" width:200px">Relationship</td>
                        <td style=" width:50px">Age</td>
                        <td style=" width:200px">Occupation</td>
                        <td style=" width:300px">Address</td>
                    </tr>
                    <c:forEach begin="1" end="3" var="i">
                        <tr>
                            <td style="width: 50px" >${i}</td>
                            <td>
                                <input type="text" style="width: 300px" class="form-control" id="namePersonRelative${i}"
                                       required><br>
                            </td>
                            <td>
                                <input type="text" style="width: 200px" class="form-control" id="nameRelative${i}"
                                       required><br>
                            </td>
                            <td>
                                <input type="text" style="width: 50px" class="form-control" id="agePersonRelative${i}"
                                       required><br>
                            </td>
                            <td>
                                <input type="text" style="width: 200px" class="form-control" id="occupationPersonRelative${i}"
                                       required><br>
                            </td>
                            <td>
                                <input type="text" style="width: 300px" class="form-control" id="addressPersonRelative${i}"
                                       required><br>
                            </td>
                        </tr>
                    </c:forEach>

                </table><br><br>

<%--    School profile--%>
            <table>
                    <b>School profile</b>
                    <tr>
                        <td style="width: 350px">Name of high school you graduated</td>
                        <td style="width: 250px">Year of graduattion</td>
                        <td style="width: 250px">Classification</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" style="width: 350px" class="form-control" id="truongTHPT"
                                   required><br>
                        </td>
                        <td>
                            <input type="text" style="width: 250px" class="form-control" id="namTotNghiep"
                                   required><br>
                        </td>
                        <td>
                            <input type="text" style="width: 250px" class="form-control" id="xepLoai"
                                   required><br>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Special Results(if any)
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="text" style="width: 850px" class="form-control" id="thanhTichDacBiet" required><br>
                        </td>
                    </tr>

                </table><br><br>

<%--    Foreign language profiles--%>
            <table>
                    <b> Foreign language profiles </b><br><br>
                    <tr>
                        <td style="width: 50px" >Ord</td>
                        <td style="width: 250px">Languages</td>
                        <td style="width: 150px">Listening</td>
                        <td style="width: 150px">Reading</td>
                        <td style="width: 150px">Writing</td>
                        <td style="width: 150px">Speaking</td>
                    </tr>
                    <tr>
                        <td style="width: 50px">1</td>
                        <td>

                            <label>VietNamese</label>
                            <input type="hidden" style="width: 250px" class="form-control" id="ngonNgu1" value="VietNamese" readonly>
                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoNghe1">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>
                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"

                                    class="form-control" id="trinhDoDoc1">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>
                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"

                                    class="form-control" id="trinhDoViet1">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>
                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoNoi1">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>

                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50px">2</td>
                        <td>
                            <label>English</label>
                            <input type="hidden" style="width: 250px" class="form-control" id="ngonNgu2" value="English" readonly>

                        </td>
                        <td>

                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoNghe2">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>
                        </td>
                        <td>


                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoDoc2">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>
                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoViet2">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>

                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoNoi2">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50px">3</td>
                        <td>
                            <input type="text" style="width: 250px; height: 35px;" class="form-control" id="ngonNgu3"><br>
                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoNghe3">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>

                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoDoc3">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>
                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoViet3">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>

                        </td>
                        <td>
                            <select style="
                                        width:200px;
                                        height:35px;
                                        font-size: medium"
                                    class="form-control" id="trinhDoNoi3">
                                <option></option>
                                <c:forEach var="item" items="${languageLevels}">
                                    <option value="${item.ID}">${item.trinhDo} </option>
                                </c:forEach>
                            </select><br>
                        </td>
                    </tr>
                </table><br><br>

<%--    School register--%>
            <table>
                    <b>School register</b><br>
                    <tr>
                        <td>System training</td>
                        <td>Course</td>
                    </tr>
                    <tr>
                        <td>
                            <select style="
                                        width:250px;
                                        height:40px;
                                        font-size: medium;"
                                    name="heDaoTao"
                                    class="form-control" >
                                <c:forEach var="item" items="${trainningTypes}">
                                    <option value="${item.ID}">${item.tenHeDaoTao} </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select style="
                                        width:500px;
                                        height:40px;
                                        font-size: medium;"
                                    name="maKhoaHoc"
                                    class="form-control" >
                                <c:forEach var="item" items="${courses}">
                                    <option value="${item.id}">${item.tenKhoaHoc} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                <br>
                    <tr>
                        <td>Acedemic years</td>
                        <td>Branch</td>
                    </tr><br>
                    <tr>
                        <td>
                            <input type="text" style="width: 250px" class="form-control" name="nienKhoa" >
                        </td>
                        <td>
                            <select style="
                                        width:500px;
                                        height:40px;
                                        font-size: medium"
                                    name="noiHoc"
                                    class="form-control" >

                                <c:forEach var="item" items="${branchs}">
                                    <option value="${item.tenCoSo}">${item.tenCoSo} </option>
                                </c:forEach>
                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td>Applicant's category</td>
                        <td>Budget</td>
                    </tr>
                    <tr>
                        <td>
                            <select style="
                                        width:250px;
                                        height:40px;
                                        font-size:medium;"
                                    name="doiTuongUuTien"
                                    class="form-control" >
                                <c:forEach var="item" items="${priorities}">
                                    <option value="${item.ID}">${item.loaiUuTien} </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select style="
                                        width:250px;
                                        height:40px;
                                        font-size: medium;"
                                    name="loaiHocBong"
                                    class="form-control" >
                                <c:forEach var="item" items="${scholarships}">
                                    <option value="${item.ID}">${item.loaiHocBong} </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                </table><br>

        <button id = "btnAddOrUpdateAcc" style="width:120px" type="button" class="btn btn-primary">Register</button>
        <button style="width: 100px" type="reset" class="btn btn-secondary">Hủy bỏ</button>
    <br><br>

        </form>
    </div>
</div>
<script src="<c:url value='/template/admin/jquery/jquery.min.js' />"></script>

<script>
    //giong nhu ham main cua 1 chuongtrinh java nhung ham trong (document).ready()
    // se chay trc khi load trang sau do moi chay toi cac ham khac

    function setDataLanguages(){
        var ngoaiNguList =[];
        for(i=1; i<4;i++){
            var nameLanguage = $('#ngonNgu'+i).val();
            if (nameLanguage != null && nameLanguage != "") {
                var ngonNgu = {};
                ngonNgu["tenNgoaiNgu"] = $('#ngonNgu'+i).val();
                ngonNgu["trinhDoNghe"] = $('#trinhDoNghe'+i).val();//cong i de tao ra dc id chinh xac
                ngonNgu["trinhDoNoi"] = $('#trinhDoNoi'+i).val();
                ngonNgu["trinhDoDoc"] = $('#trinhDoDoc'+i).val();
                ngonNgu["trinhDoViet"] = $('#trinhDoViet'+i).val();
                ngoaiNguList[i-1] = ngonNgu;
            }

        }
        return ngoaiNguList;
    };

    function setDataPersonRelative(){
        var persons =[];
        for(i=1; i<4;i++){
            var name = $('#namePersonRelative'+i).val();
            if (name != null && name != "") {
                var person = {};
                person["hoVaTen"] = $('#namePersonRelative'+i).val();
                person['quanHe'] = $('#nameRelative'+i).val();
                person['tuoi'] = $('#agePersonRelative'+i).val();
                person['ngheNghiep'] = $('#occupationPersonRelative'+i).val();
                person['diaChi'] = $('#addressPersonRelative'+i).val();
                persons[i-1] = person;
            }

        }
        return persons;
    };


    $('#btnAddOrUpdateAcc').click(function (e) {

        e.preventDefault();//de tranh submit nham vao URL mac dinh

        var nguoiLienHeKhanCap = {
            ten:$('#namePersonNotified').val(),
            diaChi:$('#addressPersonNotified').val(),
            fax:$('#faxPersonNotified').val(),
            email:$('#emailPersonNotified').val(),
            soDienThoai:$('#phonePersonNotified').val()
        };

        var thanhTichHocTap = {
            truongTHPT:$('#truongTHPT').val(),
            namTotNghiep:$('#namTotNghiep').val(),
            xepLoai:$('#xepLoai').val(),
            thanhTichDacBiet:$('#thanhTichDacBiet').val()
        };

        var listThanNhan = setDataPersonRelative();

        var ngoaiNguList = setDataLanguages();

        var data = {};//khoi tao 1 mang chua du lieu

        var formData = $('#formSubmit').serializeArray(); //lay tuan tu gia trong form theo ten (name)
                                                    // da dat theo dang array roi chuyen vao bien formdata

        $.each(formData, function (i, v) { //su dung vong for trong jquery gom 3 tham so lan luot la listData,
                                            // function( vi tri, gia tri)
            console.log(v); //lenh in ra man hinh console tren web

            data["" + v.name + ""] = v.value;//gan gia tri cho mang data de gửi về sever
        });

        data['nguoiLienHeKhanCap'] = nguoiLienHeKhanCap;
        data['thanhTichHocTap'] = thanhTichHocTap;
        data['listThanNhan'] = listThanNhan;
        data['ngoaiNguList'] = ngoaiNguList;
        console.log(data);
        addAcc(data);

    });

    function addAcc(data) {

        $.ajax({

            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data),

            dataType: 'json',
            success: function (result) {
                console.log(data);
                alert("Register successful!");
                window.location.href = "/v1/web";
            },
            error: function (error) {
                console.log(data);
                alert("Register fail!\n" );
                <%--window.location.href = "${NewURL}";--%>
            }
        });
    }
</script>
</body>
</html>
