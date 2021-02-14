package lk.ijse.hibernate.business.custom;

import lk.ijse.hibernate.business.SuperBO;
import lk.ijse.hibernate.dto.StudentDTO;

import java.util.List;

public interface QueryBO extends SuperBO {
    public List<StudentDTO> getCourseWiseStudent(String courseId) throws Exception;
}
