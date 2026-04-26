package com.xworkz.standardFunctionalInterfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateFun {
    public static void main(String[] args) {
        Predicate<Integer> evenPred=(x)->x%2==0;
        Predicate<Integer> multipleOf3=(x)->x%3==0;
        Predicate<Integer> multipleOf4=(x)->x%4==0;
        Integer[] arr={1,2,3,4,5,6,7,8,24,32,12};
        for(Integer i:arr){
            if(evenPred.test(i)){
                System.out.println(i);
            }
        }
        System.out.println(".........");
        for(Integer i:arr){
            if(evenPred.negate().test(i)){
                System.out.println(i);
            }
        }
        System.out.println(".........");
        for(Integer i:arr){
            if(evenPred.and(multipleOf3).test(i)){
                System.out.println(i);
            }
        }
        System.out.println(".........");
        for(Integer i:arr){
            if(multipleOf3.or(multipleOf4).test(i)){
                System.out.println(i);
            }
        }
// Bi predicate
        BiPredicate<Integer,Integer> mod=(x,y)->x%y==0;
        for(Integer i:arr){
            System.out.println(mod.test(i,i));
        }
    }
}
