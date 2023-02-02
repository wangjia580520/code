package com.forezp.configwebmvc;

import org.springframework.stereotype.Service;

@Service
public class ConfigServceImpl implements ConfigService {
    @Override
    public String say() {
        return "say";
    }

    @Override
    public String eat() {
        return "eat";
    }

    @Override
    public String listen() {
        return "listener";
    }
}
