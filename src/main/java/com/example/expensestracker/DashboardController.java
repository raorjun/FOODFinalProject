package com.example.expensestracker;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class DashboardController {
    @FXML
    private void handleViewIncome(ActionEvent event) {
        Hardware.playButtonSoundEffect();
        loadScene(event, "/com/example/expensestracker/viewIncome.fxml");
    }

    @FXML
    private void handleViewExpenses(ActionEvent event) {
        Hardware.playButtonSoundEffect();
        loadScene(event, "/com/example/expensestracker/viewExpenses.fxml");
    }

    @FXML
    private void handleAddIncome(ActionEvent event) {
        Hardware.playButtonSoundEffect();
        loadScene(event, "/com/example/expensestracker/addIncome.fxml");
    }

    @FXML
    private void handleAddExpenses(ActionEvent event) {
        Hardware.playButtonSoundEffect();
        loadScene(event, "/com/example/expensestracker/addExpense.fxml");
    }

    @FXML
    private void loadScene(ActionEvent event, String fxmlFile) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene scene = new Scene(parent);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

