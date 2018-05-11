package com.test;


import com.test.locale.LocaleTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.MessageDigest;
import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocaleTestClassTest {
    @Autowired
    MessageSource m;

    @Test
    public void writeTr(){
        LocaleTest localeTest=new LocaleTest(m);
        Locale l=new Locale("tr","TR");
        localeTest.hello(l);
    }
    @Test
    public void writeEn(){
        LocaleTest localeTest=new LocaleTest(m);
        Locale l=new Locale("en","US");
        localeTest.hello(l);
    }
    @Test
    public void writeDefault(){
        LocaleTest localeTest=new LocaleTest(m);
        localeTest.hello();
    }
}
