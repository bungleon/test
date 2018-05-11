package com.test;

import com.test.reflection.ReflectionModel;
import com.test.reflection.TryReflection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReflectionTest {

    @Test
    public void testReflection(){
        TryReflection reflection=new TryReflection();
        reflection.testReflection();
    }

    @Test
    public void testDefaultAnnotation(){
        ReflectionModel reflectionModel=new ReflectionModel();
        System.out.println("Annotation value = "+reflectionModel.valueDefaultWrite());
    }
    @Test
    public void testChangedAnnotation(){
        ReflectionModel reflectionModel=new ReflectionModel();
        System.out.println("Annotation value = "+reflectionModel.valueChangedWrite());
    }
    @Test
    public void testFieldAnnotation(){
        ReflectionModel reflectionModel=new ReflectionModel();
        System.out.println("Annotation value = "+reflectionModel.valueFieldWrite());
    }
    @Test
    public void testClassnnotation(){
        ReflectionModel reflectionModel=new ReflectionModel();
        System.out.println("Annotation value = "+reflectionModel.valueClassdWrite());
    }

}
