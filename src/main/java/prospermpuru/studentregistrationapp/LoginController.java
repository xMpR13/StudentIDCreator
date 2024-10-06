package prospermpuru.studentregistrationapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField password;
    @FXML
    private TextField student_number;


    private Student student = null;
    SceneManager sceneManager = new SceneManager();

    // checks if the pass and stud num is correct
    public void login(ActionEvent event) throws IOException {
        Logic logic = new Logic();
        int studentNum = Integer.parseInt(student_number.getText());

        if (logic.login(password.getText(), studentNum)) {
            student = logic.getStudent();
            switchToProfileScreen(event);
            System.out.println("Logged in");
        } else {
            logic.error_pop_up("Login Error", "Invalid Credentials", "The student number or password you entered is incorrect.");
        }
    }

    public void switchToHelloScreen(ActionEvent event) throws IOException {
        sceneManager.switch_scene(event, "hello-view.fxml", student);
    }

    public void switchToRegisterScreen(ActionEvent event) throws IOException {
        sceneManager.switch_scene(event, "register-view.fxml", student);
    }

    public void switchToProfileScreen(ActionEvent event) throws IOException {
        sceneManager.switch_scene(event, "profile-view.fxml", student);
    }
}