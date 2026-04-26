package com.xworkz.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d", "e", "f", "g"};

        List<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(strings));

        list.stream().filter(s -> s.length()<2).forEach(System.out::println);
//methods to create stream
        Stream<String> stream = Stream.of("a", "b", "c", "d", "e", "f", "g");
        stream=Arrays.stream(strings);
      List<String> newlist = stream.filter(s -> s.length()<2).collect(Collectors.toList());
        System.out.println(newlist);
       Long ans= newlist.stream().filter((s)-> {
            return s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u");
        }).count();
        System.out.println(ans);

    }
}
