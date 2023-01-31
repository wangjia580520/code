package com.forezp.valuefilter;

import com.alibaba.fastjson.JSONObject;

public class FilterTest {
    public static void main(String[] args) {
        FilterEntity filterEntity =new FilterEntity();
        filterEntity.setAdress("陕西省");
        filterEntity.setName("赵英俊");
        FilterList filterList =new FilterList();
        filterList.getFilters().add(filterEntity);
        System.out.println(JSONObject.toJSONString(filterList,new FilterFieldImpl()));
    }
}
