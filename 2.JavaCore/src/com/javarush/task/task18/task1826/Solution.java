package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    private static final String keyWord = "Cipher";
    public static void main(String[] args) throws IOException {
        if (args.length != 3)  {
            return;
        }
        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);
        byte[] file = new byte[fis.available()];
        fis.read(file);
        if (args[0].equals("-e")){
            fos.write(encrypt(file, keyWord));
        } else if (args[0].equals("-d")){
            fos.write(decrypt(file, keyWord));
       }
        fis.close();
        fos.close();
    }

    public static byte[] encrypt(byte[] arr, String keyWord)
    {
        byte[] keyarr = keyWord.getBytes();
        byte[] result = new byte[arr.length];

        for(int i = 0; i< arr.length; i++)
        {
            result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]);
        }
        return result;
    }
    public static byte[] decrypt(byte[] text, String keyWord)
    {
        byte[] keyarr = keyWord.getBytes();
        byte[] result  = new byte[text.length];

        for(int i = 0; i < text.length; i++)
        {
            result[i] = (byte) (text[i] ^ keyarr[i % keyarr.length]);
        }
        return result;
    }

}
