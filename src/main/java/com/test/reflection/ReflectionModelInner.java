package com.test.reflection;

public class ReflectionModelInner {

    private Integer id;

    @Osman
    private String name;

    public ReflectionModelInner() {
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

    @Override
    public String toString() {
        return "ReflectionModelInner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
