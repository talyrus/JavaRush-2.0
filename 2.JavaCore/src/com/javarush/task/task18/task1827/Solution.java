package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (!args[0].equals("-c"))
            return;
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file;
        file = reader.readLine();
        BufferedReader readerFR = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();
        Long id = new Long(0);
        String stroka, tmp;
        while (readerFR.ready()) {
            stroka = readerFR.readLine();
            list.add(stroka);
            int pos = stroka.indexOf(" ");
            if (pos > 8)
                tmp = stroka.substring(0, 8);
            else
                tmp = stroka.substring(0, pos);
            if (Long.parseLong(tmp) > id)
                id = Long.parseLong(tmp);
        }

        tmp = String.format("%-8d%-30.30s%-8s%-4s", (++id), productName, price, quantity);
        BufferedWriter writerF = new BufferedWriter(new FileWriter(file));
        for (String s : list)
            writerF.write(s + "\n");
        writerF.write(tmp.toString());
        reader.close();
        readerFR.close();
        writerF.close();
    }
}
