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

class MAL implements Serializable
{
    int [] bs = new int[100];
    int size;

    // custom serizlaition (the phydical sturcture is not equal to logical sturcture)
    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException
    {
        out.defaultWriteObject();
        out.write(size);
        for (int i=0;i<size;i++)
            out.write(bs[i]);

    }
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException{

        in.defaultReadObject();
        size = in.readInt();
        bs = new int[size];

        for (int i =0;i<size;i++)
            bs[i] = in.readInt();

    }
    private void readObjectNoData()
            throws ObjectStreamException{

    }
}


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("data.judah")); // Decorator Design Pattern

        MAL mal = new MAL();
        mal.bs[0] = 9;
        mal.size = 1;
        //Object obj = new Zigwig(99, "NinetyNine");//"Bob the Builder";
        oos.writeObject( mal );

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("data.judah")); // Decorator Design Pattern

        Object obj = ois.readObject();

        ois.close();

        //Zigwig s = (Zigwig) obj;
        System.out.println( ((MAL)obj).size);
    }
}
