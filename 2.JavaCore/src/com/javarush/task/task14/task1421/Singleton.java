package com.javarush.task.task14.task1421;

/**
 * Created by Taly on 16.02.2017.
 * https://habrahabr.ru/post/27108/ - описание различных реализаций Singleton
 */
public final class Singleton {
    private static Singleton instance = null;

    public static Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    private Singleton() {
    }
}
