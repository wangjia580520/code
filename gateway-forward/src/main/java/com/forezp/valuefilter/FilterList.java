package com.forezp.valuefilter;

import java.util.ArrayList;
import java.util.List;

public class FilterList {
    private List<FilterEntity> filters = new ArrayList<>();

    public List<FilterEntity> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterEntity> filters) {
        this.filters = filters;
    }
}
