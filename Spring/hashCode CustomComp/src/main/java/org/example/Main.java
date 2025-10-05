package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(18, "Adam", "A");
        Employee s2 = new Employee(18, "Adam", "A");
        Student s3 = new Student(20, "Bob", "C");

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(s1);
//        System.out.println(studentSet.contains(s2));
        System.out.println(s1.equals(s2));

//        try {
//            int val = 100;
//            return 100/0;
//        }
//        finally {
//            System.out.println("Welcome");
//        }
    }
}
