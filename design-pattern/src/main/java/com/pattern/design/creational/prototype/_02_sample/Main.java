package com.pattern.design.creational.prototype._02_sample;

public class Main {
    public static void main(String[] args) {
        Grade grade = new Grade(3, 1);
        Student student = new Student();
        student.setName("고범석");
        student.setOrderNumber(1);
        student.setGrade(grade);

        // 전학생이 와서 순번이 뒤로 밀렸다.
        Student cloneStudent = student.clone();
        cloneStudent.setOrderNumber(2);
    }
}
