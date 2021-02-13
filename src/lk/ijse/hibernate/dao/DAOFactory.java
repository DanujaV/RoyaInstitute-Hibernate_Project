package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hibernate.entity.Student;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO>T getDao(DAOType daoType){
        switch (daoType){
            case STUDENT:
                return (T) new StudentDAOImpl();
            default:
                return null;
        }
    }
}
