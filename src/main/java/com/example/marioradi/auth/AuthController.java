package com.example.marioradi.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping("/protected")
    public String protectedResource(){
        return "ok";
    }


}
