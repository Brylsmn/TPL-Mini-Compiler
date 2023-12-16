package com.tpl_finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FinalProject_TPL extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FinalProject_TPL.class.getResource("TPL-FP.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 887, 498);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Final Project");
        stage.setScene(scene);
        stage.show();
    }
}