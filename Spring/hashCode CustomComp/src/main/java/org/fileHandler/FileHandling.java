package org.fileHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileHandling {
    public static class Employee {
        private int id;
        private String name;
        private double salary;

        public Employee() {
        }

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\2446107\\Documents\\Notes\\Day 1\\Spring\\hashCode CustomComp\\src\\main\\java\\org\\fileHandler\\employees.json");
        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode root = objectMapper.readTree(file);
//        for(JsonNode node : root) {
//            System.out.println(node.get("name"));
//        }
        Employee[] arr = objectMapper.readValue(file, Employee[].class);
        for(Employee e : arr) {
            System.out.println(e.getName());
        }
//        List<Employee> list = objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
//        list.stream().forEach(e -> System.out.println(e.getName()));
    }
}
