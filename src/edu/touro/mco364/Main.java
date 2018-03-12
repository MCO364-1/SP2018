package edu.touro.mco364;

import java.io.*;

class Zigwig implements Serializable{
    Zigwig(int age, String name){this.age = age; this.name = name;}
    private int age;
    private String name;
    public String toString()
    {
        return String.format("%d, %s", age, name);
    }
}

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("data.obj")); // Decorator Design Pattern

        Object obj = new Zigwig(99, "NinetyNine");//"Bob the Builder";
        oos.writeObject( obj );

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("data.obj")); // Decorator Design Pattern

        obj = ois.readObject();

        ois.close();

        Zigwig s = (Zigwig) obj;
        System.out.println(obj);
    }
}
