package edu.touro.mco364;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class ArrayList2 implements Serializable
{
    //private static final long serialVersionUID = 868345258142892189L;
    transient String [] bs = new String[100];
    int size;

    // custom serialiation (the physical structure is not equal to logical structure)
    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException
    {
        out.defaultWriteObject();
      //  out.write(size);
        for (int i=0;i<size;i++)
            out.writeObject(bs[i]);
    }

    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {

        in.defaultReadObject();
      //  size = in.readInt();
        bs = new String[size];

        for (int i = 0; i < size; i++)
            bs[i] = (String) in.readObject();

    }
}
