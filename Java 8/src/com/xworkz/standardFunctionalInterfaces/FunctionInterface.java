package com.xworkz.standardFunctionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionInterface {
    public static void main(String[] args) {
        Function<Integer,Integer> square=x->x*x;
        Function<Integer,Integer> divideBy2=x->x/2;
        Integer[] nums={1,2,3,4};
     for(Integer i:nums){
         System.out.println(square.apply(i));
     }
     // and then method

    Integer ans=square.andThen(divideBy2).apply(5);
        System.out.println(ans);

// Bi function
        BiFunction<Integer,Integer,String> getString=(a,b)->{return (a+"")+b; };
       for(Integer i:nums){
           System.out.println(getString.apply(i,i));
       }

    }
}
