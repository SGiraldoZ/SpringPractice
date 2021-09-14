package com.myPractice.Sebas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pruebas {

    @GetMapping(path = "/")
    public String hi(){
        return "CAISTE EN MI DNS";
    }
}
