package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.QueryDAO;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.entity.SuperEntity;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<Student> getCourseWiseStudent(String courseId) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

     /*   NativeQuery sql = session.createSQLQuery("select id, address, contact, dob, gender, studentName from Student" +
                " Join Registration on Student.id = Registration.student_id " +
                " where course_code = ?1");

        sql.setParameter("course_code", courseId);


        List<Student> resultList = (List<Student>) sql.getResultList();*/

        SQLQuery query = session.createSQLQuery("select id, studentName, address, contact, dob, gender from Student Join Registration on Student.id = Registration.student_id  where course_code = ?1");
        query.setParameter(1, courseId);
        List<Student> resultList = (List<Student>) query.getResultList();

        transaction.commit();
        session.close();

        List<Student> studentList = new ArrayList<>();
        Iterator itr = resultList.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String sId = String.valueOf(obj[0]);
            String sName = String.valueOf(obj[1]);
            String sAddress = String.valueOf(obj[2]);
            String sContact = String.valueOf(obj[3]);
            String sDob = String.valueOf(obj[4]);
            String sGender = String.valueOf(obj[5]);
            studentList.add(new Student(sId, sName, sAddress, sContact, sDob, sGender));
        }
        //System.out.println(studentList);
        return studentList;
    }

    @Override
    public boolean add(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Serializable serializable) throws Exception {
        return false;
    }

    @Override
    public SuperEntity find(Serializable serializable) throws Exception {
        return null;
    }

    @Override
    public List getAll() throws Exception {
        return null;
    }
}
