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




public class App {

    static {
        System.out.println("Inside The 1st Block");
    }

    static {
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


        System.out.println("=========================================================");
        System.out.println("=========================================================");
    }
}
