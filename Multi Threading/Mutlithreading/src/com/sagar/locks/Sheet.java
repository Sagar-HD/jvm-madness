package com.sagar.locks;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sheet {

ArrayList<Data> lines=new ArrayList<>();
Lock lock=new ReentrantLock();
public void addData(Data data) throws InterruptedException {
if(lock.tryLock(5L, TimeUnit.MILLISECONDS)) {

        lines.add(data);

    lock.unlock();
}
else{
    System.out.println("resourse was locked");
}

}
public void getLines(){
    System.out.println(this.lines.size());
}
}
