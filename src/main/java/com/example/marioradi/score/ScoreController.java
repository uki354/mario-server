package com.example.marioradi.score;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/score")
@RequiredArgsConstructor
public class ScoreController {

    @GetMapping("/save")
    public void saveScore(){

    }

}
