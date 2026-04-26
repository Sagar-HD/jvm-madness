package com.xworkz.unaryAndBinaryOperators;

import java.util.function.BinaryOperator;

public class Binary {
    public static void main(String[] args) {
        BinaryOperator<String> bi=(a,b)->{return a+b;};
        System.out.println(  bi.apply("sagar","shaiva"));
    }
}
