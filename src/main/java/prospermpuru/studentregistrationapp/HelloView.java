package prospermpuru.studentregistrationapp;

import javafx.event.ActionEvent;

import java.io.IOException;

public class HelloView {
    SceneManager sceneManager = new SceneManager();

    public void switchToLoginScreen(ActionEvent event) throws IOException {
        sceneManager.switch_scene(event, "login-view.fxml", null);
    }

    public void switchToRegisterScreen(ActionEvent event) throws IOException {
        sceneManager.switch_scene(event, "register-view.fxml", null);
    }
}
