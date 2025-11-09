# JAVA Notes
No value type string in Java, because strings store lots of values (int, double only store single value)
There must be a static void main method to run a Java program.

Heap and Stack memory.
Heap: dynamic memory allocation.
Stack: compile time memory allocation.

*Can use return in tekstack*
**LEARN STREAMS AND THREADS**
JDK is an umbrella, JVM is where code is run. Java is compiled language.

Protected: Only inherited classes can access
Public: Irrespective of packages or classed
Private: Only access in that class

### Polymorphism:
overloading(compile time), overriding(run time)
```
Vehicle car = new Car() --> declaring Car(child type) to Vehicle(parent type)
even if both Vehicle and Car class has method Start(). If you execute car.Start(), Car class method will be called.
List<String> list = new ArrayList<>();
```

### Hashmap, Hashset:
They all expect reference types like Integer, String, Character not value types.
```
HashMap<Character, Integer> hash = new HashMap<>();
map.containsKey("USA")

```
Hashmap keys are stored as hash code. When another hash same as first hash code, it replaces it with 2nd hash code(if key already present in hashmap).
Key are stored in set. HashCollision

### Call stack:
The environment that executes Java source code keeps track of the method being executed in the call stack. When a method is called, a new frame containing its variables is created in the call stack. When the execution of a method ends, the frame relating to a method is removed from the call stack, which leads to execution resuming at the previous method of the stack.

### IO:
```
System.out.println()
Scanner scanner = new Scanner(System.in)
int num = scanner.nextLine() --> nextLine() only gets string
So, Integer.valueOf(scanner.nextLine()) --> string to int
```

### String:
string.equals(), string.split(" ") -> returns primitive array of text split whenever it meet " ".
string.CharAt(index), string.length(), string.toCharArray() --> cant iterate string directly, needs to be an array or iterable type.
string.toUpperCase(), toLowerCase(), string.substring(7, 12), string.substring(7) --> start index, string.concat("!!") --> append to string, string.trim() --> trims edges

car.compareTo("Volvi"); -> returns int.
    0 if equal
    greater than 0 if lexicographically greater.
    less than 0 if lexicographically lower.

string += "world" --> appends
string.matches(regex) --> checkks if the entire string matches regex pattern. .contains wont work with regex.
String regex = ".*[^a-zA-Z].*";

string.indexOf("World") --> returns -1 if not found, can do ("World", 6) --> will check for that word after index 6, .lastIndexOf("World") --> last occurence of the word
string.equals("World") --> returns boolean, equalsIgnoreCase("World")
string.contains("World") --> returns boolean
string.replace("old_word", "new_word") -> destructive, changes all occurance

### Array:
```
int[] array = new int[5]
array[0] = 10
array.length --> property
int[] array = {1, 2, 3}
```

### ArrayList:
Part of collections framework like linkedlist etc. (learn about access speed, insertion/deletion speed, size). ArrayList using Array underneath or vice versa?
Collections Hierarchy: https://techvidvan.com/tutorials/wp-content/uploads/sites/2/2020/03/collection-framework-hierarchy-in-java.jpg

```
list.add(0, "A"); --> like addFirst() but addFirst only works on Java 21+
list.remove(0); --> like removeFirst()
```
```
list.size()
ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
```
```
String - Arrays.toString(arr);
```
Store values of the same type.
Part of java.util
ArraList<Integer> list = new ArrayList<>(); --> Type is given as Integer instead of int.
    Variables in Java can be divided into two categories: value type (primitive) and reference type variables. Value-type variables such as int or double hold their actual values. Reference-type variables such as ArrayList, in contrast, contain a reference to the location that contains the value(s) relating to that variable.

    When you create a list, a limited space is reserved in the memory of the computer. When the ArrayList runs out of space, a larger space is reserved and the data from the previous space is copied to the new one.
ArrayList is a generic class. Its a reference type which stores objects of Integer class.
When sending a list to a method (method doesnt copy the value like in primitive types), instead it gets a reference to the values. So, if you change list inside method... it affects the original list.

### refence and primitive:
== checks the value for primitive types and the reference for reference types.
String name = "Car";
String name1 = "Car";
String name2 = new String("Car");
System.out.println(name == name1) --> gives true, because they both are in String Pool and since the values are same, they both share the reference. Changing one will affect another.
System.out.println(name == name2) --> gives false, because name is inside String Pool, name2 is in jvm. Since references are not same, it is false.
System.out.println(name.equals(name2)) --> String has equals method which check the value of both the objects, but .equals just does == when comparing two class objects like emp1.equals(emp2), you need to override equals method to check value like in String equals method.

#### Sorting:
```
ArrayList<String> sortList = new ArrayList<>();
Collections.sort(sortList);
list.stream().sorted(Comparator.reverseOrder()).toList();
```

#### Methods:
list.add(20) --> int '20' is converted to Integer object.(same happens in 'get')
list.get(index), list.size(), list.remove(index)

### For each loop:
Iterating over a ArrayList:
```
for(Integer num: list) {

}
```

### Class:
Objects are always created using a constructor.
If the programmer does not define a constructor for a class, Java automatically creates a default one for it. A default constructor is a constructor that doesn't do anything apart from creating the object.
class is public, class variables are private, constructor is public, methods are public.

Non-static variables inside a class are initialized when class object is created.
so, 
```
public class RegisterSteps {
    private WebDriver driver = DriverFactory.getDriver(); -> this is called immediately when new RegisterSteps() is called.
}
```

#### Order of initialization:
Static field:
    Initialized once when class is loaded.
Instance field : 
    Initialized automatically when a object is created.
Constructor:
    Runs after instance fields are initialized.
Methods;
    Only run when explicitly called.

### Exceptions:
ArrayIndexOutOfBounds

There is checked and unchecked exception. RunTimeException is unchecked, so it is not mandatory to handle it with catch. But InvalidNumberException is checked, so it must be handled with catch, otherwise it will give compile time error: Unhandled exception.

### MATH:
double roundedValue = Math.round(value * 100.0) / 100.0; --> This multiplies the number by 100, rounds it to the nearest integer, and then divides it back by 10 (ROUND BY 2 decimals)

### Exceptions:
Exception Hierarchy: https://lh5.googleusercontent.com/WqqNoyFEkZXfmZBBQjgIutY72_BUV6_By_BAe7Ih9u36HfelS3nTWQEYtdRUkQS32Tuhg9P9CUXo-jgvOpkO84vLm2viI4Od0BNustwONdMm7DKZnKC6kyVHyRJbsESLIPV4uBU
Can do:
```
public class Car throws IOException {

}
(or)
public class Car {
    try {

    }
    catch(IOException e) {
        throw new Exception();
    }
}
```
```
public class InvalidPriceException extends Exception {
        public InvalidPriceException(String message) {
            super(message);
        }
    }
```
```
try {
    if(price < 1 || price > 20) {
        throw new InvalidPriceException("Product price is invalid");
    }
    return true;
}
catch(InvalidPriceException e) {
    System.out.println(e.getMessage());
}
```

```
public void toValidateBookType(Book obj) throws InvalidBookException --> not catching exceptions inside this method, so define that you are gonna throw it
	{
		//FILL THE CODE HERE
	    if(obj.getBookType().toLowerCase().equals("engineering")) {
	        bookList.add(obj);
		}
		else {
		    throw new InvalidBookException("Book type Invalid");
		}
	}
```

### final:
final class: cant inherit
final method: cant override
final variables: cant change value

### StringBuilder:
```
String res = "";
while(!stack.isEmpty()) {
    res += stack.pop();
}
```
```
StringBuilder res = new StringBuilder();
while(!stack.isEmpty()) {
    res.append(stack.pop());
}
```

### Stack, Queue, ArrayList:
Stack: Stack<Integer> stack = new Stack<>();
To implement a queue, Java provides several classes like LinkedList and PriorityQueue.
Queue: Queue<Integer> queue = new LinkedList<>();
LinkedList: remove() removes element from first index. add() adds to last index.

Queue: cant add at specific index like in arraylist or linkedlist.

ArrayList:
Faster for random access (retrieving elements by index) because it uses an array.
Slower for insertion/deletion in the middle of the list, as it requires shifting elements.
LinkedList:
Slower for random access because it needs to traverse nodes sequentially.
Faster for insertion/deletion in the middle of the list, as it only updates node references.

### interface:
Can create a object for this(cant instantiate). (new)
Can only declare methods, cant initialize.
Like a contract. Sub classes have to implement all the methods.
interface will have 100% abstract method(automatically abstract).

Java 8:
any interface that has one abstract method, but many default methods is called functional interface. Can mark interface as @FunctionalInterface and you cant add more methods in it.

default --> no need to implement in all classes.
default void test() { some implementation }

#### lambda:
lambda can be used only with Functional Interface.
In javascript, function can be an argument. But since java cant get functions as arguments, this is a roundabout way to do that by using functional interface and using lambda functions.
```
public static void main(String[] args) {
    method(() -> 
        System.out.println("")
    ); --> lambda expression(bc single line)
}

public static void method(Interface interface) {
    
}
```

### Narrowing Typecasting:
https://www.bing.com/search?pglt=2083&q=Java+typecasting+from+higher+to+lower&cvid=d9b672c033a349fb965f5fe621ffb192&gs_lcrp=EgRlZGdlKgYIABBFGDkyBggAEEUYOTIGCAEQABhAMgYIAhAAGEAyBggDEAAYQDIGCAQQABhAMgYIBRAAGEAyBggGEAAYQDIGCAcQABhAMgYICBAAGEAyCAgJEOkHGPxV0gEJMTEzMzJqMGoxqAIAsAIA&FORM=ANNAB1&PC=U531

### abstract class:
Can create a object for this. (new)
abstract class must have atleast 1 abstract method.

abstract class implementing interface --> dont need to implement on all methods in interface.

### Streams:
numList.stream().forEach((num) -> System.out.println(num));

() -> {} --> this is functional interface
.forEach() accepts an interface called Consumer which accepts one void method (functional interface). So we dont need to mention the 

.filter((num) -> num%2==0); --> filter takes functional interface called Predicate which has boolean method.

.map((num) -> num*num); --> takes functional interface called Function which takes generic type R (so if you use .map with String, it will return String).

.filter gives output like Optional[12] because this is an intermediate operation.

numList.stream().map((num) -> num*num).forEach((num) -> System.out.println(num));

### Optional:
```
Optional<Integer> value = numList.stream().filter((num) -> num%2 == 0).findAny();

if(value.isPresent()) {

}
value.orElseThrow()
```

## package-private
if you dont give access modifer, a class defaults to package private.
Accessible only within same package.
```
class Helper { // no need access modifier.
    void print() {

    }
}
public class Main {

}
```
Can have only one top-level class(public class) in a file.

## Nested class / Inner class:
private inner class cant be accessed outside the outer class.
```
public class Main {
    public class Helper { // can be private or public. can be static or non static.
        void print() {

        }
    }
}
```
If nested class is non static, it has a reference to the outer class object that created it. CONS: This can lead to memory leak, if inner class instance outlives the outer class instance.
if nested class is static, cannot access instance variable from inside it.
```
public class Outer {
    private int instanceValue = 42;
    private static int staticValue = 40;
    public static class StaticNested {
        println(instanceValue); --> doesnt work
        println(staticValue); --> works
    }
    public class InstanceNested {
        println(instanceValue); --> works
        println(staticValue); --> works
    }
    public static void main() {
        StaticNested sn = new StaticNested(); --> no need to mention Outer
        Outer o = new Outer(); --> even if change this to null, InstanceNested still has a reference to it.
        Outer.InstanceNested in = o.new InstanceNested();
    }
}
```

## 
Object class:
boolean - .equals(obj)
int - .hashCode()
String - toString() --> overriden inside class, by default returns classname@hashcode

Objects class:
int - .hash(this.name, this.age)
int - .compare()
boolean - .equals(a, b) --> safe checks if element is null before checking equality.

String class:
boolean - .equals(name) / .equalsIgnoreCase()
int - .compareTo(name) / .compareToIgnoreCase()
boolean - .isEmpty() -> checks if length is 0

Collections class:
void - .sort(numsList) / (numsList, customCompare)
void - .reverse()

List interface:
void - .sort((Obj a, Obj b) -> {return a.name.comapreTo(b.name)}) / (customCompare) -> Comparator
List - .revered()

Arrays class:
List - .asList(12, 13, 14)

Comparator interface:
int - .compare(int i, int j) -> returns 1 if i > j, if i < y return -1, if i == y return 0
boolean - .equals(Object obj)

Integer class extends Number and implements Comparable:
int - .compare(int x, int y) -> return 1 if x > y, if x < y return -1, if x == y return 0
int - .compareTo() --> Not same as one in Comparable interface. This calls compare(). This is not static method, so ignore it.

Comparable interface:
.compareTo(T)
Integer, String etc. class implements Comparable, so Collections.sort(numList) works, but not custom class which doesnt implement comparator. numList.sort() needs comparator anyway (because it expects comparator).

Collection interface:
Stream<T> - .stream()

Stream interface:
Stream<T> - Stream.of(s.name, s.phone)
Stream<T> - .sorted() -> for objects, .sorted(Comparator.comparing(s -> s.name)) 
List - .toList()
Stream<T> - .filter(Predicate)
Stream<T> - .map(Function)
Stream<T> - .flatMap(s -> Stream.of(s.name, s.phone))
.collect(Collectors.toList())
long - .count
T - .reduce(accumulator, Binary operator)

numList.stream().sorted().toList() --> stream() & sorted() returns Stream<T>
numList.stream().sorted(Comparator.reverseOrder()).toList();

Function interface (FI):
R - apply(T) -> takes one function input and returns result of the function.

Predicate interface (FI):
boolean - test(T) -> tests a condition

List interface extends SequencedCollection interface extends Collection interface extends Iterable interface
Collections class

## Stream:
stream's intermediate operations only start to execute when we call a terminal operation(which returns not a stream).

## Type parameters:
<T> – the type of the input to the function
<R> – the type of the result of the function

*FI = Functional Interface

Can override default method, but not static methods in interface.

## FileInputStream, File Handling:
To read from properties file:
Properties class
    void - load(InputStream)
Since Properties class load func takes InputStream, we have to read properties file as InputStream:
```
FileInputStream fis = new FileInputStream("config.properties");
Properties prop = new Properties();
prop.load(fis)
int name = prop.getProperty("item-name");
```

## SimpleDateFormat, Calender:
```
try {
    SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

    Date date = inputFormat.parse(Date);
    String formattedDate = outputFormat.format(date);
} catch(Exception e) {}
```
setLenient

## Reference type and Object type:
Java makes a list of things that we can implement for a variable by looking at its reference type.
Animal a = new Dog();
If Dog as a method called bark, which is not declared in Animal, you can't do a.bark().
You have to typecase like:
Dog d = (Dog) a;

## Method level should be initialized:

## Parameterized Constructor:
If parent class has only parameterized constructor, then when you make an object of child class, you need to send arguments to the child constructor and call parent class's parameterized constructor with it. Otherwise, it will compiler error.

## Design Patterns:
Singleton
Factory
Immutable - Collections.unmodifiableList(list);

## Nested Class:
```
class Outer {
    static class StaticNested {
        void display() {
            System.out.println("Static nested class method.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.StaticNested nested = new Outer.StaticNested();
        nested.display();
    }
}
```