package org.example;

import java.util.Objects;

public class Student {
    private int age;
    private String name;
    private String grade;

    public Student(int age, String name, String grade) {
        this.age = age;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(grade, student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, grade);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
