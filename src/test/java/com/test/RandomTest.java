package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class RandomTest {

    @Test
    public void randomTest(){
        Random random=new Random();
        Integer[] counts=new Integer[101];
        for(int i=0;i<101;i++){
            counts[i]=0;
        }
        for(int i=0;i<1000000;i++){
            counts[random.nextInt(100)+1]++;
        }
        for(int i=1;i<101;i++){
            System.out.print(counts[i]);
            double percent=(double)counts[i]/10000;
            System.out.println(" %"+percent);
        }
    }
}
