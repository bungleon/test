package com.test.events;

public class AbsurtEvent extends Event {
    String name;
    String adress;
    String message;
    public AbsurtEvent(String name,String adress,String message) {
        super(name);
        this.name = name;
        this.adress=adress;
        this.message=message;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "AbsurtEvent{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
