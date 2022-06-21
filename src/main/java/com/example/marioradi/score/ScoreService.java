package com.example.marioradi.score;


import com.example.marioradi.auth.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ScoreService {


    private final ScoreRepository scoreRepository;


    public List<Score> getAllScoresByUser(User user){
        return scoreRepository.getScoresByUser(user);
    }




}
