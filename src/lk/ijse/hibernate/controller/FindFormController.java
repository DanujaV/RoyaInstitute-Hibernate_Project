package lk.ijse.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.business.BOFactory;
import lk.ijse.hibernate.business.BOType;
import lk.ijse.hibernate.business.SuperBO;
import lk.ijse.hibernate.business.custom.QueryBO;
import lk.ijse.hibernate.dto.StudentDTO;

import java.util.List;

public class FindFormController {
    public TextField txtCourseId;
    @FXML
    private TableView<?> tblDetail;

    @FXML
    private TableColumn<?, ?> colStudentId;

    @FXML
    private TableColumn<?, ?> colStudentName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colGender;

    QueryBO qBo = BOFactory.getInstance().getBO(BOType.QUERY);

    @FXML
    void txtCourseIdOnAction(ActionEvent event) {
        try {
            List<StudentDTO> courseWiseStudent = qBo.getCourseWiseStudent(txtCourseId.getText());
            for (StudentDTO dto : courseWiseStudent) {
                System.out.println(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
