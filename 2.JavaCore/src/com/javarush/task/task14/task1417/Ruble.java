package com.javarush.task.task14.task1417;

/**
 * Created by Taly on 15.02.2017.
 */
public class Ruble extends Money {
    @Override
    public String getCurrencyName() {
        return "RUB";
    }

    public Ruble(double amount) {
        super(amount);
    }

}
