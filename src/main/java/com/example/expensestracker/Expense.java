package com.example.expensestracker;

public class Expense{
    private String expenseName;
    private double amount;

    public Expense(String expenseName, double amount) {
        this.expenseName = expenseName;
        this.amount = amount;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

