package com.xworkz.functionalInterfaces;
class HeadFirstServletBook implements Book{

    @Override
    public void read() {
        System.out.println("HeadFirstServletBook reading");
    }
   //Cannot overide static methods just adding its own
    public static void sayHello(){
        System.out.println("HeadFirstServletBook saying hello");
    }
}
public class Library {

    public static void main(String[] args) {
        //anonymous class
        Book book=new Book() {
            @Override
            public void read() {
                System.out.println("reading book");
            }
        };
        book.read();

        //lambda function
        book=()->System.out.println("reading any other book");
        book.read();
        //class that implements interface
        book=new HeadFirstServletBook();
        book.read();
    //running default method
     book.sayHi();
     //running static methods
     Book.sayHello();
     // running static say hello of implenentation cannot overide no polymorphism
        HeadFirstServletBook.sayHello();



    }
}
