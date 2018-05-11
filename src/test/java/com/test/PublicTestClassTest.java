package com.test;


import com.test.model.PublicTestClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PublicTestClassTest {

    @Test
    public void testTestClass(){
        PublicTestClass t=new PublicTestClass();
        t.name="Merhaba Benim adım name :D";
        System.out.println(t.name);
    }
}
