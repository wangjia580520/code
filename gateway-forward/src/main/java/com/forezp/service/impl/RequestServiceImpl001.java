package com.forezp.service.impl;

import com.forezp.entity.ApiRequest;
import com.forezp.service.RequestService;
@ApiRequest("Impl001")
public class RequestServiceImpl001 implements RequestService {
    @Override
    public String invoke() {
        return "001";
    }
}
