package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String regex = "\\.";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_1 = reader.readLine();
        String file_2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file_1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file_2));

        String string = "";
        while (fileReader.ready()) {
            string += fileReader.readLine();
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "!");
        }
        matcher.appendTail(stringBuffer);
        fileWriter.write(stringBuffer.toString());
        fileReader.close();
        fileWriter.close();
    }
}
