package com.sagar.synchronised;

public class Counter {
    private int count=0;
    private  int count2=0;
    public synchronized void  syncIncrement(){
        count++;
    }
    public  void  increment(){
        count2++;
    }
    public int  getSyncCount(){
        return count;
    }
    public int  getCount(){
        return count2;
    }
}
