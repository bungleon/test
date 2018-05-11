package com.test.model.request;

public class TransactionRequest {
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
