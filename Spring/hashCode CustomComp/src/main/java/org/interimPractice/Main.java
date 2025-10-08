package org.interimPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static class CustomCompare implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return Integer.compare(b.number, a.number);
        }
    }

    public static class Employee {
        public int number;
        public Employee(int number) {
            this.number = number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.number);
        }

//        @Override
//        public int compareTo(Employee o) {
//            return Integer.compare(this.number, o.number);
//        }
    }

    public static void main(String[] args) {
//        Interface inter = (message) -> System.out.println(message);
//        inter.print("Hello");

        Employee e1 = new Employee(2);
        Employee e2 = new Employee(3);
        Employee e3 = new Employee(4);
        Employee e4 = new Employee(4);
        System.out.println(e3.hashCode());
        System.out.println(e4.hashCode());

        System.out.println(e3.equals(e4));

        List<Employee> eL = new ArrayList<>(Arrays.asList(e1, e2, e3, e4));
        CustomCompare cc = new CustomCompare();
        Collections.sort(eL, cc);
//        eL.forEach(e -> System.out.println(e.number));
    }
}
