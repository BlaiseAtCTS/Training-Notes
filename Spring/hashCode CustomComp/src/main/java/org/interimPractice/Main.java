package org.interimPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static class CustomCompare implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return Integer.compare(b.number, a.number);
        }
    }

    public static class Employee implements Comparable<Employee> {
        public int number;
        public Employee(int number) {
            this.number = number;
        }
        @Override
        public int compareTo(Employee o) {
            return Integer.compare(this.number, o.number);
        }
    }

    public static void main(String[] args) {
        Interface inter = (message) -> System.out.println(message);
        inter.print("Hello");

        Employee e1 = new Employee(2);
        Employee e2 = new Employee(3);
        Employee e3 = new Employee(1);
        Employee e4 = new Employee(4);

        List<Employee> eL = new ArrayList<>(Arrays.asList(e1, e2, e3, e4));
        CustomCompare cc = new CustomCompare();
        Collections.sort(eL, cc);
        eL.forEach(e -> System.out.println(e.number));
    }
}
