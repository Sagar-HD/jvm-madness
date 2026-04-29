package com.sagar.seatBooking.allSeatsBlockingBySynchronised;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Threater threater = new Threater();
        Customer customer1=new Customer(threater);
        Customer customer2=new Customer(threater);
        Customer customer3=new Customer(threater);

        customer1.start();
        customer2.start();
        customer3.start();
        customer1.join();
        customer2.join();
        customer3.join();
  threater.getBookedSeats();

    }
}
