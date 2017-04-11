package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = null;
        String secondName = null;

        try {
            firstName = reader.readLine();
            secondName = reader.readLine();
            reader.close();

            FileReader firstFileReader = new FileReader(firstName);
            BufferedReader firstReader = new BufferedReader(firstFileReader);
            String input;
            while ( (input = firstReader.readLine()) != null) {
                allLines.add(input);
            }
            firstReader.close();

            FileReader secondFileReader = new FileReader(secondName);
            BufferedReader secondReader = new BufferedReader(secondFileReader);
            while ( (input = secondReader.readLine()) != null) {
                forRemoveLines.add(input);
            }
            secondReader.close();
            new Solution().joinData();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    public synchronized void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
