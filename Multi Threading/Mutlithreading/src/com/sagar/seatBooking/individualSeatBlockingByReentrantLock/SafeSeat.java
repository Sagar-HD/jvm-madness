package com.sagar.seatBooking.individualSeatBlockingByReentrantLock;


import com.sagar.seatBooking.allSeatsBlockingBySynchronised.Seat;
import com.sagar.seatBooking.allSeatsBlockingBySynchronised.Status;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeSeat {
    private int id;
    public Status status;
    Lock lock = new ReentrantLock();
    public SafeSeat(int id, Status status) {
        this.id = id;
        this.status = status;
    }
    public void getStatus() {
        this.status = Status.AVAILABLE;
    }
    public int getId() {
        return id;
    }

}
