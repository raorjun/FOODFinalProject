// Main.java
package com.example.expensestracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MoneyMindApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the dashboard FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/expensestracker/dashboard.fxml"));

        // Set up the scene with the loaded FXML

        Scene scene = new Scene(root);

        // Set up the primary stage
        primaryStage.setTitle("Money Mind");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
