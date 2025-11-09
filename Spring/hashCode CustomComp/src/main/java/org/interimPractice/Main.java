package org.interimPractice;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static class CustomCompare implements Comparator<Employee> {
        public int compare(Employee a, Employee b) {
            return b.number.compareTo(a.number);
//            return Integer.compare(b.number, a.number);
        }
//        static {
//            Integer a = 1;
//            a.compareTo();
//            a.compare()
//        }
    }

    public static class Employee implements Comparable<Employee> {
        public String name;
        public Integer number;
        public Employee(String name, int number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.number);
        }

        @Override
        public boolean equals(Object o) {
            if(o == null) {
                return false;
            }
            Employee e = (Employee) o;
            return this.name.equals(e.name);
        }

//        s1.compareTo(s2)
//        compare(s1, s2)

//        a = 1, b= 2
//        compare(a, b)
//            if a < b -> -1
//            if a == b -> 0
//            if a > b -> 1

//        [ 1 , 3, 2]
//        1.compareTo(3) -> -1 / 0
//            3.compareTo(2) -> 1 - switch

        @Override
        public int compareTo(Employee o) {
            return Integer.compare(this.number, o.number);
        }
    }

    public static void main(String[] args) {
//        Interface inter = (message) -> System.out.println(message);
//        inter.print("Hello");

        Employee e1 = new Employee("Ashu", 2);
        Employee e2 = new Employee("Karthik", 3);
        Employee e3 = new Employee("Swaroop", 4);
        Employee e4 = new Employee("Subash", 4);
//        System.out.println(e3.hashCode());
//        System.out.println(e4.hashCode());
//
//        System.out.println(e3.equals(e4));

        List<Employee> eL = new ArrayList<>(Arrays.asList(e1, e2, e3, e4));
//        eL.stream().sorted(Comparator.comparing(e -> e.number));
//        eL.stream().filter(n -> n.number == 2);
//        List<Integer> integerList = eL.stream()
//                .map(n -> n.number+1)
//                .collect(Collectors.toList());
//        System.out.println("Map: "+integerList);
//        // e.name and e.number is combined and its checking the parent type, and puts it as Object
//        List<Object> list = eL.stream()
//                .flatMap(e -> Stream.of(e.name, e.number))
//                .collect(Collectors.toList());
//        System.out.println("Flatmap: "+list);


        CustomCompare cc = new CustomCompare();
        System.out.println(Collections.max(eL));
        Collections.sort(eL, cc);
        eL.forEach(e -> System.out.println(e.number));
    }
}
