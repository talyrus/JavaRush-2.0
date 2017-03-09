package com.javarush.task.task15.task1522;

/**
 * Created by Taly on 09.03.2017.
 * Класс Sun не должен позволять создавать объекты своего типа извне класса.
 * Класс Sun должен содержать приватное статическое поле instance типа Sun.
 * В классе Sun должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
 * Метод getInstance в классе Sun должен ВСЕГДА возвращать один и тот же объект.
 * Поле instance должно быть инициализировано после первого обращения к методу getInstance, но не раньше.
 *
 */
public class Sun implements Planet {
    private static Sun instance;

    private Sun() {

    }

    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }
}
