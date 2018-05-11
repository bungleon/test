package com.test.component;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.test.Async.AsyncTask;
import com.test.lambdaexpressions.LambdaTest;
import com.test.model.response.EuroParity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class ScheduledTask {

    int taskNo = 1;
    @Autowired
    AsyncTask task;
    @Autowired
    LambdaTest test;
    /*
    * Test Application Class'ında @EnableScheduling anotation'ı kullanılarak ScheduleTask enable edildi @Scheduled yapısı
    * ile de zamanlanmış görevler çalıştırılmaya başlandı.
    *
    * */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //1 sanıye için 1000 yazılacak.
    //@Scheduled(fixedRate = 1000*60)
    public void firstMethod() {

        System.out.println("First method:" + dateFormat.format(new Date()));
        //HttpResponse<JsonNode> obj=null;
        HttpResponse<String> obj = null;

        try {
            obj = Unirest.get("http://api.fixer.io/latest").asString();

        } catch (Exception e) {
            System.out.println("exception ocuurs " + e.getMessage());
        }
        /*System.out.println(obj.getBody());
        System.out.println();
        System.out.println(obj.getRawBody());
        System.out.println();
        System.out.println(obj.getStatus());
        System.out.println();
        System.out.println(obj.getStatusText());
        System.out.println();*/
        JSONObject object = new JSONObject(obj.getBody());
        /*System.out.println("json:");
        System.out.println(object);*/
        //Converting JSONObject to Model
        Gson gson = new Gson();
        EuroParity euroParity = gson.fromJson(object.toString(), EuroParity.class);
        /*System.out.println(euroParity.toString());
        System.out.println(euroParity.getRates().toString());*/
        //double l=Double.parseDouble(euroParity.getRates().getTRY());
        //double usd=l*100;
        float a = Float.parseFloat(euroParity.getRates().getTRY());
        float usd = a * 100;
        System.out.println("100 EUR = " + usd + " TRY");
    }

    //@Scheduled(fixedDelay = 7000)
    public void secondMethod() {
        System.out.println("Second method run with fixed delay :" + dateFormat.format(new Date()));
        task.doAsyncTask3(taskNo);
        taskNo++;
    }

    //@Scheduled(fixedDelay = 7000,initialDelay = 10000)
    public void thirdMethod() {
        System.out.println("Third method run with Async Method:" + dateFormat.format(new Date()));
        //String retValue;
        //System.out.println(task.doAsyncTask2(taskNo));
        CompletableFuture<String> retValue = task.doAsyncTask2(taskNo);
        //task.doAsyncTask2(taskNo)
        //CompletableFuture.allOf(retValue).join();
        try {
            System.out.println(retValue.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        taskNo++;
    }
    //@Scheduled(fixedDelay = 7000)
    public void fourthMethod() {
        System.out.println("Fourth method run with fixed delay :" + dateFormat.format(new Date()));
        task.doAsyncTask4(taskNo);
        taskNo++;
    }
    //@Scheduled(fixedDelay = 5000)
    public void fifthhMethod() {
        System.out.println("Fifth method run with fixed delay :" + dateFormat.format(new Date()));
        task.doAsyncTask5(taskNo);
        taskNo++;
    }
    //@Scheduled(fixedDelay = 10000)
    public void sixthhMethod() {

        test.getOperations();
    }
    //@Scheduled(fixedDelay = 10000)
    public void seventhhMethod() {
        Arrays.stream(new int[] {1, 3, 5})
                .map(degisken -> 2 * degisken + 1)
                .average()
                .ifPresent(System.out::println);
    }
}
