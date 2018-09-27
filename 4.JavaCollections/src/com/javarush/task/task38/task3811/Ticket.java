package com.javarush.task.task38.task3811;

/**
 * Created by Taly on 27.09.2018.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME) //доступна во время выполнения программы
@Target(ElementType.TYPE)
public @interface Ticket {

	enum Priority { //содержать enum Priority c элементами LOW, MEDIUM, HIGH
		LOW,
		MEDIUM,
		HIGH
	}

	Priority priority() default Priority.MEDIUM; //Приоритет будет задавать свойство priority — по умолчанию Priority.MEDIUM.

	String[] tags() default {}; //Свойство tags будет массивом строк и будет хранить теги связанные с тикетом

	String createdBy() default "Amigo"; //Свойство createdBy будет строкой — по умолчанию Amigo
}
