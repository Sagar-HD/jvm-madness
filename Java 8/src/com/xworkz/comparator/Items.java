package com.xworkz.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MyComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }

}

public class Items {


    public static void main(String[] args) {
        List<String> items = new ArrayList<String>();
        // Custom comparator using anonymous class
//        Comparator<String> comparator=new  Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        };
        items.add("banana");
        items.add("apple");

        items.add("lemon");

        items.add("cherry");
//custom comparator using lamba function

        Collections.sort(items,(o1,o2)->o2.compareTo(o1));

//custom comparator using class which implements comparator
        Collections.sort(items,new MyComparator());
        System.out.println(items);
    }
}
