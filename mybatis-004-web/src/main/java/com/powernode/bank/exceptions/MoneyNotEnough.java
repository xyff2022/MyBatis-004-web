package com.powernode.bank.exceptions;

public class MoneyNotEnough extends Exception {
    public MoneyNotEnough() {
    }

    public MoneyNotEnough(String message) {
        super(message);
    }
}
