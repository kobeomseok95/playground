package com.pattern.design.creational.prototype._02_sample;

import java.util.Objects;

public class Student implements Cloneable {
    private String name;
    private int orderNumber;
    private Grade grade;

    public void changeOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Student(String name, int orderNumber, Grade grade) {
        this.name = name;
        this.orderNumber = orderNumber;
        this.grade = grade;
    }

    @Override
    public Student clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return orderNumber == student.orderNumber && name.equals(student.name) && grade.equals(student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, orderNumber, grade);
    }
}
