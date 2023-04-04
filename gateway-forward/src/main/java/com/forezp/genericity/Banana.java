package com.forezp.genericity;

public class Banana extends Fruits{
    private String bananaType;

    public Banana(String bananaType) {
        this.bananaType = bananaType;
    }

    public String getBananaType() {
        return bananaType;
    }

    public void setBananaType(String bananaType) {
        this.bananaType = bananaType;
    }
}
