package com.pattern.design;

import com.pattern.design.creational.singleton.SingletonE;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

//@SpringBootApplication
public class DesignApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("생성자 호출");
        SingletonE source = SingletonE.getInstance();
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singletonE.obj"))) {
            out.writeObject(source);
        }

        SingletonE target = null;
        System.out.println("생성자를 호출할까?");
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("singletonE.obj"))) {
            target = (SingletonE) in.readObject();
        }

        System.out.println(source == target);
    }
}
