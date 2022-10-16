package com.example.marioradi.score;

import javax.persistence.Tuple;
import java.util.List;

public interface ScoreService {

    void saveScore(String username, int value);
    int findTopUserScore(String username);
    List<LeaderBoardResponse> getLeadBoard();
}
