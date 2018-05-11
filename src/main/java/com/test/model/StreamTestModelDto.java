package com.test.model;

public class StreamTestModelDto {
    private Integer id;
    private String name;
    private String adress;
    private Integer age;

    public StreamTestModelDto(Integer id, String name, String adress, Integer age) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.age = age;
    }

    public StreamTestModelDto() {
    }

    public StreamTestModelDto(StreamTestModel streamTestModel) {

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StreamTestModelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", age=" + age +
                '}';
    }
}
