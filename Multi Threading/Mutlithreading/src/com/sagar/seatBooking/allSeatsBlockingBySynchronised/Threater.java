package com.sagar.seatBooking.allSeatsBlockingBySynchronised;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Threater {
    ArrayList<Seat> seats=new ArrayList<>(10000);
AtomicInteger counter=new AtomicInteger(0);
    Threater() {

        for(int i=1;i<=5000;i++){
            this.seats.add(new Seat(i,Status.AVAILABLE));
        }
    }
    public synchronized void bookSeat(int seatNumber)  {
        if(seatNumber>5000 || seatNumber<1){
            System.out.println("Invalid Seat");
            return;
        }
        if(this.seats.get(seatNumber).status == Status.AVAILABLE){


            Thread.yield();
            this.seats.get(seatNumber).status = Status.BOOKED;
            System.out.println("Seat booked from thread "+Thread.currentThread().getName());
            counter.incrementAndGet();

        }
        else{
            System.out.println("Seat is already booked");
        }
    }
    public void getBookedSeats(){

        System.out.println("Booked Seats: "+this.counter.get());
    }
}
