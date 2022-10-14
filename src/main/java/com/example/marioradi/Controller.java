package com.example.marioradi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String helloWorld(){
        return "index.html";
    }

    @GetMapping("/protected")
    public @ResponseBody String protectedResource(){
        return "protected";
    }
}
