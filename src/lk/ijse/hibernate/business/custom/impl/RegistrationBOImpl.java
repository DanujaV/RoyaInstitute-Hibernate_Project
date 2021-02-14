package lk.ijse.hibernate.business.custom.impl;

import lk.ijse.hibernate.business.custom.RegistrationBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.DAOType;
import lk.ijse.hibernate.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hibernate.dto.RegistrationDTO;
import lk.ijse.hibernate.entity.Registration;

public class RegistrationBOImpl implements RegistrationBO {

    RegistrationDAOImpl daoImpl = DAOFactory.getInstance().getDao(DAOType.REGISTRATION);

    @Override
    public boolean save(RegistrationDTO dto) throws Exception {
        return daoImpl.add(new Registration(
                dto.getRegNo(),
                dto.getRegDate(),
                dto.getRegFee(),
                dto.getStudentId(),
                dto.getCourseCode()
        ));
    }
}
