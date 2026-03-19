package com.sot.springSecurityTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(path = "/secured")
    public String secured(){
        return "Access granted to GET '/secured'";
    }

    @GetMapping(path = "/read")
    public String read(){
        return "Access granted to GET '/read'";
    }
}
