package com.springtrial.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VersionController {
//    injecting app version created in application.properties into the controller by using the @Value annotation
    @Value("${app.version}")
    private String appVersion;

    @Value("${version.updatedBy}")
    private String updatedBy;

    /*returning a map type
    * Since Jackson is the marshaler for objects to JSON,
    * it'll take the map and its key-value pairs
    * & just print them back out to the response as a JSON payload. */
    @GetMapping("/")
    public Map getVersion(){
        Map myMap = new HashMap<String,String>();
        myMap.put("app-version",appVersion);
        myMap.put("updated-by",updatedBy);
        return myMap;
    }
}
