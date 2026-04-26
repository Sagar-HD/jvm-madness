package com.xworkz.functionalInterfaces;
@FunctionalInterface
public interface Book {
    void read();
    default void sayHi(){
        System.out.println("hi");
    }
    static void sayHello(){
        System.out.println("hello");
    }


}
