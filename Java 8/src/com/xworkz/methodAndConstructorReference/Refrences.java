package com.xworkz.methodAndConstructorReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
class Word{
    String word;
    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
public class Refrences {
    static class Test{
        public void display(String s){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        Function<String, String> function = String::toUpperCase;
        //static method reference
        list.stream().map(function).forEach(System.out::println);
        //instance method ref
        Test test=new Test();
        list.stream().map(function).forEach(test::display);
        //contructor refrence
        list.stream().map(Word::new).forEach(System.out::println);


    }
}
