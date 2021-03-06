package Student;

import Extra.Archive;
import Extra.Field;
import Extra.Master;
import LoginPage.LoginPageController;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentWeeklyProgramsController implements Initializable {
    public TableView<Person> StudentTableView;
    public TableColumn<Person, String> clmFieldName;
    public TableColumn<Person, String> clmFieldCode;
    public TableColumn<Person, String> clmFieldUnit;
    public TableColumn<Person, String> clmMasterName;
    public TableColumn<Person, String> clmStudentMeetingTime;

    private void setTable() {

        Archive archive = new Archive();
        ObservableList<Person> people = FXCollections.observableArrayList();
        for (Field field : archive.getFieldListForStudent(new LoginPageController().getUserName())) {

        people.add(new Person(field.getFieldName(), field.getFieldNumber() + "", field.getUnit() + "", field.getMaster().getName() + " " + field.getMaster().getLastName(), field.getFirstMeeting() + "\n" + field.getSecondMeeting()));
        }
        clmFieldName.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldName"));
        clmFieldCode.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldCode"));
        clmFieldUnit.setCellValueFactory(new PropertyValueFactory<Person, String>("fieldUnit"));
        clmMasterName.setCellValueFactory(new PropertyValueFactory<Person, String>("masterName"));
        clmStudentMeetingTime.setCellValueFactory(new PropertyValueFactory<Person, String>("studentMeetingTime"));

        StudentTableView.setItems(people);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTable();
    }

}


