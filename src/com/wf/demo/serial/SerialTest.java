package com.wf.demo.serial;

import org.junit.Test;

import java.io.*;

/**
 * @author wf
 * @create 2020-05-31 11:34
 * @desc
 **/
public class SerialTest {

    @Test
    public void serialize() throws IOException {
        Student student = new Student("Wf", 18, 101, "abc");
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("student.txt")));
        stream.writeObject(student);
        stream.close();
        System.out.println("序列化成功");
    }

    @Test
    public void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("student.txt"));
        Student student = (Student) inputStream.readObject();
        inputStream.close();

        System.out.println("反序列化成功");
        System.out.println(student);
    }

    @Test
    public void singleton() throws IOException, ClassNotFoundException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("singleton.txt")));
        stream.writeObject(Singleton.getInstance());
        stream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("singleton.txt"));
        Singleton singleton1 = (Singleton) inputStream.readObject();
        inputStream.close();
        System.out.println(singleton1);
        System.out.println(Singleton.getInstance());
        System.out.println(singleton1 == Singleton.getInstance());
    }
}
