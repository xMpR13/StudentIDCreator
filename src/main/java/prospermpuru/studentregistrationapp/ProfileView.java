package prospermpuru.studentregistrationapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileView implements Initializable {


    @FXML
    private Text res;
    @FXML
    private Text name;
    @FXML
    private Text stud_number;
    @FXML
    private Text course_name;

    private Student student;

    private Scene scene;
    private Stage stage;
    private Parent root;

    // Setter method to receive the Student object
    public void setStudent(Student student) {
        this.student = student;
        System.out.println("========>" + student.getName());
        res.setText(student.getResName());
        name.setText(student.getName().toUpperCase().substring(0,1) + " " + student.getSurname().toUpperCase());
        course_name.setText(student.getCourseName().toUpperCase());
        stud_number.setText(String.valueOf(student.getStudentNumber()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Ensure student is not null before setting the label
        if (student != null) {
            res.setText(student.getResName());
        }
    }

    public void switchToHelloScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}