package com.test;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.test.model.request.JudgeLockRequest;
import com.test.model.response.JudgeLockResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JudgeLockTest {

    @Test
    public void lockTransaction1() throws UnirestException {
        for (int i = 1; i < 51; i++) {
            send(319, i);
        }
    }

    @Async
    public void send(Integer id, int i) throws UnirestException {
        JudgeLockRequest judgeLockRequest = new JudgeLockRequest();
        judgeLockRequest.setId(id);
        judgeLockRequest.setReferenceNo(UUID.randomUUID());

        //String uri = new String("http://localhost:8087//api/v1/transaction/lock");
        String uri = "https://qa-wd.paymentspace.net/api/v1/transaction/lock";
        HttpResponse<JudgeLockResponse> response = Unirest.post(uri)
                .header("Authorization", "Basic ZXJtYW46MTIzNDU2")
                .header("X-AUTH-TOKEN", "uz2YUz5EC4pq2LbswwsQeVTg")
                //.header("Authorization","Basic ZXJtYW46MTIzNDU2")
                //.header("X-AUTH-TOKEN", "123")
                .body(judgeLockRequest)
                .asObject(JudgeLockResponse.class);
        if(i<10){
            System.out.println(i + "      " + response.getBody().toString());
        }else {
            System.out.println(i + "     " + response.getBody().toString());
        }
    }


}
