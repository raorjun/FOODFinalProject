package com.example.expensestracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    void viewExpensesButtonAction(ActionEvent event) {
        loadScreen("view_expenses.fxml", "View Expenses");
    }

    @FXML
    void viewIncomeButtonAction(ActionEvent event) {
        loadScreen("view_income.fxml", "View Income");
    }

    @FXML
    void addExpenseButtonAction(ActionEvent event) {
        loadScreen("add_expense.fxml", "Add Expense");
    }

    @FXML
    void addIncomeButtonAction(ActionEvent event) {
        loadScreen("add_income.fxml", "Add Income");
    }

    private void loadScreen(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

