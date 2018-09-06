package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("d:\\!Virus\\"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
    }
}
