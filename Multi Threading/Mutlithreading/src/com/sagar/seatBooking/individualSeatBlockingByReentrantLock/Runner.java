package com.sagar.seatBooking.individualSeatBlockingByReentrantLock;



public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Threater threater = new Threater();
        SafeCustomer customer1=new SafeCustomer(threater);
       SafeCustomer customer2=new SafeCustomer(threater);
       SafeCustomer customer3=new SafeCustomer(threater);

        customer1.start();
        customer2.start();
        customer3.start();
        customer1.join();
        customer2.join();
        customer3.join();
  threater.getBookedSeats();

    }
}
