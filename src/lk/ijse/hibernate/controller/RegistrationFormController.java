package lk.ijse.hibernate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.business.BOFactory;
import lk.ijse.hibernate.business.BOType;
import lk.ijse.hibernate.business.custom.CourseBO;
import lk.ijse.hibernate.business.custom.StudentBO;
import lk.ijse.hibernate.dto.StudentDTO;

import java.util.ArrayList;

public class RegistrationFormController {
    public TextField txtStudentId;
    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtRegistrationId;

    @FXML
    private TextField txtRegistrationFee;

    @FXML
    private ComboBox<String> cmbCourse;

  /*  StudentDAOImpl sDaoImpl = DAOFactory.getInstance().getDao(DAOType.STUDENT);*/
    StudentBO bo = BOFactory.getInstance().getBO(BOType.STUDENT);
    CourseBO boCourse = BOFactory.getInstance().getBO(BOType.COURSE);


    public void initialize(){
        getCourses();
    }

    public void getCourses(){
       /* try {
            List<String> courseName = boCourse.getCourseName();
            for (String s : courseName) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            ArrayList<String> name = (ArrayList<String>) boCourse.getCourseName();
            for(String s : name){
                obList.add(s);
            }
            cmbCourse.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

    }

    @FXML
    void txtStudentIdOnAction(ActionEvent event) {
        String id = txtStudentId.getText();
        try {
            StudentDTO dto = bo.find(id);
            txtStudentName.setText(dto.getName());
            txtAddress.setText(dto.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
