package vn.tuyensinh.hoctiengviet.util;

public interface Constant {

    interface Common {
        int PAGE_SIZE = 10;
        int PAGE_NUM = 1;
    }

    interface Value {
        Integer INTEGER_NULL = 0;
        Integer INTEGER_EMPTY = 0;
        String STRING_EMPTY = "NOT_INFO";
        String STRING_NULL = "NO_INFO";

    }

    interface Date {
        String DATE_DEFAULT = "1970-01-01";
    }


    interface RESPONSE {

        interface CODE {

            String C200 = "200";
            String C204 = "204";
            String C404 = "404";
            String C405 = "405";
            String C409 = "409";
            String C600 = "600";


        }

        interface MESSAGE {

            String C200 = "Thực hiện thành công";
            String C204 = "Thêm mới thành công";

            String C404 = "Không tìm thấy tài nguyên";
            String C404_CATEGORY_COURSE = "Không tìm thấy danh mục khóa học";
            String C404_PICTURE = "Không tìm thấy ảnh";
            String C404_NEWS = "Không tìm thấy bài viết";
            String C404_STUDENT = "Không tìm thấy Sinh viên";
            String C404_ACCOUNT = "Không tìm thấy tài khoản";
            String C404_COURSE = "Không tìm thấy khóa học";
            String C404_ROLE = "Không tìm thấy quyền";
            String C404_GROUP_ROLE = "Không tìm thấy nhóm quyền";
            String C404_LECTURE = "Không tìm thấy giảng viên";
            String C404_CATEGORY_NEW = "Không tìm thấy danh mục";



            String C405 = "Dữ liệu đầu vào không hợp lệ";

            String C409 = "Dữ liệu đã tồn tai";
            String C409_STUDENT = "Sinh viên đã tồn tại ";
            String C409_ACCOUNT = "Tài khoản đã tồn tại ";
            String C409_COURSE = "Khóa học đã tồn tại ";
            String C409_ROLE = "Quyền đã tồn tại";
            String C409_LECTURE = "Giảng viên đã tồn tại ";
            String C409_CATEGORY_NEW = "Danh mục bài viết đã tồn tại";

            String C600 = "Không thể xóa thông tin là khóa ngoại";

        }

        interface JSON_VALUE {
            String VALUE_RETURN = "VALUE_RETURN";
        }
    }


    interface EXCEPTION_MESSAGE {
        String C404 = "Not found exception";
        String C405 = "Not exists exception";
        String C600 = "Can't delete when something using sources";
    }

    interface DATE_FORMAT {
        String DD_MM_YYYY = "dd/MM/yyyy";
        String DD_MM_YYYY_TIME = "dd/MM/yyyy HH:mm";
        String HOUR = "HH:mm";
        String DD_MM_YYYY_PATTERN = "\\d\\d/\\d\\d\\/\\d\\d\\d\\d";
        String DD_MM_YYYY_2 = "d/M/yyyy";
        String TIME_STAMP = "dd/MM/yyyy HH:mm:ss.mmmm";
    }

    interface CODE {
        String C404 = "C404";
        String C405 = "C405";
        String C600 = "C600";

    }


}
