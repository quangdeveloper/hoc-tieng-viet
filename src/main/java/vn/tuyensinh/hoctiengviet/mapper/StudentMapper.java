package vn.tuyensinh.hoctiengviet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vn.tuyensinh.hoctiengviet.dto.StudentDTO;
import vn.tuyensinh.hoctiengviet.entity.SinhVienDangKi;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mappings({
            @Mapping(target = "id",source = "ID"),
            @Mapping(target = "fullName",source = "hoVaTen"),
            @Mapping(target = "gender",source = "gioiTinh.gioiTinh"),
            @Mapping(target = "dateOfBirth",source = "ngaySinh", qualifiedByName = "toLoCalDateFromTimeStamp"),
            @Mapping(target = "national",source = "quocGia"),
            @Mapping(target = "placeLearn",source = "noiHoc" ),
            @Mapping(target = "priority",source = "doiTuongUuTien.loaiUuTien"),
            @Mapping(target = "scholarship",source = "loaiHocBong.loaiHocBong")
    })
    StudentDTO toStudentDTOFromStudent(SinhVienDangKi s);
    List<StudentDTO> toStudentDTOFromStudents(List<SinhVienDangKi> s);
}
