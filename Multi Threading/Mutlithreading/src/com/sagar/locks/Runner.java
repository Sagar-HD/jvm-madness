package com.sagar.locks;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Sheet sheet = new Sheet();
        Printer printer1=new Printer(sheet,"Thread1");
        Printer printer2=new Printer(sheet,"Thread2");

        printer1.start();
        printer2.start();

        printer1.join();
        printer2.join();

sheet.getLines();

    }
}
