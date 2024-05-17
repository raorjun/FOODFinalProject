package com.example.expensestracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewIncomeController {

    @FXML
    private LineChart<Number, Number> incomeChart;

    private ObservableList<ViewIncome> viewIncomeList = FXCollections.observableArrayList();

    @FXML
    private void goBackButtonAction(ActionEvent event) {
        try {
            Parent dashboardParent = FXMLLoader.load(getClass().getResource("/com/example/expensestracker/dashboard.fxml"));
            Scene dashboardScene = new Scene(dashboardParent);

            // Get the stage from the event's source (the button in this case)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(dashboardScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addIncome(ViewIncome viewIncome) {
        viewIncomeList.add(viewIncome);
        updateChart();
    }

    private void updateChart() {
        incomeChart.getData().clear();
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        for (int i = 0; i < viewIncomeList.size(); i++) {
            series.getData().add(new XYChart.Data<>(i + 1, viewIncomeList.get(i).getAmount()));
        }
        incomeChart.getData().add(series);
    }
}
