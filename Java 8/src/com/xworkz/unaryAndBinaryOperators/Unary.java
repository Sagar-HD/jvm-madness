package com.xworkz.unaryAndBinaryOperators;

import java.util.function.UnaryOperator;

public class Unary {
    public static void main(String[] args) {
        UnaryOperator<String> operator = String::toUpperCase;
        System.out.println(operator.apply("hello"));
    }
}
