package org.bolin.javaBasic.object.theWayToCreatInsance;

import java.io.*;

public class First implements  Cloneable,Serializable{
    int f1=1;
    public First(){

    }
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        First first = new First();
        First first2 =(First) Class.forName("org.bolin.javaBasic.object.theWayToCreatInsance.First").newInstance();
        First clone = (First) first2.clone();
        First first4 = First.class.newInstance();


        // Serialize object

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\weizuomian\\JAVA\\suanfa\\algorithm\\IOResources\\1.ser"));
        out.writeObject(first);
        out.close();

        // Deserialize object
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\weizuomian\\JAVA\\suanfa\\algorithm\\IOResources\\1.ser"));
        First newObj = (First) in.readObject();
        System.out.println(newObj.f1);
        in.close();



    }
}
