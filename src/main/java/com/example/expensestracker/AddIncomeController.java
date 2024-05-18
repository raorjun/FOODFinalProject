package com.example.expensestracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
public class AddIncomeController {

    @FXML
    private TextField monthTextField;

    @FXML
    private TextField amountTextField;

    private static ObservableList<Income> incomes = FXCollections.observableArrayList();

    public static ObservableList<Income> getIncomes() {
        return incomes;
    }

    @FXML
    private void addIncomeButtonAction(ActionEvent event) {
        Hardware.playButtonSoundEffect();

        try {
            int month = Integer.parseInt(monthTextField.getText());
            double amount = Double.parseDouble(amountTextField.getText());

            if (month < 0 || month > 12) {
                throw new IllegalArgumentException("Month must be between 0 and 12.");
            }

            Income income = new Income(month, amount);
            incomes.add(income);

            // Optionally, clear the text fields after adding the income
            monthTextField.clear();
            amountTextField.clear();
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., show an error message to the user)
            e.printStackTrace();
        }
    }

    @FXML
    private void goBackButtonAction(ActionEvent event) {
        Hardware.playButtonSoundEffect();

        try {
            Parent dashboardParent = FXMLLoader.load(getClass().getResource("/com/example/expensestracker/dashboard.fxml"));
            Scene dashboardScene = new Scene(dashboardParent);

            // Getting the stage from the event's source (the button in this case)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(dashboardScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
