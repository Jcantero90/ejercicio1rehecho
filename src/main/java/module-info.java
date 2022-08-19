module com.example.lecturadeficherosyfiltradosstream {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lecturadeficherosyfiltradosstream to javafx.fxml;
    exports com.example.lecturadeficherosyfiltradosstream;
}