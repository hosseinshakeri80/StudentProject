package Student;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class StudentController {
    public JFXButton btnBack;
    public JFXButton btnExit;
    public JFXButton btnStudentPersonalInfo;
    public JFXButton btnStudentWeeklyPrograms;
    public AnchorPane StudentMainAnchorPane;

    public  void loadStudentPersonalInfo(){

        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("./FXML/StudentPersonalInfoFXML.fxml"));
            StudentMainAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
            ex.printStackTrace();
        }
    }


    public void loadStudentWeeklyProgram(){

        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("./FXML/StudentWeeklyProgramsFXML.fxml"));
            StudentMainAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
            ex.printStackTrace();
        }
    }

    public void exit() {

        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا میخواهید خارج شوید؟ ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("اخطار");
        alert.setHeaderText(null);
        ButtonType yes = new ButtonType("بله");
        ButtonType no = new ButtonType("خیر");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent())
            if (result.get() == yes)
                System.exit(0);
    }

    public void back() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "آیا می خواهید به صفحه اصلی برگردید؟ ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("اخطار");
        alert.setHeaderText(null);
        ButtonType yes = new ButtonType("بله");
        ButtonType no = new ButtonType("خیر");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == yes) {

                Parent root;
                try {
                    Stage stage = (Stage) btnBack.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../LoginPage/LoginPage.fxml"));
                    root = loader.load();
                    stage = new Stage();
                    Stage finalStage = stage;
                    finalStage.setResizable(false);
                    finalStage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(new Scene(root, 837, 473));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

    }

}
