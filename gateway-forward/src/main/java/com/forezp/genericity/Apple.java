package com.forezp.genericity;

public class Apple extends Fruits{
    private String appleType;

    public Apple(String appleType) {
        this.appleType = appleType;
    }

    public String getAppleType() {
        return appleType;
    }

    public void setAppleType(String appleType) {
        this.appleType = appleType;
    }
}
