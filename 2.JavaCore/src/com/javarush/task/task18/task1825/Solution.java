package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> treeSet = new TreeSet<>();
        String fileName;
        for (fileName = sc.nextLine(); !fileName.equals("end"); fileName = sc.nextLine()) {
            treeSet.add(fileName);
        }

        sc.close();

        String currentFileName = "";
        String nextFileName;

        FileOutputStream fos = null;

        Iterator<String> iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            nextFileName = iterator.next();
            if (!nextFileName.contains(currentFileName) || (currentFileName.equals(""))) {
                if (fos != null) {
                    fos.close();
                }
                currentFileName = nextFileName.substring(0, nextFileName.lastIndexOf('.'));
                fos = new FileOutputStream(currentFileName);
            }
            FileInputStream fis = new FileInputStream(nextFileName);
            byte[] buffer = new byte[fis.available()];
            while (fis.available() > 0) {
                int readed = fis.read(buffer);
                fos.write(buffer, 0, readed);
            }
            fis.close();
        }
        if (fos  != null) {
            fos.close();
        }
    }
}
