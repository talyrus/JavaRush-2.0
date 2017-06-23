package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();//!
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //String fileName = in.readObject().toString();
        stream = new FileOutputStream(fileName, true);
        //in.close(); //!
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("d:\\!Virus\\test.txt");
        solution.writeObject("Test \r\n");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\!Virus\\test1.txt"));
        oos.writeObject(solution);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\!Virus\\test1.txt"));
        Solution recover_solusion = (Solution)ois.readObject();
        recover_solusion.writeObject("Test 2 \r\n");
    }
}
