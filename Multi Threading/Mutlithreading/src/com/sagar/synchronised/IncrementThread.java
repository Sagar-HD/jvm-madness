package com.sagar.synchronised;

public class IncrementThread extends Thread {
    Counter counter;
public IncrementThread(Counter counter) {
    this.counter = counter;
}
    @Override
    public void run() {
    for(int i=0;i<10000;i++) {
        counter.increment();
    }
    for(int i=0;i<10000;i++) {
            counter.syncIncrement();
        }
    }
}
