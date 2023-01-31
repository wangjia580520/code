package com.forezp.valuefilter;

public class FilterEntity extends FilterParnetEntity{
    @FieldFilter(type = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
