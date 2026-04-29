package com.sagar.locks;



public class Printer extends Thread{
    Sheet sheet;
    public Printer(Sheet sheet, String name){
        super(name);
        this.sheet = sheet;
    }

    @Override
    public void run() {
        Data data=new Data(this.getName());

for(int i=0;i<10000;i++) {
    try {
        sheet.addData(data);
    }
    catch(Exception e) {

    }
}


    }
}
