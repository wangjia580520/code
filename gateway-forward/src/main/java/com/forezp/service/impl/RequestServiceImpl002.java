package com.forezp.service.impl;

import com.forezp.entity.ApiRequest;
import com.forezp.service.RequestService;

@ApiRequest("Impl002")
public class RequestServiceImpl002 implements RequestService {
    @Override
    public String invoke() {
        return "002";
    }
}
