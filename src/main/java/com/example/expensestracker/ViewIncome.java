package com.example.expensestracker;

public class Income {
    private int month;
    private double amount;

    public Income(int month, double amount) {
        this.month = month;
        this.amount = amount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
