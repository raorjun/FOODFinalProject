package com.example.expensestracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.ListChangeListener;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;
public class ViewIncomeController {

    @FXML
    private LineChart<Number, Number> incomeLineChart;

    @FXML
    public void initialize() {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        incomeLineChart.getData().add(series);

        updateChart(series);

        AddIncomeController.getIncomes().addListener((ListChangeListener<Income>) change -> {
            updateChart(series);
        });
    }

    private void updateChart(XYChart.Series<Number, Number> series) {
        series.getData().clear();
        for (Income income : AddIncomeController.getIncomes()) {
            series.getData().add(new XYChart.Data<>(income.getMonth(), income.getAmount()));
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
