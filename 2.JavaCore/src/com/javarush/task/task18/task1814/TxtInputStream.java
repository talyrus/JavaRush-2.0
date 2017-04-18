package com.javarush.task.task18.task1814;

import java.io.*;


/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws UnsupportedFileNameException,  IOException {
        super(fileName);
        if (!fileName.endsWith(".txt")) {
            try {
                super.close();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
    }

}

