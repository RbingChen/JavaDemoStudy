package com.cimon.charpter0;
import java.util.Random;
public class RunnableDemo implements Runnable{
    private Thread t;
    private String name;
    public RunnableDemo(String name){
        this.name = name;
        System.out.println("Creating thread "+name+"....");
    }
    public void run(){
        System.out.println("Running "+name);
        Random rnd = new Random();
        try{
            for(int i = 4;i>0;i--){
                System.out.println("Thread: "+name+","+i);
                Thread.sleep(rnd.nextInt(100));
            }
        }catch(InterruptedException e){
            System.out.println("Thread: "+name+" interrupted");
        }
        System.out.println("Thread "+ name +" exiting");
    }
    public void start(){
        System.out.println("Starting "+ name);
        if(t==null)
            t=new Thread(this,name);
        t.start();
    }

}
