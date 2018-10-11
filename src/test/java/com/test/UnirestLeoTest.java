package com.test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UnirestLeoTest {

    static Integer i;

    /*@Test
    public void sendPost() throws UnirestException {
        for (Integer ig = 1; ig < 1000; ig++) {
            new Thread(() -> {
                for (Integer j = 1; j < 1000; j++) {
                    try {
                        //post(i * j);
                    } catch (UnirestException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }*/


    public void post(String key) throws UnirestException {
        HttpResponse<String> stringHttpResponse = Unirest.post("https://qa-api.paymentheart.com/app-tx-location/pin")
                .header("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE)
                .body("{\n" +
                        "\"code\" : " + key + "\n" +
                        "}")
                .asString();

        String body = stringHttpResponse.getBody();
        JSONObject object = new JSONObject(body);
        if ("100".equals(object.get("code"))) {
            System.out.println(body);
        }
    }

    @Test
    public void sendPost2() {
        for (Integer i = 100000; i < 1000000; i++) {
            Unirest.post("https://qa-api.paymentheart.com/app-tx-location/pin")
                    .header("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .body("{\n" +
                            "\"code\" : " + i.toString() + "\n" +
                            "}")
                    .asStringAsync(new Callback<String>() {
                        @Override
                        public void completed(HttpResponse<String> response) {
                            JSONObject object = new JSONObject(response.getBody());
                            if ("100".equals(object.get("code"))) {
                                System.out.println(object.toString());
                            }
                        }

                        @Override
                        public void failed(UnirestException e) {

                        }

                        @Override
                        public void cancelled() {

                        }
                    });
        }
    }
}
