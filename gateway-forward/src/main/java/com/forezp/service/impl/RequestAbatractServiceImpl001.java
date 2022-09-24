package com.forezp.service.impl;

import com.forezp.entity.ApiRequest;
import com.forezp.service.RequestAbstractService;

@ApiRequest("ab001")
public class RequestAbatractServiceImpl001 extends RequestAbstractService {
    @Override
    public String invoke() {
        return "abstract001";
    }
}
