package lk.ijse.hibernate.business.custom.impl;

import lk.ijse.hibernate.business.custom.QueryBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.QueryDAO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryBOImpl implements QueryBO {

    QueryDAO qDao = DAOFactory.getInstance().getDao(DAOType.QUERY);

    @Override
    public List<StudentDTO> getCourseWiseStudent(String courseId) throws Exception {
        List<Student> c = qDao.getCourseWiseStudent(courseId);

        ArrayList<StudentDTO> dtoList = new ArrayList<>();
        for(Student s : c){
            dtoList.add(new StudentDTO(
                    s.getId(),
                    s.getStudentName(),
                    s.getAddress(),
                    s.getContact(),
                    s.getDob(),
                    s.getGender()
            ));
        }
        return dtoList;

    }
}
