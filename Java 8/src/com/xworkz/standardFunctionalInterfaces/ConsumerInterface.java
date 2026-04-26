package com.xworkz.standardFunctionalInterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {
        Consumer<Integer> print=x->{
            System.out.println(x);
        };
        print.accept(1);
        BiConsumer<Integer,Integer> print2=(x,y)->{
            System.out.println(x);
            System.out.println(y);
        };
        print2.accept(1,2);
    }
}
