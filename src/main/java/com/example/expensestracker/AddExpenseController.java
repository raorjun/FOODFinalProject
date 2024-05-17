package com.example.expensestracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddExpenseController {

    @FXML
    private TextField expenseNameTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private ViewExpensesController viewExpensesController;

    @FXML
    void addExpenseButtonAction(ActionEvent event) {
        String expenseName = expenseNameTextField.getText();
        String amountText = amountTextField.getText();
        if (expenseName.isEmpty() || amountText.isEmpty()) {
            showAlert("Error", "Please enter both expense name and amount.");
            return;
        }
        try {
            double amount = Double.parseDouble(amountText);
            ViewExpense viewExpense = new ViewExpense(expenseName, amount);
            // Pass the new expense to the ViewExpensesController
            viewExpensesController.addExpense(viewExpense);
            showAlert("Success", "Expense added successfully: \nName: " + expenseName + "\nAmount: $" + amount);
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid amount format. Please enter a valid number.");
        }
    }

    @FXML
    void goBackButtonAction(ActionEvent event) {
        expenseNameTextField.getScene().getWindow().hide();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
