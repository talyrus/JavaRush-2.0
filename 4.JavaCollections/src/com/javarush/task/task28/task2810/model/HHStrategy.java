package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Created by Taly on 28.09.2018.
 */
public class HHStrategy implements Strategy {
	private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

	@Override
	public List<Vacancy> getVacancies(String searchString) throws IOException {
		String url = String.format(URL_FORMAT, searchString, 1);
		Document doc = Jsoup.connect(url).get();
		//System.out.println(doc.html());
		return null;
	}
}
