module com.example.expensestracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.expensestracker to javafx.fxml;
    exports com.example.expensestracker;
}