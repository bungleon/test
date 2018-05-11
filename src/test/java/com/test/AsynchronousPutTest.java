package com.test;

import com.test.controller.OtherController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AsynchronousPutTest {

    @Autowired
    private OtherController otherController;


    @Test
    public void test() {
        CompletableFuture.runAsync(() -> {
            otherController.test(0);
        });
        CompletableFuture.runAsync(() -> {
            otherController.test(1);
        });
        CompletableFuture.runAsync(() -> {
            otherController.test(2);
        });
        CompletableFuture.runAsync(() -> {
            otherController.test(3);
        });
        CompletableFuture.runAsync(() -> {
            otherController.test(4);
        });
        CompletableFuture.runAsync(() -> {
            otherController.test(5);
        });
        CompletableFuture.runAsync(() -> {
            otherController.test(6);
        });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
