package com.javarush.task.task28.task2810.vo;

import java.util.Objects;

/**
 * Created by Taly on 28.09.2018.
 */
public class Vacancy {
	String title, salary, city, companyName, siteName, url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Vacancy vacancy = (Vacancy) o;
		return Objects.equals(title, vacancy.title) &&
						Objects.equals(salary, vacancy.salary) &&
						Objects.equals(city, vacancy.city) &&
						Objects.equals(companyName, vacancy.companyName) &&
						Objects.equals(siteName, vacancy.siteName) &&
						Objects.equals(url, vacancy.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, salary, city, companyName, siteName, url);
	}
}
