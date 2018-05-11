package com.test.Async;

import com.test.events.AbsurtEvent;
import com.test.events.DomainEvent;
import com.test.events.TestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class AsyncTask {

    @Autowired
    DomainEvent domainEvent;

    @Async
    public void doAsyncTask(int no){

        for(int i=0;i<10;i++) {
            System.out.println("task= "+i+" no "+no);
            try {
                Thread.sleep(1000*i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Async
    public CompletableFuture<String> doAsyncTask2(int no){
        Random r=new Random();
        int a= r.nextInt(10);
        try {
            Thread.sleep(1000*a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("No "+ no + " Thread sleep " + a + "second");
    }
    @Async
    public void doAsyncTask3(int no) {
        Random r=new Random();
        int a= r.nextInt(10);
        try {
            Thread.sleep(1000*a );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task sleep = " + a + " seconds no " + no);
    }
    @Async
    public void doAsyncTask4(int no) {
        Random r=new Random();
        int a= r.nextInt(10);
        try {
            Thread.sleep(1000*a );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        domainEvent.fire(new TestEvent("task sleep = " + a + " seconds no " + no));
    }
    @Async
    public void doAsyncTask5(int no) {
        Random r=new Random();
        int a= r.nextInt(10);
        try {
            Thread.sleep(1000*a );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        domainEvent.fire(new AbsurtEvent("Osman","doAsyncTask5","task sleep = " + a + " seconds no " + no));
    }
}
