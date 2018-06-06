package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		Second s = (Second) convertOneToAnother(new First(), Second.class);
		First f = (First) convertOneToAnother(new Second(), First.class);
	}

	public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter stringWriter = new StringWriter();
		mapper.writeValue(stringWriter, one);
		String sourceClassName = one.getClass().getSimpleName().toLowerCase();
		String resultClassName = resultClassObject.getSimpleName().toLowerCase();
		String replaceString = stringWriter.toString().replaceFirst(sourceClassName, resultClassName);
		return mapper.readValue(new StringReader(replaceString), resultClassObject);
	}

	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
	@JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
	public static class First {
		public int i;
		public String name;
	}

	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
	@JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
	public static class Second {
		public int i;
		public String name;
	}
}
