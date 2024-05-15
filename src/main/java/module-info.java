module com.example.expensestracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.expensestracker to javafx.fxml;
    exports com.example.expensestracker;
}