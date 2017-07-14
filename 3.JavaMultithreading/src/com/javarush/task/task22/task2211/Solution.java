package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Смена кодировки
*/
public class Solution {
	static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(args[0]); //создаем поток ввода и считываем имя файла
		byte[] arr = new byte[fis.available()]; // создаем массив байт, равный количеству считываемых байт из файла
		fis.read(arr); // считываем в созданный массив содержимое файла
		String str = new String(arr, "UTF-8"); // передадим через строковый конструктор считанные байты, указав кодировку
		arr = str.getBytes("Windows-1251"); // запишем в байтовый массив байты в другой кодировке
		FileOutputStream fos = new FileOutputStream(args[1]); // создадим поток вывода в другой файл
		fos.write(arr); // запишем байтовый массив
		fis.close(); // закроем потоки
		fos.close();
	}
}
