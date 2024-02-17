package com.clovdev.myparking;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Factory {

    public static void showStage(String source) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(""+source+".fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
    // stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
    public static void closeStage(Event event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
