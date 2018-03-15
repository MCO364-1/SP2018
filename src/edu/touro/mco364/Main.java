package edu.touro.mco364;

import java.io.*;
import java.util.ArrayList;

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

        ArrayList2 mal = new ArrayList2();
        mal.bs[0] = "Bob";
        mal.bs[1] = "Bill";
        mal.size = 2;

        oos.writeObject( mal );

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("data.obj")); // Decorator Design Pattern

        Object obj = ois.readObject();

        ois.close();

        mal = (ArrayList2)obj;
        System.out.println( mal.size);
        for(String s: mal.bs)
        {
            System.out.println(s);
        }
    }
}
