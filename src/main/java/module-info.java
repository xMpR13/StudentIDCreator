module prospermpuru.studentregistrationapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens prospermpuru.studentregistrationapp to javafx.fxml;
    exports prospermpuru.studentregistrationapp;
}