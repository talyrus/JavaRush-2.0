package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader fileRead = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(args[1]));
        String result = "";
        while (fileRead.ready()) {
            String [] strings = fileRead.readLine().split(" ");
            for (String item: strings) {
                if (item.matches(".*\\d.*")) {
                    result += item + " ";
                }
            }
            //System.out.println(result);
        }
        fileWrite.write(result);
        fileRead.close();
        fileWrite.close();
    }
}
