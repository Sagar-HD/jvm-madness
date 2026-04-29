package com.sagar.seatBooking.allSeatsBlockingBySynchronised;

public class Customer extends Thread {
    Threater threater;
    public Customer(Threater threater) {
        this.threater = threater;
    }
    @Override
    public void run() {
        for(int i=1;i<=4000;i++) {
            this.threater.bookSeat(i);
        }
    }
}
