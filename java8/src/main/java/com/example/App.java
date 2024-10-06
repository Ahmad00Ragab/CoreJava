package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        

        

        System.out.println("=========================================================");
        System.out.println("=========================================================");
    }
}
