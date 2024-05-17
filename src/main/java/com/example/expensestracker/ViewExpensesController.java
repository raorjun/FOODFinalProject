package com.example.expensestracker;

import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewExpensesController {

    @FXML
    private PieChart expensesPieChart;

    private ObservableList<ViewExpense> viewExpenseList = FXCollections.observableArrayList();


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

    public void addExpense(ViewExpense viewExpense) {
        viewExpenseList.add(viewExpense);
        updateChart();
    }

    private void updateChart() {
        expensesPieChart.getData().clear();
        for (ViewExpense viewExpense : viewExpenseList) {
            expensesPieChart.getData().add(new PieChart.Data(viewExpense.getExpenseName(), viewExpense.getAmount()));
        }
    }
}
