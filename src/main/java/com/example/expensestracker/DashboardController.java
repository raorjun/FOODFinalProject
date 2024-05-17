// DashboardController.java
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
        try {
            Parent incomeViewParent = FXMLLoader.load(getClass().getResource("/com/example/expensestracker/viewIncome.fxml"));
            Scene incomeViewScene = new Scene(incomeViewParent);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(incomeViewScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewExpenses(ActionEvent event) {
        try {
            Parent expensesViewParent = FXMLLoader.load(getClass().getResource("/com/example/expensestracker/viewExpenses.fxml"));
            Scene expensesViewScene = new Scene(expensesViewParent);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(expensesViewScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddIncome(ActionEvent event) {
        try {
            Parent addIncomeParent = FXMLLoader.load(getClass().getResource("/com/example/expensestracker/addIncome.fxml"));
            Scene addIncomeScene = new Scene(addIncomeParent);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(addIncomeScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddExpenses(ActionEvent event) {
        try {
            Parent addExpensesParent = FXMLLoader.load(getClass().getResource("/com/example/expensestracker/addExpense.fxml"));
            Scene addExpensesScene = new Scene(addExpensesParent);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(addExpensesScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

