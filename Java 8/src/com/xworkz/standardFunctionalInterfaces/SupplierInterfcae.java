package com.xworkz.standardFunctionalInterfaces;

import java.util.function.Supplier;

public class SupplierInterfcae {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());
        // no bi supplier bcs only 1 output
    }
}
