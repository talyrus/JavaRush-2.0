package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {

		FileInputStream fis;
		String file;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			file = reader.readLine();
			try{
				fis = new FileInputStream(file);
				fis.close();
			} catch (FileNotFoundException e){
				System.out.println(file);
				reader.close();
				break;
			}
		}
	}
}

