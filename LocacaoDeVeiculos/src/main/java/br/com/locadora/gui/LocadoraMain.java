package br.com.locadora.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LocadoraMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        window.setTitle("Locar veículos");
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 660, 341);
        window.setScene(scene);
        window.show();
    }
}
