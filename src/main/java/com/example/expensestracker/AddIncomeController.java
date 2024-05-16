package com.example.expensestracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddIncomeController {

    @FXML
    private TextField sourceTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private ViewIncomeController viewIncomeController;

    @FXML
    void addIncomeButtonAction(ActionEvent event) {
        String source = sourceTextField.getText();
        String amountText = amountTextField.getText();
        if (source.isEmpty() || amountText.isEmpty()) {
            showAlert("Error", "Please enter both source and amount.");
            return;
        }
        try {
            double amount = Double.parseDouble(amountText);
            Income income = new Income(source, amount);

            viewIncomeController.addIncome(income);
            showAlert("Success", "Income added successfully: \nSource: " + source + "\nAmount: $" + amount);
        } catch (NumberFormatException e) {
            showAlert("Error", "Enter a valid number.");
        }
    }

    @FXML
    void goBackButtonAction(ActionEvent event) {
        sourceTextField.getScene().getWindow().hide();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
