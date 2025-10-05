package org.example;

import java.util.Objects;

public class Employee {
    private int age;
    private String grade;

    public Employee(int age, String name, String grade) {
        this.age = age;
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        Employee employee = (Employee) o;
        return this.age == employee.age && Objects.equals(this.grade, employee.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.age, this.grade);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
