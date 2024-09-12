package prospermpuru.studentregistrationapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterPageController {
    @FXML
    private Button signUpBtn;
    @FXML
    private TextField fullNamesTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField studentNumberTextField;
    @FXML
    private TextField courseTextField;
    @FXML
    private PasswordField passwordTextField;

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private void register(ActionEvent event){
        //creates student instance
        Student student = new Student(fullNamesTextField.getText(),
                surnameTextField.getText(),
                Integer.parseInt(studentNumberTextField.getText()),
                courseTextField.getText(),
                passwordTextField.getText()
        );

        //creates logic instance
        Logic logic = new Logic();

        //checks if the student is on the list, if the student is not found on the list then registers else not register
        if (logic.checkRegistered(student)) {
            System.out.println("already registered");
        } else {
            System.out.println("registered");
        }

        //for debugging purposes, list all students
        logic.getList();
    }

    public void switchToHelloScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
