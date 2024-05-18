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

public class AddExpenseController {

    @FXML
    private TextField expenseNameTextField;

    @FXML
    private TextField amountTextField;

    private static ObservableList<Expense> expenses = FXCollections.observableArrayList();

    public static ObservableList<Expense> getExpenses() {
        return expenses;
    }

    @FXML
    private void addExpenseButtonAction(ActionEvent event) {
        Hardware.playButtonSoundEffect();

        try {
            String name = expenseNameTextField.getText();
            double amount = Double.parseDouble(amountTextField.getText());

            Expense expense = new Expense(name, amount);
            expenses.add(expense);

            // Optionally, clear the text fields after adding the expense
            expenseNameTextField.clear();
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
