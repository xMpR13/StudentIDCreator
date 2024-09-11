module prospermpuru.studentregistrationapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens prospermpuru.studentregistrationapp to javafx.fxml;
    exports prospermpuru.studentregistrationapp;
}