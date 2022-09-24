package com.forezp.service.impl;

import com.forezp.entity.ApiRequest;
import com.forezp.service.RequestAbstractService;

@ApiRequest("ab002")
public class RequestAbatractServiceImpl002 extends RequestAbstractService {
    @Override
    public String invoke() {
        return "abstract002";
    }
}
