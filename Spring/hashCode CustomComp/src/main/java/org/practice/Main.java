package org.practice;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student implements Comparable<Student> {
    public String name;
    public int phone;

    public Student(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public int compareTo(Student s) {
        return this.name.compareTo(s.name);
    }

//    @Override
//    public boolean equals(Object obj) {
//        Student s = (Student) obj;
//        if(this.name.equals(s.name) && this.phone == s.phone) {
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        Student s = (Student) obj;
//        return this.name.equals(s.name) && this.phone == s.phone;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(this.name, this.phone);
//    }
}

public class Main {
    public static class CustomCompare implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            if(s1.name.length() > s2.name.length()) {
                return 1;
            } else if (s1.name.length() == s2.name.length()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(Arrays.asList(12, 23, 11, 22, 33));
        List<Integer> list = List.of(11);
        List<Integer> rev = numList.reversed();
        List<Integer> sorted = numList.stream().sorted().toList();
        List<Integer> filter = numList.stream().filter((n) -> n%2==0).collect(Collectors.toList());
        List<Integer> map = numList.stream().map((n) -> n = n+2).collect(Collectors.toList());
        int sum = numList.stream().reduce(0, (a, b) -> a+b);
        int count = (int) numList.stream().count();
        System.out.println(sum);

        Student s1 = new Student("Blaise", 1);
        Student s2 = new Student("Blaise", 1);
        Student s3 = new Student("Adam", 2);
        Student s4 = new Student("Abel", 0);
        List<Student> list1 = new ArrayList<>();
        Collections.sort(list1);

        String str1 = new String("Blaise");
        String str2 = new String("Blaise");

//        System.out.println("Hashcode s1: "+str1.hashCode());
//        System.out.println("Hashcode s2: "+str2.hashCode());
//
//        if(str1.equals(str2)) {
//            System.out.println("equals: true");
//        } else {
//            System.out.println("equals: false");
//        }

//        System.out.println("Equals: "+str1.equals(str2)); // true
//        System.out.println("==: "+str1 == str2); // false
//        System.out.println("s1 HashCode: "+str1.hashCode());
//        System.out.println("s2 HashCode: "+str2.hashCode());

//        List<Integer> primeNumber = new ArrayList<>();
//        for(int i=2; i<100; i++) {
//            boolean flag = true;
//            for(int j=2; j<i; j++) {
//                if(i%j == 0) {
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag) {
//                primeNumber.add(i);
//            }
//        }
//
//        primeNumber.forEach(System.out::println);

        List<Student> studentList = new ArrayList<>(Arrays.asList(s1, s2, s3, s4));

        Collections.sort(studentList);
        studentList.forEach((s) -> System.out.println(s.name));

//        List<? extends Serializable> flatMap = studentList.stream().flatMap(s -> Stream.of(s.name, s.phone)).toList();

        List<Student> sortedSL = studentList.stream()
                .sorted(Comparator.comparing(s -> s.name))
                .collect(Collectors.toList());
//                .reversed();

//        flatMap.forEach(s -> System.out.println(s));

        studentList.sort((a, b) -> {
            System.out.println("Comparing "+a.name+" & "+b.name);
            System.out.println("Output: "+a.name.compareTo(b.name));
            return a.name.compareTo(b.name);
        });


        CustomCompare cc = new CustomCompare();
//        studentList.sort();
        Collections.sort(studentList);
//        System.out.println(s1.compareTo(s2));
//        studentList.forEach((student -> System.out.println(student.name)));
    }
}
