package com.test.locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class LocaleTest {

    private final MessageSource messageSource;

    @Autowired
    public LocaleTest(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void hello(Locale locale){

        String hello=messageSource.getMessage("welcome.message",null,locale);
        System.out.println(locale);
        System.out.println(hello);
    }
    public void hello(){
        String hello=messageSource.getMessage("welcome.message",null,Locale.getDefault());
        System.out.println(Locale.getDefault());
        System.out.println(hello);
    }
}
