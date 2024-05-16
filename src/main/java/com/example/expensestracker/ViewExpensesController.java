package com.example.expensestracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class ViewExpensesController {

    @FXML
    private PieChart expensesPieChart;

    private ObservableList<Expense> expenseList = FXCollections.observableArrayList();

    @FXML
    void goBackButtonAction() {
        expensesPieChart.getScene().getWindow().hide();
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
        updateChart();
    }

    private void updateChart() {
        expensesPieChart.getData().clear();
        for (Expense expense : expenseList) {
            expensesPieChart.getData().add(new PieChart.Data(expense.getExpenseName(), expense.getAmount()));
        }
    }
}
