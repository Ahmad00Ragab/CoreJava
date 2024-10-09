package com.example;


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
import java.util.Set;




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

/* inner classes  */
class OuterClass{
    public OuterClass(){
        System.out.println("Inside outer class");
    }
	class InnerClass{
        public InnerClass(){
            System.out.println("Inside inner class");
        }
		// non-static inner class 
	}
}


class Example {

    // Fields : static fields & instance fields
    private static int staticField = initializeStaticField();
    private int instanceField      = initializeInstanceField();

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





public class App {


    static {
        System.out.println("Inside The 1st Block");
    }

    static{
        System.out.println("Inside The 2nd Block");
    }

    

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
        int x = (int)5.5; // Explicit casting from double to int
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
                if (10 > score1) yield "unknown"; // Spelling correction: "unkown" to "unknown"
                else yield "not specified"; // Adding an else case to handle other scenarios
            }
        };
        
        System.out.println(goal);


        int z = 10, y = 15; // valid
        // var z = 10, y = 15; // error ==> var not valid in compound declaration

        

        /* Unreachable code results in Error */
        int data = 0;
        while(data < 10){
                data++;
                if(data > 100){
                        break;
                        // data++; // compiler error 
                }
        }


        // order of execution of the class members 
        System.err.println("---------------------------------");
        System.out.println("Main method started");
        Example example = new Example();
        Example example2 = new Example(); // static initializer block will be exe-cuted only one time before calling the main


        System.out.println("=========================  Collections ============================");
        /* Generic array that fixes the problem of that the array must contain homogenous data  */
        Object arr[] = new Object[3];
        arr[0] = "name : ahmad"; // string
        arr[1] = 29; // integer
        arr[2] = true; // boolean 

        /* in the same array  */
        System.out.println(arr[0]);
        System.out.println("age : " + arr[1]);
        System.out.println("single?:  " + arr[2]);

        // print them as list 
        System.out.println(Arrays.asList(arr));
        

        System.out.println("---------------------");

        ArrayList al = new ArrayList<>();
        // ArrayList<String> al = new ArrayList<>(); // for this the add(Integer) and add(Double) gives " Error "
        
        al.add("welcome");
        al.add(15);
        al.add(true);
        al.add(15.6);
        al.add('a');

        
        
        System.out.println(al); // print the list [welcome, 15, true, 15.6, a]
        System.out.println(al.size()); 
        
        /* Looping over a collection  */
        
        /* normal for loop */
        for(int i = 0; i < al.size(); i++){
            System.out.println(al.get(i));
        }
        /* enhanced for loop */
        for(var v : al)
            System.out.println(v);
        /*  iterator */
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
        System.out.println(hash); //         [P, C, F, W, X, O]


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
        
        // priorityQueue.add(500); // Error [because PriorityQueue contains Homogenous Data only]

        System.out.println(priorityQueue);
        LinkedList linkeddList = new LinkedList<>();
        linkeddList.offer("ahmad");
        linkeddList.offer("mohamed");
        linkeddList.add("ali");
        linkeddList.add(500); // Acceptable [because LinkedList accepts Heterogenous Data]
        
        System.out.println(linkeddList);
        System.out.println("------------------");
        
        HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
        
        hashMap.put(101,"ahmad");
        hashMap.put(102,"ali");
        hashMap.put(103,"mahmoud");
        hashMap.put(104,"ahmad");
        hashMap.put(105,"Rabeaa");

        System.out.println(hashMap); // {101=ahmad, 102=ali, 103=mahmoud, 104=ahmad, 105=Rabeaa}

        Set<Map.Entry<Integer,String>> entrySet  = hashMap.entrySet();

        System.out.print("{ ");
        int counter = 0;
       
        for(Map.Entry entry : entrySet){
            counter++;
            if(counter == entrySet.size()){
                System.out.print(entry.getKey() + "=" + entry.getValue());
                break;
            }
            System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("}");

        /* Another way to loop  */

        Iterator it2 = hashMap.entrySet().iterator();

        while(it2.hasNext()){
            System.out.print(it2.next() + "  ");
        }
        
        System.out.println("------------------");
        Hashtable hashTable = new Hashtable<>();
        
        hashTable.put(101, "ahmad");
        hashTable.put("age", 29); // acceptable because ==> hashTable is declared with generic HashTable type not a specific one like HashTable<Integer,String>
        // hashTable.put(null, "ahmad"); // not allowed
        // hashTable.put(101, null);  // not allowed
        

        System.out.println(hashTable);
        for(Object obj : hashTable.keySet()){
            System.out.println(obj + " : " + hashTable.get(obj));
        }


        
        System.out.println("\n=========================================================");
        System.out.println("=========================================================");
    }
}
