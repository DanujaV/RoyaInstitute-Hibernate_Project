package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.entity.Student;

import java.util.List;

public interface QueryDAO extends SuperDAO{
    public List<Student> getCourseWiseStudent(String courseId) throws Exception;
}
