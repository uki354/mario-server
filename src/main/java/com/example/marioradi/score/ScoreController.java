package com.example.marioradi.score;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreRepository scoreRepository;


    @GetMapping("/scoreborad")
    public List<Score> getAllScoresByUser(){
        return scoreRepository.getScoreBoard(Pageable.ofSize(5));
    }


}
