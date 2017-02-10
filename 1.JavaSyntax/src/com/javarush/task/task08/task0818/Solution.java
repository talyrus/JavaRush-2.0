package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("QQQ", 1000);
        map.put("QQQ1", 299);
        map.put("QQQ2", 440);
        map.put("QQQ3", 150);
        map.put("QQQ4", 500);
        map.put("QQQ5", 9000);
        map.put("QQQ6", 4000);
        map.put("QQQ7", 3000);
        map.put("QQQ8", 200);
        map.put("QQQ9", 100);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy_map = new HashMap<>(map); // создадим копию map
        for (Map.Entry<String, Integer> pair: copy_map.entrySet()) { //перебираем копию
            if (pair.getValue() < 500)                  // проверяем на значение
            {
                 map.remove(pair.getKey());                 // удаляем из основной map запись
            }
        }
    }

    public static void main(String[] args) {
    }
}