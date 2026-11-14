package com.olf.system;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Octaviolf
 */
public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        stage.setTitle("GrandStay | Gestión hotelera");
        stage.setMinWidth(980);
        stage.setMinHeight(640);
        show("LoginView.fxml", 1100, 720);
        stage.show();
    }

    public static void show(String view, double width, double height) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/com/olf/view/" + view));
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
