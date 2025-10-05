package org.example;

import java.util.Comparator;

public class CustomCompare implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}