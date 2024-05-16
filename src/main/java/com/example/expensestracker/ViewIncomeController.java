package com.example.expensestracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;

public class ViewIncomeController {

    @FXML
    private LineChart<Number, Number> incomeChart;

    private ObservableList<Income> incomeList = FXCollections.observableArrayList();

    @FXML
    void goBackButtonAction() {
        incomeChart.getScene().getWindow().hide();
    }

    public void addIncome(Income income) {
        incomeList.add(income);
        updateChart();
    }

    private void updateChart() {
        incomeChart.getData().clear();
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (int i = 0; i < incomeList.size(); i++) {
            series.getData().add(new XYChart.Data<>(i + 1, incomeList.get(i).getAmount()));
        }
        incomeChart.getData().add(series);
    }
}
