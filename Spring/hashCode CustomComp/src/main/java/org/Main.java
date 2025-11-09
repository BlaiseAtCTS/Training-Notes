package org;

import java.util.HashMap;
import java.util.Map;
class Car {
    public static String name;
    private String color;
    public Car(String color) {
        this.color = color;
    }
    public void display() {
        System.out.println("Color: "+this.color+" Name: "+name);
    }
}
public class Main {
    public static void main(String[] args) {
        Car.name = "Volvo";
        Car car = new Car("red");
        car.display();

        Car car1 = new Car("black");
        car.display();
        /*
        String str = "Aabb";
        str = str.toLowerCase();
        Map<Character, Integer> hash = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            if(!hash.containsKey(str.charAt(i))) {
                hash.put(str.charAt(i), 1);
            } else {
                int value = hash.get(str.charAt(i));
                value += 1;
                hash.put(str.charAt(i), value);
            }
        }
        for(int i=0; i<str.length(); i++) {
            if(hash.get(str.charAt(i)) == 1) {
                System.out.println(str.charAt(i));
                break;
            }
        }

         */
    }
}
