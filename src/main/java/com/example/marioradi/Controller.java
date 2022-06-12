package com.example.marioradi;

import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping
    public String helloWorld(){
        return "index.html";
    }
}
