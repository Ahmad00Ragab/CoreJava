package com.example;

import javax.swing.text.html.ParagraphView;


/* ============== Class ============== */
class GenericBox<T>{
    private T item;
    public void setItem(T item){
        this.item = item;
    }
    public T getItem(){
        return this.item;
    }
}


/* ============== interface ============== */
interface  Pair<K,V>{
     K  getKey();
     V getValue();
}


class  PairImpl<K,V> implements Pair<K,V>{
    
    private K key;
    private V value;

    public PairImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public  K getKey() {
        return this.key;
    }

    @Override
    public V getValue(){
        return this.value;
    }

}



public class GenericsConcurrency {


    /* ============== Class ============== */
    /* Defining a Generic Method */
    public static <T> void printArray(T[] arr){
        for(T elem: arr){
            System.out.println(elem);
        }
    }

    /* ============== Bounded Type Parameter ============== */
    public static <T extends Number> double sum(T num1, T num2){
        return num1.doubleValue() + num2.doubleValue();
    } 


    public static void doWork() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(100); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interruption
            }
        }
    }


    public static void main(String[] args){
        
        System.out.println("========================================================================");
        System.out.println("========================================================================");
        System.out.println("========================================================================");

        /* ======== Gneric Class Example ======== */
        GenericBox<String> test1 = new GenericBox<>();
        test1.setItem("Hello");
        System.out.println(test1.getItem());
        GenericBox<Integer> test2 = new GenericBox<>();
        test2.setItem(1234);
        System.out.println(test2.getItem());

        /* ======== Gneric Interface Example ======== */
        PairImpl<Integer, String> test3 = new PairImpl<>(29,"Ahmad");
        System.out.println(test3.getKey());
        System.out.println(test3.getValue());
        PairImpl<Double, Boolean> test4 = new PairImpl<>(15000.00,true);
        System.out.println(test4.getKey());
        System.out.println(test4.getValue());

        /* ======== Gneric Method Example ======== */
        Integer[] arr1 = {1,2,3,4,5};
        String[] arr2 = {"Ahmad","Raafat","Mourad","Farid"};
        printArray(arr1);
        printArray(arr2);


        /* ======== Bounded Type Parameter Example ======== */
        System.out.println(sum(15, 15.5));
        System.out.println(sum(15, 13));

        System.out.println("-----------------------------------------------");
        Thread t1 = new Thread(GenericsConcurrency::doWork);
        Thread t2 = new Thread(GenericsConcurrency::doWork);
        
        t1.start();
        t2.start();

        // Main thread also executes its own run method
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Main Count: " + i);
            try {
                Thread.sleep(50); // Simulate main thread work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interruption
            }
        }


        // System.out.println("========================================================================");
        // System.out.println("========================================================================");
        // System.out.println("========================================================================");

    }
}
