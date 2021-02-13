package lk.ijse.hibernate.business;

import lk.ijse.hibernate.business.custom.impl.StudentBOImpl;
import net.bytebuddy.implementation.bind.annotation.Super;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance() {
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO>T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            default:
                return null;
        }
    }

}
