package com.javarush.task.task14.task1408;

/**
 * Created by Taly on 14.02.2017.
 */
public class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 22;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE +
                ". Я несу " + this.getCountOfEggsPerMonth()
                + " яиц в месяц.";
    }
}
