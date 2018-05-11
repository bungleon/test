package com.test.lambdaexpressions;

import org.springframework.beans.factory.annotation.Autowired;

public class LambdaTest {
    FourOperationsInMath add = (a,b) -> (a + b);
    FourOperationsInMath sub = (a,b) -> a - b;
    FourOperationsInMath mult = (a,b) -> a * b;
    FourOperationsInMath divide = (a,b) -> a / b;

    public LambdaTest() {
    }
    interface FourOperationsInMath {
        int operate(int a, int b);
    }

    private int tryOperate(int a, int b, FourOperationsInMath mathOperation){
        return mathOperation.operate(a,b);
    }
    public void getOperations(){
        System.out.println("1 + 4 :  " + this.tryOperate(1, 4, add));
        System.out.println("9 - 5 :  " + this.tryOperate(9, 5, sub));
        System.out.println("5 * 3 :  " + this.tryOperate(5, 3, mult));
        System.out.println("8 / 4 :  " + this.tryOperate(8, 4, divide));
        System.out.println("");
    }
}

