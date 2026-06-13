package org.example;

public class Sum {
    public int sum(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        Sum sum=new Sum();
        System.out.println(sum.sum(3,4));
    }
}
