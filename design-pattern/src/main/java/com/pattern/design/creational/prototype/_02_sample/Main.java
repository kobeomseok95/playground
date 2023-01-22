package com.pattern.design.creational.prototype._02_sample;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("고범석", 1, new Grade(3, 1));
        Student clone = student.clone();

        System.out.println("clone != student = " + (clone != student));
        System.out.println("clone.equals(student) = " + clone.equals(student));
    }
}
