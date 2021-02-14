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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    StudentBO bo = BOFactory.getInstance().getBO(BOType.STUDENT);
    CourseBO boCourse = BOFactory.getInstance().getBO(BOType.COURSE);

    public void initialize(){
        getCourses();
    }

    public void getCourses(){
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String date = dtf.format(now);
        String regId = txtRegistrationId.getText();
        String regFee = txtRegistrationFee.getText();
        String studentID = txtStudentId.getText();
        String courseCode = String.valueOf(cmbCourse.getValue());

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
