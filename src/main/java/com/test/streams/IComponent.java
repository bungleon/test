package com.test.streams;

@FunctionalInterface
public interface IComponent<T,R>{
     T get1(R r);
     default String whatIsYourName(String question){
          if("What is your name?".equals(question)) {
               return "Merhaba benim adım name";
          }
          return "I know only \"What is your name?\"";
     }
     static String name(){
          return "name";
     }
}
