module com.clovdev.myparkingv1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires jasperreports;

    opens com.clovdev.myparking to javafx.fxml;
    exports com.clovdev.myparking;
    exports com.clovdev.myparking.Dao;
    opens com.clovdev.myparking.Dao to javafx.fxml;
    exports com.clovdev.myparking.models;
    opens com.clovdev.myparking.models to javafx.fxml;
    exports com.clovdev.myparking.Controller;
    opens com.clovdev.myparking.Controller to javafx.fxml;
}