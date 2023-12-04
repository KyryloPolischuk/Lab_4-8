package com.Tariff;

public class Tariff {
    private String name;
    private double subscriptionFee;

    public Tariff(String name, double subscriptionFee) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
    }

    // Гетери та сетери

    public String getName() {
        return name;
    }


    public double getSubscriptionFee() {
        return subscriptionFee;
    }

}
