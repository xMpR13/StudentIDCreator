package prospermpuru.studentregistrationapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    public SceneManager() {
    }

    public void switch_scene(ActionEvent event, String scene_name, Student student)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene_name));
        Parent root = loader.load();

        /* Get the ProfileView controller and pass the student data by checking the student object is not null */
        if (student != null) {
            ProfileView profileView = loader.getController();
            profileView.setStudent(student);
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
