package com.tech552.springbootactuatordemo.endpoints;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id = "custom",enableByDefault = true)
@Component
public class MyCustomActuatorEndpoint {



    @ReadOperation
    public Map<String,String> myCustomActuatorEndpoint(){
        Map<String, String> hashMap=new HashMap<>();
        hashMap.put("id","Ok");
        return hashMap;
    }
}
