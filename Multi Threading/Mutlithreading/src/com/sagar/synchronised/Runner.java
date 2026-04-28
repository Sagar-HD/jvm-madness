package com.sagar.synchronised;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
IncrementThread thread1=new IncrementThread(counter);
IncrementThread thread2=new IncrementThread(counter);
IncrementThread thread3=new IncrementThread(counter);
IncrementThread thread4=new IncrementThread(counter);
IncrementThread thread5=new IncrementThread(counter);
IncrementThread thread6=new IncrementThread(counter);
IncrementThread thread7=new IncrementThread(counter);
IncrementThread thread8=new IncrementThread(counter);
IncrementThread thread9=new IncrementThread(counter);
IncrementThread thread10=new IncrementThread(counter);
thread1.start();
thread2.start();
thread3.start();
thread4.start();
thread5.start();
thread6.start();
thread7.start();
thread8.start();
thread9.start();
thread10.start();
thread1.join();
thread2.join();
thread3.join();
thread4.join();
thread5.join();
thread6.join();
thread7.join();
thread8.join();
thread9.join();
thread10.join();
        System.out.println(counter.getSyncCount());
        System.out.println(counter.getCount());



    }
}
