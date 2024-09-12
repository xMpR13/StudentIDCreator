package prospermpuru.studentregistrationapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField password;
    @FXML
    private TextField student_number;

    private Scene scene;
    private Stage stage;
    private Parent root;
    private final Alert alert = new Alert(Alert.AlertType.NONE);
    private Student student = null;

    // checks if the pass and stud num is correct
    public void login(ActionEvent event) throws IOException {
        Logic logic = new Logic();
        int studentNum = Integer.parseInt(student_number.getText());

        if (logic.login(password.getText(), studentNum)) {
            student = logic.getStudent();
            switchToProfileScreen(event);
            System.out.println("Logged in");
        } else {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("The student number or password you entered is incorrect.");
            alert.showAndWait();
        }
    }

    public void switchToHelloScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRegisterScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("register-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToProfileScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profile-view.fxml"));
        Parent root = loader.load();

        // Get the ProfileView controller and pass the student data
        ProfileView profileView = loader.getController();
        profileView.setStudent(student);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}