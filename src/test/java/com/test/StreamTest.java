package com.test;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.test.model.StreamTestModel;
import com.test.model.StreamTestModelDto;
import com.test.streams.IComponent;
import com.test.streams.IComponentImpl;
import com.test.streams.StreamExamples;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class StreamTest {
    StreamExamples streamExamples;

    List<StreamTestModel> streamTestModels;

    public void init(){
        streamExamples=new StreamExamples();
        streamTestModels=new ArrayList<>();
        Random random=new Random();
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+1,"a","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+1,"b","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+1,"c","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+2,"d","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+2,"e","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+5,"f","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+4,"g","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+1,"h","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+2,"i","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+4,"j","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+1,"k","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+6,"l","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+6,"m","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+4,"n","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+7,"o","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+9,"p","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+5,"q","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+4,"r","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+8,"t","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+8,"t","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+7,"u","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+5,"v","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+7,"w","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+9,"x","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+4,"y","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+7,"z","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+5,"aa","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+7,"ab","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+8,"ac","22",random.nextInt(10)+21));
        streamTestModels.add(new StreamTestModel(random.nextInt(10)+1,"ad","22",random.nextInt(10)+21));
    }

    @Test
    public void testStream1(){
        this.init();
        streamExamples.stream1(streamTestModels);
    }

    @Test
    public void testStream2(){
        this.init();
        streamExamples.stream2(streamTestModels);
    }

    @Test
    public void testStream3(){
        this.init();
        streamExamples.stream3(streamTestModels);
    }

    @Test
    public void testStream4(){
        this.init();
        streamExamples.stream4(streamTestModels);
    }

    @Test
    public void testStream5(){
        this.init();
        streamExamples.stream5(streamTestModels);
    }

    @Test
    public void testStream6(){
        this.init();
        streamExamples.stream6(streamTestModels);
    }

    @Test
    public void testStream7(){
        this.init();
        streamExamples.stream7(streamTestModels);
    }

    @Test
    public void testStream8(){
        //this.init();
        streamExamples=new StreamExamples();
        List<Supplier<StreamTestModel>> s=new ArrayList<>();
        streamExamples.stream8(s);
    }

    @Test
    public void testStream9(){
        this.init();
        streamExamples.stream9(streamTestModels);
    }

    @Test
    public void testStream10(){
        this.init();
        streamExamples.stream10(streamTestModels);
    }

    @Test
    public void testStream11(){
        this.init();
        streamExamples.stream11(streamTestModels);
    }

    @Test
    public void testStream12(){
        this.init();
        streamExamples.stream12(streamTestModels);
    }

    @Test
    public void testStream13(){
        streamExamples.stream13();
    }

    @Test
    public void testIComponentImpl(){
        IComponent c=new IComponentImpl();
        System.out.println(c.whatIsYourName("What is your name?"));
    }
    @Test
    public void ali() throws UnirestException {
        HttpResponse<String> stringHttpResponse = Unirest.post("https://mobil.teb.com.tr/cepteteb/CheckSecondFactor.json")
                .header("Cookie", "JSESSIONID=wjUL6tl0tg06-FBauOjkXQVZvPwXgBMiWXekc_tsmr7fYFf9pk1J!-701421664")
                .header("Content-Type" , MediaType.APPLICATION_JSON_UTF8_VALUE)
                .body("{\"deviceOsVersion\" : \"4.4.2\",\"appVersion\" : \"\",\"sifreNetIndex\" : -1,\"parola\" : \"371281\"}")
                .asString();
        System.out.println(stringHttpResponse.getBody());
    }

    @Test
    public void mapTest() {
        this.init();
        List<StreamTestModelDto> dto = streamTestModels.stream().map(StreamTestModelDto::new).collect(Collectors.toList());
        System.out.println(dto);
    }
}
