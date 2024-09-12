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

    // Setter method to receive the Student object
    public void setStudent(Student student) {
        this.student = student;

        /*
        if (student.getCourseName().equalsIgnoreCase("Computer Systems Engineering")) {
            course_name.setS
        }*/
        res.setText(student.getResName());
        name.setText(student.getName().toUpperCase().charAt(0) + " " + student.getSurname().toUpperCase());
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
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}