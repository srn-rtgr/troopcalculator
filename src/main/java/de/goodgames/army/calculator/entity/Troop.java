package de.goodgames.army.calculator.entity;

abstract public class Troop {
    long amount;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    abstract public String getName();
}
