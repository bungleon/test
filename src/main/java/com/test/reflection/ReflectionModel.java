package com.test.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Mask(value = "Class Value")
public class ReflectionModel {

    Integer id;

    @Mask(value = "Field Value")
    String name;

    ReflectionModelInner reflectionModelInner;

    public ReflectionModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReflectionModelInner getReflectionModelInner() {
        return reflectionModelInner;
    }

    public void setReflectionModelInner(ReflectionModelInner reflectionModelInner) {
        this.reflectionModelInner = reflectionModelInner;
    }

    @Override
    public String toString() {
        return "ReflectionModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reflectionModelInner=" + reflectionModelInner.toString() +
                '}';
    }

    public String playMusic(String musicName) {
        return "Don't Listen " + musicName;
    }

    @Mask
    public String valueDefaultWrite() {

        try {
            Method method = this.getClass().getMethod("valueDefaultWrite");
            Mask mask = method.getAnnotation(Mask.class);
            return mask.value();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "false";
    }

    @Mask(value = "Changed Value")
    public String valueChangedWrite() {

        try {
            Method method = this.getClass().getMethod("valueChangedWrite");
            Mask mask = method.getAnnotation(Mask.class);
            return mask.value();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "false";
    }

    public String valueFieldWrite() {

        try {
            Field field = this.getClass().getDeclaredField("name");
            field.setAccessible(true);
            Mask mask = field.getAnnotation(Mask.class);
            return mask.value();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return "false";
    }

    public String valueClassdWrite() {
        Mask mask = this.getClass().getAnnotation(Mask.class);
        return mask.value();
    }
}
