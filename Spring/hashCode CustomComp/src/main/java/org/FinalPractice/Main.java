package org.FinalPractice;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamCompare {
    public StreamCompare() {}
    @Override
    public boolean equals(Object o) {
        Stream s = (Stream) this;
        Stream s1 = (Stream) o;
        return s.toList().equals(s1.toList());
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Zam", "Adam", "Abel", "Bob", "Yohan"));
        List<String> list1 = new ArrayList<>(Arrays.asList("Zam", "Adam", "Abel", "Bob", "Yohan"));
        System.out.println(list.stream().sorted(Comparator.comparing(s -> s)).collect(Collectors.toList()));
        System.out.println(list.stream().filter(s -> s.substring(0, 1).equalsIgnoreCase("a")).collect(Collectors.toList()));
        System.out.println(list.stream().map(s -> s+="LOL").collect(Collectors.toList()));
        StreamCompare streamCompare = new StreamCompare();
        System.out.println(list.stream().equals(list1.stream()));
        System.out.println(list.stream().sorted().toList());
        Supplier<String> supplier = () -> String.valueOf(Math.random());
        System.out.println(supplier.get());
    }
}
