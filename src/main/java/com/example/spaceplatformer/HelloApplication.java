package com.example.spaceplatformer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("myDesign.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 403, 578);
        stage.setTitle("SpaceGame");
        stage.setScene(scene);
        scene.setOnKeyPressed(e ->{
            if (e.getCode() == KeyCode.A){
                HelloController.A = true;
            }
            if (e.getCode() == KeyCode.D){
                HelloController.D= true;
            }
            if (e.getCode() == KeyCode.W){
                HelloController.W= true;
            }
            if (e.getCode() == KeyCode.S){
                HelloController.S= true;
            }
        });
        scene.setOnKeyReleased(e ->{
            if (e.getCode() == KeyCode.A){
                HelloController.A = false;
            }
            if (e.getCode() == KeyCode.D){
                HelloController.D= false;
            }
            if (e.getCode() == KeyCode.W){
                HelloController.W= false;
            }
            if (e.getCode() == KeyCode.S){
                HelloController.S= false;
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}