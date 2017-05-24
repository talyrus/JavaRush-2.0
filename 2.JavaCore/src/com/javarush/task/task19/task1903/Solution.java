package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        //Проверка
        /*IncomeData data = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }
            @Override
            public String getContactFirstName() {
                return "Ivan";
            }
            @Override
            public String getContactLastName() {
                return "Ivanov";
            }
            @Override
            public int getCountryPhoneCode() {
                return 38;
            }
            @Override
            public int getPhoneNumber() {
                return 501234567;

        };
        Contact var = new IncomeDataAdapter(data);
        Customer var2 = new IncomeDataAdapter(data);
        System.out.println(var2.getCompanyName());
        System.out.println(var2.getCountryName());
        System.out.println(var.getName());
        System.out.println(var.getPhoneNumber());}*/
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private  IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode()) ;
        }

        @Override
        public String getName() {
            return String.format("%s, %s", this.data.getContactLastName(), this.data.getContactFirstName());
        }

        @Override
        public String getPhoneNumber() {
            String stroka;
            stroka = String.format("+%d(%2$s)%3$s-%4$s-%5$s", this.data.getCountryPhoneCode(),
                    String.format("%010d", this.data.getPhoneNumber()).substring(0, 3),
                    String.format("%010d", this.data.getPhoneNumber()).substring(3, 6),
                    String.format("%010d", this.data.getPhoneNumber()).substring(6, 8),
                    String.format("%010d", this.data.getPhoneNumber()).substring(8));
            return stroka;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}
