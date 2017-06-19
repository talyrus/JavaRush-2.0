package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user = new User();
            user.setFirstName("Ivan");
            user.setLastName("Petrov");
            user.setBirthDate(new Date(1970, 9, 5));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);

            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if(users == null) {
                throw new Exception();
            }
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User item: users){
                String user = item.getFirstName() + " " + item.getLastName();
                user =  user + " " + item.getBirthDate().getTime();
                if (item.isMale())
                    user = user + " " + "М";
                else
                    user = user + " " + "Ж";
                user = user + " " + item.getCountry().getDisplayedName();
                printWriter.println(user);
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            users = new ArrayList();
            while (reader.ready()) {
                String str = reader.readLine();
                String[] arr_str = str.split(" ");
                User user = new User();
                user.setFirstName(arr_str[0]);
                user.setLastName(arr_str[1]);
                user.setBirthDate(new Date(Long.parseLong(arr_str[2])));
                if (arr_str[3].equals("М")) {
                    user.setMale(true);
                }
                else if (arr_str[3].equals("Ж")) {
                    user.setMale(false);
                }
                if (arr_str[4].equals("Ukraine")) {
                    user.setCountry(User.Country.UKRAINE);
                }
                if (arr_str[4].equals("Russia")) {
                    user.setCountry(User.Country.RUSSIA);
                }
                if (arr_str[4].equals("Other")) {
                    user.setCountry(User.Country.OTHER);
                }
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
