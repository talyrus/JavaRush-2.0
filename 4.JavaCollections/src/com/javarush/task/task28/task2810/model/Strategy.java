package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Created by Taly on 28.09.2018.
 */
public interface Strategy {
	public List<Vacancy> getVacancies(String searchString) throws IOException;
}
