package prospermpuru.studentregistrationapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label welcomeText;

    private Scene scene;
    private Stage stage;
    private Parent root;

<<<<<<< HEAD
<<<<<<< HEAD
    // checks if the pass and stud num is correct
    public void login(ActionEvent event) throws IOException {
        Logic logic = new Logic();
        int studentNum = Integer.parseInt(student_number.getText());

        if (logic.login(password.getText(), studentNum)) {
            student = logic.getStudent();
            switchToProfileScreen(event);
        } else {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Login Error");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("The student number or password you entered is incorrect.");
            alert.showAndWait();
        }
=======
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
>>>>>>> parent of f894385 (Added Registration Logic)
=======
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
>>>>>>> parent of f894385 (Added Registration Logic)
    }


    public void switchToHelloScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}