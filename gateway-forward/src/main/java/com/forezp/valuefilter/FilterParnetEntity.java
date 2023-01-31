package com.forezp.valuefilter;

public class FilterParnetEntity {
    @FieldFilter(type = "adress")
    private String adress;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
