package com.sagar.seatBooking.individualSeatBlockingByReentrantLock;




import com.sagar.seatBooking.allSeatsBlockingBySynchronised.Status;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Threater {
    ArrayList<SafeSeat> seats=new ArrayList<>(10000);
AtomicInteger counter=new AtomicInteger(0);
    Threater() {

        for(int i=1;i<=5000;i++){
            this.seats.add(new SafeSeat(i, Status.AVAILABLE));
        }
    }
    public  void bookSeat(int seatNumber)  {
        if(seatNumber>5000 || seatNumber<1){
            System.out.println("Invalid Seat");
            return;
        }
        if(this.seats.get(seatNumber).lock.tryLock()) {
            if (this.seats.get(seatNumber).status == Status.AVAILABLE) {
                this.seats.get(seatNumber).status = Status.BLOCKED;
                Thread.yield();
                this.seats.get(seatNumber).status = Status.BOOKED;
                System.out.println("Seat booked from thread " + Thread.currentThread().getName());
                counter.incrementAndGet();
                this.seats.get(seatNumber).lock.unlock();

            } else {
                System.out.println("Seat is already booked");
                this.seats.get(seatNumber).lock.unlock();
            }
        }
        else{
            System.out.println("Seat locked try again");
        }
    }
    public void getBookedSeats(){

        System.out.println("Booked Seats: "+this.counter.get());
    }
}
