package com.example.expensestracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.ListChangeListener;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
public class ViewExpensesController {

    @FXML
    private PieChart expensePieChart;


    @FXML
    private TableView<Expense> expenseTableView;

    @FXML
    private TableColumn<Expense, String> expenseNameColumn;

    @FXML
    private TableColumn<Expense, Double> expenseAmountColumn;


    @FXML
    public void initialize() {
        expenseNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        expenseAmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // Populate TableView with data
        expenseTableView.setItems(AddExpenseController.getExpenses());

        updateChart();

        AddExpenseController.getExpenses().addListener((ListChangeListener<Expense>) change -> {
            updateChart();
        });
    }

    private void updateChart() {
        expensePieChart.getData().clear();
        for (Expense expense : AddExpenseController.getExpenses()) {
            expensePieChart.getData().add(new Data(expense.getName(), expense.getAmount()));
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
