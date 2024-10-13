package com.example;

import java.lang.reflect.Array;
/* ==============================================  imports ====================================== */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.stream.Stream;

import jakarta.el.ArrayELResolver;
import jakarta.faces.event.SystemEvent;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.Date;






































/* ==============================================  Classes & Interfaces ====================================== */
interface Greeting {

    void greeting();
}

/* Person Class */
class Person implements Comparable<Person> {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    /* Based on Age */
    @Override
    public int compareTo(Person p) {
        return Integer.compare(this.age, p.age);
    }

    /* Based on Name */
    // @Override
    // public int compareTo(Person p){
    // return this.name.compareTo(p.name);
    // }

    @Override
    public String toString() {
        return "name : " + this.name + "\t" + "age : " + this.age;
    }
}

/* inner classes */
class OuterClass {
    public OuterClass() {
        System.out.println("Inside outer class");
    }

    class InnerClass {
        public InnerClass() {
            System.out.println("Inside inner class");
        }
        // non-static inner class
    }
}

class Example {

    // Fields : static fields & instance fields
    private static int staticField = initializeStaticField();
    private int instanceField = initializeInstanceField();

    // Initializer Blocks : static & instance
    static {
        System.out.println(staticField); // 1
        System.out.println("Static initializer block");
    }

    {
        System.out.println(this.instanceField);
        System.out.println("Instance initializer block");
    }

    // constructor
    public Example() {
        System.out.println("Constructor");
    }

    private static int initializeStaticField() {
        System.out.println("Static field initialized");
        return 1;
    }

    private int initializeInstanceField() {
        System.out.println("Instance field initialized");
        return 2;
    }
}

class Employee {
    String name;
    int salary;
    int age;

    public Employee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}

/* Functional Interfaces */

@FunctionalInterface
interface Cab {
    public void abstractMethod1();
}

@FunctionalInterface
interface Cab2 {
    public String abstractMethod2(String name, int age);
}

class Product {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int price, String name) {
        this.name = name;
        this.price = price;
    }
}



class Student{
    String name;
    int id;
    char grade;
    int score;

    public Student(String name, int id, char grade){
        this.name = name;
        this.id = id;
        this.grade= grade;
    }

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
}
























/* ========================================= Main Class ========================================== */
public class App {

    static {
        System.out.println("Inside The 1st Block");
    }

    static {
        System.out.println("Inside The 2nd Block");
    }

    /* ================= Main Method ================= */
    public static void main(String[] args) {

        System.out.println("=========================================================");
        System.out.println("=========================================================");

        /* Anonymous class */
        Greeting annonymous = new Greeting() {
            @Override
            public void greeting() {
                System.out.println("Annonymous,!");
            }

        };
        annonymous.greeting();

        /* class name */
        System.out.println(new App().getClass().getName());

        /* compareTo() Method */
        System.out.println("---------------------");

        List<Person> people = new ArrayList<Person>();
        people.add(new Person(25, "ahmad"));
        people.add(new Person(99, "mahmoud"));
        people.add(new Person(15, "ali"));

        Collections.sort(people);

        for (var p : people) {
            System.out.println(p);
        }

        /* Class Litteral */
        System.out.println("---------------------");
        Class<String> stringClass = String.class;
        System.out.println(stringClass); // qualified name of the class ==> java.lang.String

        /* Copying arrays elements */
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = Arrays.copyOf(arr1, 3);
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));

        /* Inner Classes */
        System.out.println("---------------------");
        OuterClass outClass = new OuterClass();
        OuterClass.InnerClass innerClass = outClass.new InnerClass();

        /* Casting */
        int x = (int) 5.5; // Explicit casting from double to int
        System.out.println(x);

        /* Switch Case */
        System.out.println("---------------------");
        final int score1 = 8, score2 = 3;
        char myScore = 7;

        // The switch expression should use yield correctly and avoid syntax errors
        var goal = switch (myScore) {
            // Using a literal value instead of score1, since char values are expected
            case 8 -> "great";
            case 2, 4, 6 -> "good";
            case 3, 0 -> { // Using literals instead of score2
                yield "bad";
            }
            default -> {
                if (10 > score1)
                    yield "unknown"; // Spelling correction: "unkown" to "unknown"
                else
                    yield "not specified"; // Adding an else case to handle other scenarios
            }
        };

        System.out.println(goal);

        int z = 10, y = 15; // valid
        // var z = 10, y = 15; // error ==> var not valid in compound declaration

        /* Unreachable code results in Error */
        int data = 0;
        while (data < 10) {
            data++;
            if (data > 100) {
                break;
                // data++; // compiler error
            }
        }

        // order of execution of the class members
        System.err.println("---------------------------------");
        System.out.println("Main method started");
        Example example = new Example();
        Example example2 = new Example(); // static initializer block will be exe-cuted only one time before calling the
                                          // main

        System.out.println("=========================  Collections ============================");
        /*
         * Generic array that fixes the problem of that the array must contain
         * homogenous data
         */
        Object arr[] = new Object[3];
        arr[0] = "name : ahmad"; // string
        arr[1] = 29; // integer
        arr[2] = true; // boolean

        /* in the same array */
        System.out.println(arr[0]);
        System.out.println("age : " + arr[1]);
        System.out.println("single?:  " + arr[2]);

        // print them as list
        System.out.println(Arrays.asList(arr));

        System.out.println("---------------------");

        ArrayList al = new ArrayList<>();
        // ArrayList<String> al = new ArrayList<>(); // for this the add(Integer) and
        // add(Double) gives " Error "

        al.add("welcome");
        al.add(15);
        al.add(true);
        al.add(15.6);
        al.add('a');

        System.out.println(al); // print the list [welcome, 15, true, 15.6, a]
        System.out.println(al.size());

        /* Looping over a collection */

        /* normal for loop */
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
        /* enhanced for loop */
        for (var v : al)
            System.out.println(v);
        /* iterator */
        Iterator it = al.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("------------------");
        ArrayList<String> al2 = new ArrayList<>();
        al2.add("O");
        al2.add("F");
        al2.add("P");
        al2.add("C");
        al2.add("W");
        al2.add("X");
        al2.addFirst("ahmad");
        al2.addLast("Haroun");

        System.out.println("Before sorting : ");
        System.out.println(al2);

        Collections.sort(al2);

        System.out.println("After sorting : ");
        System.out.println(al2);

        Collections.reverse(al2);

        System.out.println("After reversing : ");
        System.out.println(al2);

        Collections.shuffle(al2);

        System.out.println("After Shuffle : ");
        System.out.println(al2);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("ahmad");
        linkedList.add("ragab");
        linkedList.add("mohamed");
        linkedList.add("haroun");

        System.out.println(linkedList);

        System.out.println("------------------");
        HashSet<String> hash = new HashSet<String>(); //

        hash.add("O");
        hash.add("F");
        hash.add("P");
        hash.add("C");
        hash.add("W");
        hash.add("X");

        System.out.println(hash.contains("P"));
        System.out.println(hash); // [P, C, F, W, X, O]

        // if you want to sort the hastset ==> convet it to list and sort
        List list = new ArrayList<>(hash);
        System.out.println(list); // [P, C, F, W, X, O]
        Collections.sort(list);
        System.out.println(list); // [C, F, O, P, W, X]

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("mourad");
        linkedHashSet.add("Raafat");
        linkedHashSet.add("mohamed");
        linkedHashSet.add("ali");

        System.out.println(linkedHashSet);
        System.out.println(linkedHashSet.getFirst());
        System.out.println(linkedHashSet.getLast());

        PriorityQueue priorityQueue = new PriorityQueue<>();

        priorityQueue.offer("ahmad");
        priorityQueue.offer("mohamed");
        priorityQueue.add("ali");

        // priorityQueue.add(500); // Error [because PriorityQueue contains Homogenous
        // Data only]

        System.out.println(priorityQueue);
        LinkedList linkeddList = new LinkedList<>();
        linkeddList.offer("ahmad");
        linkeddList.offer("mohamed");
        linkeddList.add("ali");
        linkeddList.add(500); // Acceptable [because LinkedList accepts Heterogenous Data]

        System.out.println(linkeddList);
        System.out.println("------------------");

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        hashMap.put(101, "ahmad");
        hashMap.put(102, "ali");
        hashMap.put(103, "mahmoud");
        hashMap.put(104, "ahmad");
        hashMap.put(105, "Rabeaa");

        System.out.println(hashMap); // {101=ahmad, 102=ali, 103=mahmoud, 104=ahmad, 105=Rabeaa}

        Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();

        System.out.print("{ ");
        int counter = 0;

        for (Map.Entry entry : entrySet) {
            counter++;
            if (counter == entrySet.size()) {
                System.out.print(entry.getKey() + "=" + entry.getValue());
                break;
            }
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("}");

        /* Another way to loop */

        Iterator it2 = hashMap.entrySet().iterator();

        while (it2.hasNext()) {
            System.out.print(it2.next() + "  ");
        }

        System.out.println("------------------");
        Hashtable hashTable = new Hashtable<>();

        hashTable.put(101, "ahmad");
        hashTable.put("age", 29); // acceptable because ==> hashTable is declared with generic HashTable type not
                                  // a specific one like HashTable<Integer,String>
        // hashTable.put(null, "ahmad"); // not allowed
        // hashTable.put(101, null); // not allowed

        System.out.println(hashTable);
        for (Object obj : hashTable.keySet()) {
            System.out.println(obj + " : " + hashTable.get(obj));
        }

        System.out.println("=========================================================");
        System.out.println("=========================================================");

        Cab cab = () -> System.out.println("Hello, From First Labmda Expression!");
        cab.abstractMethod1();

        Cab2 cab2 = (name, age) -> {
            System.out.println("name: " + name + "\tage: " + age);
            return "Success";
        };
        System.out.println(cab2.abstractMethod2("Ahmad", 29));

        /* Built-in Functional Interfaces */
        Predicate<Integer> objPredicate = (i) -> (i < 30);
        System.out.println(objPredicate.test(26));
        System.out.println(objPredicate.test(36));

        System.out.println("---------------");
        Predicate<String> objPredicate2 = (s) -> (s.length() > 5);
        System.out.println(objPredicate2.test("Welcome"));
        System.out.println(objPredicate2.test("xyz"));

        Employee emp = new Employee("ahmad", 35000, 29);
        Predicate<Employee> empPredicate = (e) -> (e.salary > 3000 || e.age > 25);
        System.out.println(empPredicate.test(emp));

        ArrayList<Employee> arrayList = new ArrayList<Employee>();

        arrayList.add(new Employee("ali", 70000, 59));
        arrayList.add(new Employee("ahmad", 50000, 44));
        arrayList.add(new Employee("mohamed", 24000, 72));
        arrayList.add(new Employee("sayed", 50000, 25));

        for (Employee e : arrayList) {
            if (empPredicate.test(e)) {
                System.out.println("name : " + e.name + "\t" + "age : " + e.age);
            }
        }

        int[] newArr = { 50, 66, 9, 15, 0, 458, 16, 13 };

        Predicate<Integer> arrPredicate1 = (i) -> (i % 2 == 0);
        Predicate<Integer> arrPredicate2 = (i) -> (i >= 50);

        for (int i : newArr) {
            // if(arrPredicate1.test(i) && arrPredicate2.test(i)){
            if (arrPredicate1.and(arrPredicate2).test(i)) { // Combined Predicate
                System.out.println(i);
            }
        }

        /* negate() */
        System.out.println("---------------");
        for (int i : newArr) {
            if (arrPredicate1.negate().test(i)) {
                System.out.println(i);
            }
        }

        System.out.println("---------------");
        Function<Integer, Integer> functionInterface = (i) -> (i * i);
        System.out.println(functionInterface.apply(10));

        Function<String, Integer> functionInterface2 = (s) -> s.length();
        System.out.println(functionInterface2.apply("Welcome to my home!"));

        Function<Employee, Integer> empFunction = (e) -> {
            if (e.salary > 10000 && e.salary < 20000)
                return (20 * e.salary / 100);
            else if (e.salary >= 20000 && e.salary < 30000)
                return (5 * e.salary / 100);
            else {
                return (2 * e.salary / 100);
            }
        };

        for (Employee e : arrayList) {
            System.out.println("Bounus : " + empFunction.apply(e));
        }

        System.out.println("---------------------");
        Function<Integer, Integer> f1 = (n) -> n * 2;
        Function<Integer, Integer> f2 = (n) -> n * n * n;

        /*
         * andThen()
         * compose()
         */
        System.out.println(f1.andThen(f2).apply(2)); // 64 ==> apply the lamda expression on f1 firsly then on f2
        System.out.println(f1.compose(f2).apply(2)); // 16 ==> apply the lamda expression on f2 firsly then on f2

        /* Consumer */
        Consumer<String> testConsumer = (s) -> System.out.println(s + " is white");
        Consumer<String> testConsumer2 = (s) -> System.out.println(s + " has four legs");

        testConsumer.andThen(testConsumer2).accept("cat");
        // testConsumer.compose(testConsumer2).accept("cat"); // error : compose is not
        // defined for Consumer

        /* supplier */
        Supplier<Date> testSupplier = () -> new Date();
        System.out.println(testSupplier.get()); // Fri Oct 11 21:48:32 EEST 2024

        System.out.println("------------ Streams ---------");
        List<Integer> newList = Arrays.asList(10, 15, 20, 25, 30);
        // List<Integer> evenList=
        // newList.stream().filter(n->n%2==0).collect(Collectors.toList());
        // System.out.println(evenList);

        // another way to print the filtered elements using method reference
        // newList.stream().filter(n->n%2==0).forEach(System.out::println);

        // another way to print the filtered elements using lamda expression
        newList.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();

        List<String> namesList = Arrays.asList("Ahmad", "Mourad", "Ragab", "Salma", "Mahmoud", "Hisham");
        // List<String> filteredList =
        // namesList.stream().filter(s->s.length()>6&&s.length()<8).collect(Collectors.toList());
        // System.out.println(filteredList);

        // another way to print the filtered elements using method reference
        namesList.stream().filter(s -> s.length() > 4 && s.startsWith("A")).forEach(System.out::println);

        List<String> newList2 = Arrays.asList("cup", null, "orange", "cake", "forest", null, null);
        // List<String> resuList =
        // newList2.stream().filter(s->s!=null).collect(Collectors.toList());
        // System.out.println(resuList);

        newList2.stream().filter(s -> s != null).forEach(System.out::println);

        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product(25000, "Hp Laptop"));
        productList.add(new Product(90000, "Mac book"));
        productList.add(new Product(37000, "Lenovo Laptop"));
        productList.add(new Product(14000, "Dell Laptop"));
        productList.add(new Product(50000, "new Laptop"));

        productList.stream()
                .filter(p -> p.getPrice() > 40000)
                .forEach(p -> System.out.println("name : " + p.getName() + "\t" + "price : " + p.getPrice()));


        System.out.println("---------------");
        /* map() method inside the stream interface*/
        List<String> vehicles = new ArrayList<String>();
        vehicles.add("bus");        
        vehicles.add("car");        
        vehicles.add("bicycle");        
        vehicles.add("motorcycle");        
        vehicles.add("scooter");
        
        // printing the collection objects after converting them to uppercase
        vehicles.stream().map(s->s.toUpperCase()).forEach(System.out::println); 

        // printing the lengthes of each object 
        vehicles.stream().map(name->name.length()).forEach(System.out::println);

        List<Employee> empList = Arrays.asList(
            new Employee("ahmad", 25000, 29),
            new Employee("ali", 26000, 30),
            new Employee("mohamed", 45000, 35),
            new Employee("nora", 55000, 55),
            new Employee("hossam", 24000, 23)
        );

        for(Employee e : empList){
            System.out.println("name : " + e.name +  "\t" + "salary : " + e.salary);
        }
        
        System.out.println("---------------------");
        empList.stream().filter(e -> e.age > 25).map(e -> {
            e.salary = (int) (e.salary * 0.2) + e.salary;
            return e;
        }).forEach(e -> System.out.println("name : " + e.name + "\t" + "salary : " + e.salary));
        
        System.out.println("---------------------");
        // difference between map() and flaMap()
        List<Integer> numberList = Arrays.asList(1,2,3,4,5);
        System.out.println(numberList.stream().map(n->n+10).collect(Collectors.toList()));


        List<Integer> listA = Arrays.asList(1,2);
        List<Integer> listB = Arrays.asList(3,4);
        List<Integer> listC = Arrays.asList(5,6);

        List<List<Integer>> finalList = Arrays.asList(listA,listB,listC);
        System.out.println("Final list before mapping : " + finalList);

        System.out.println("flatMap() with    mapping : " + finalList.stream().flatMap(o->o.stream().map(n->n+10)).collect(Collectors.toList()));
        System.out.println("flatMap() without mapping : " + finalList.stream().flatMap(o->o.stream()).collect(Collectors.toList()));

        // another example 
        System.out.println("---------------------");
        List<Student> list1 = Arrays.asList(
            new Student("ahmad", 101, 'A'),
            new Student("ali", 102, 'B'),
            new Student("othman", 103, 'C')
        ); 

        List<Student> list2 = Arrays.asList(
            new Student("mohamed", 1, 'A'),
            new Student("omar", 104, 'B'),
            new Student("abo-bakr", 105, 'B')
        ); 

        List<List<Student>> studList = Arrays.asList(list1,list2);
        System.out.println("flatMap() without mapping : " + studList.stream().flatMap(obj->obj.stream()).collect(Collectors.toList()));
        System.out.println("flatMap() with    mapping : " + studList.stream().flatMap(obj->obj.stream().map(o->o.name)).collect(Collectors.toList()));
        System.out.println("flatMap() count           : " + studList.stream().flatMap(obj->obj.stream().map(o->o.name)).collect(Collectors.toList()));

        System.out.println("-----------------------");
        List<Integer> numbersList1 = Arrays.asList(1,56,9,0,15,32,78,9,4,156);
        System.out.println("Ascending  Order : " + numbersList1.stream().sorted().collect(Collectors.toList()));
        System.out.println("descending Order : " + numbersList1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        
    
        Set<String> newSet = new HashSet<String>(Arrays.asList("mango","orange","juava","mariguana","banana","mango"));
        System.out.println(newSet);

        System.out.println("orange : " + newSet.stream().anyMatch(value->{return value.equals("orange");}));
        System.out.println("orange : " +newSet.stream().allMatch(value->{return value.equals("orange");}));
        System.out.println("orange : " +newSet.stream().noneMatch(value->{return value.equals("orange");}));

        List<String> list3 = Arrays.asList("one","two","three","four");
        //List<String> list3 = Arrays.asList(); ==> in case of empty list, no exception is thrown  
        System.out.println(list3.stream().findAny()); // returns any element it faces 


        /* =========== Streams Concatenation  =========== */
        List<String> concatStream1 = Arrays.asList("one","two","three","four");
        List<String> concatStream2 = Arrays.asList("five","six","seven","eight");

        Stream<String> streamA = concatStream1.stream();
        Stream<String> streamB = concatStream2.stream();
        
        Stream<String> resultStram = Stream.concat(streamA, streamB);
        System.out.println(resultStram.collect(Collectors.toList()));
    

        /* ========= Parrallel Streams ========= */ 
        List<Student> studentList = Arrays.asList(
            new Student("ahmad", 96),  
            new Student("mahmoud", 97),  
            new Student("tamer", 98),  
            new Student("ali", 97),  
            new Student("abdo", 99)  
        );

       // sequential strams
       studentList.stream().
                    filter(st->st.score>98).
                    limit(1)
                    .forEach(e->System.out.println("name : " + e.name + "\t" + " Score : " + e.score));

                    

       // parallel streaming
       studentList.parallelStream().filter(st -> st.score > 98)
                .limit(1)
                .forEach(e -> System.out.println("name : " + e.name + "\t" + " Score : " + e.score));



        /* ========= measuring the performance between sequential streaming and parallel streaming  =========  */
        // Create a large list of random numbers (size: 10 million)
        List<Integer> numbersList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_000_000; i++) {
            numbersList.add(random.nextInt(100));  // Random numbers between 0 and 100
        }

        // Sequential stream performance
        long startTimeSequential = System.currentTimeMillis();
        long countSequential = numbersList.stream()
                                          .filter(num -> num > 50)   // Filtering numbers greater than 50
                                          .count();                  // Count the filtered numbers
        long endTimeSequential = System.currentTimeMillis();
        System.out.println("Sequential Stream Count: " + countSequential);
        System.out.println("Time taken by Sequential Stream: " + (endTimeSequential - startTimeSequential) + " ms");

        // Parallel stream performance
        long startTimeParallel = System.currentTimeMillis();
        long countParallel = numbersList.parallelStream()
                                        .filter(num -> num > 50)     // Filtering numbers greater than 50
                                        .count();                    // Count the filtered numbers
        long endTimeParallel = System.currentTimeMillis();
        System.out.println("Parallel Stream Count: " + countParallel);
        System.out.println("Time taken by Parallel Stream: " + (endTimeParallel - startTimeParallel) + " ms");

        


        System.out.println("=========================================================");
        System.out.println("=========================================================");
    }
}
