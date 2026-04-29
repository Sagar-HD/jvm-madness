package com.sagar.seatBooking.allSeatsBlockingBySynchronised;

public class Seat {
    private int id;
    public Status status;
    public Seat(int id, Status status) {
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
