package com.test;

import com.test.abstract_class_new.AbstractClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AbstractClassTest {
    @Test
    public void test() {
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void getAge() {
                System.out.println("30");
            }
        };
        abstractClass.getName();
        abstractClass.getAge();
    }
}
