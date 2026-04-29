package com.sagar.seatBooking.individualSeatBlockingByReentrantLock;



public class SafeCustomer extends Thread {
Threater threater;
    public SafeCustomer(Threater threater) {
        this.threater = threater;
    }
    @Override
    public void run() {
        for(int i=1;i<=4000;i++) {
            this.threater.bookSeat(i);
        }
    }
}
