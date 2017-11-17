package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

	public Student getStudentWithAverageGrade(double averageGrade) {
		//TODO:
		for (Student el : students) {
			if (el.getAverageGrade() == averageGrade) {
				return el;
			}
		}
		return null;
	}

	public Student getStudentWithMaxAverageGrade() {
		//TODO:
		double maxGrade = 0;
		for (Student el : students) {
			double currentGrade = el.getAverageGrade();
			if (currentGrade > maxGrade) {
				maxGrade = currentGrade;
			}
		}
		return getStudentWithAverageGrade(maxGrade);
	}

	public Student getStudentWithMinAverageGrade() {
		//TODO:
		double minGrade = students.get(0).getAverageGrade();
		for (Student el : students) {
			double currentGrade = el.getAverageGrade();
			if (currentGrade < minGrade) {
				minGrade = currentGrade;
			}
		}
		return getStudentWithAverageGrade(minGrade);
	}

	public void expel(Student student) {
		students.remove(student);
	}
}
