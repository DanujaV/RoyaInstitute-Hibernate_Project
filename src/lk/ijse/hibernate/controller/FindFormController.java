package lk.ijse.hibernate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.business.BOFactory;
import lk.ijse.hibernate.business.BOType;
import lk.ijse.hibernate.business.SuperBO;
import lk.ijse.hibernate.business.custom.QueryBO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.view.tm.CourseWiseDetailTM;
import lk.ijse.hibernate.view.tm.StudentTM;

import java.util.List;

public class FindFormController {
    public TextField txtCourseId;
    @FXML
    private TableView<CourseWiseDetailTM> tblDetail;

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

    public void initialize(){
        setCellValueFactory();
    }

    private void setCellValueFactory(){
        colStudentId.setCellValueFactory(new PropertyValueFactory("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory("studentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colDob.setCellValueFactory(new PropertyValueFactory("dob"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));
        colGender.setCellValueFactory(new PropertyValueFactory("gender"));
    }

    @FXML
    void txtCourseIdOnAction(ActionEvent event) {
        try {
            ObservableList<CourseWiseDetailTM> tmList = FXCollections.observableArrayList();
            List<StudentDTO> all = null;
            all = qBo.getCourseWiseStudent(txtCourseId.getText());
            for (StudentDTO dto : all) {
                CourseWiseDetailTM tm = new CourseWiseDetailTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getContact(),
                        dto.getDob(),
                        dto.getGender()
                );
                tmList.add(tm);
            }
            tblDetail.setItems(tmList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
