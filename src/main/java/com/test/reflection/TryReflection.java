package com.test.reflection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TryReflection {

    public TryReflection() {
    }

    public void testReflection() {
        //New Reflection Inner Model
        ReflectionModelInner reflectionModelInner = new ReflectionModelInner();
        reflectionModelInner.setId(1);
        reflectionModelInner.setName("OZ");

        //New Reflection Model
        ReflectionModel reflectionModel = new ReflectionModel();
        reflectionModel.setId(11);
        reflectionModel.setName("Erman");
        reflectionModel.setReflectionModelInner(reflectionModelInner);

        ObjectMapper mapperObj = new ObjectMapper();
        //Try Map to JsonString
        try {
            String jsonStr = mapperObj.writeValueAsString(reflectionModel);
            System.out.println(jsonStr);
            reachToreflectionModels(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void reachToreflectionModels(String body) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Object object = mapper.readValue(body, Object.class);
            System.out.println(object);
            ReflectionModel reflectionModel = mapper.readValue(body, ReflectionModel.class);

            Field[] fields = object.getClass().getDeclaredFields();
            Field[] fields2 = reflectionModel.getClass().getDeclaredFields();
            Field[] fields3 = reflectionModel.getReflectionModelInner().getClass().getDeclaredFields();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Object = " + object.getClass());
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println("Field Name " + field + " Value = " + field.get(object));
                if (field.isAnnotationPresent(Mask.class)) {
                    System.out.println("Aslan Anotation : " + field + " Value = " + field.get(object));
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Reflection Model = " + reflectionModel.getClass());
            for (Field field : fields2) {
                field.setAccessible(true);
                System.out.println("Field Name " + field + " Value = " + field.get(reflectionModel));
                if (field.isAnnotationPresent(Mask.class)) {
                    System.out.println("Aslan Mask Anotation: " + field + " Value = " + field.get(reflectionModel));
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Inner Reflection Model = " + reflectionModel.getReflectionModelInner().getClass());
            for (Field field : fields3) {
                field.setAccessible(true);
                System.out.println("Field Name " + field + " Value = " + field.get(reflectionModel.getReflectionModelInner()));
                if (field.isAnnotationPresent(Osman.class)) {
                    System.out.println("Aslan Osman Anotation: " + field + " Value = " + field.get(reflectionModel.getReflectionModelInner()));
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Method[] methods = object.getClass().getMethods();
            Method[] methods2 = reflectionModel.getClass().getMethods();
            Method[] methods3 = reflectionModel.getReflectionModelInner().getClass().getMethods();
            for (Method method : methods) {
                method.setAccessible(true);
                System.out.println("Object Method.getName() = " + method.getName());
                if (method.getName().equals("toString")) {
                    System.out.println("Object method invoke = " + method.invoke(object, null));
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            for (Method method : methods2) {
                method.setAccessible(true);
                System.out.println("Reflection Model Method.getName() = " + method.getName());
                if (method.getName().equals("playMusic")) {
                    System.out.println("Reflection Model method invoke = " + method.invoke(reflectionModel, "Some Music"));
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            for (Method method : methods3) {
                method.setAccessible(true);
                System.out.println("Inner Reflection Model Method.getName() = " + method.getName());
                if (method.getName().equals("toString")) {
                    System.out.println("Inner Reflection Model method invoke = " + method.invoke(reflectionModel.getReflectionModelInner(), null));
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
