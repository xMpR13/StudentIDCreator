package prospermpuru.studentregistrationapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterPageController implements Initializable {
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

    @FXML
    private ComboBox<String> comboBox;

    private Scene scene;
    private Stage stage;
    private Parent root;
    private String resName;
    private String[] reses = {"SOSH 1", "SOSH 2", "SOSH 3", "SOSH 4", "SOSH 5", "OFF CAMPUS"};
    private Student student;

    public RegisterPageController() {
    }

    @FXML
    private void register(ActionEvent event) throws IOException {
        //creates student instance
        student = new Student(fullNamesTextField.getText(),
                surnameTextField.getText(),
                Integer.parseInt(studentNumberTextField.getText()),
                courseTextField.getText(),
                passwordTextField.getText(),
                resName
        );

        System.out.println(resName);

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
        switchToProfileScreen(event);
    }

    //gets a res name from the combo box
    public void getResName(ActionEvent event){
        resName = comboBox.getValue();
    }


    public void switchToHelloScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll(reses);
        comboBox.setOnAction(this::getResName);
    }

    public Student getStudent() {
        return student;
    }
}
