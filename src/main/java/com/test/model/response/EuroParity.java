package com.test.model.response;

public class EuroParity {
    private String base;
    private String date;
    private Rate rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rate getRates() {
        return rates;
    }

    public void setRates(Rate rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "EuroParity{" +
                "base='" + base + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
