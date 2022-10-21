package com.example.marioradi.score;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/score")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreServiceImpl scoreService;

    @PostMapping("/save")
    public void saveScore(@RequestBody Map<String, String> scoreObj){
        String username = scoreObj.get("username");
        int score = Integer.parseInt(scoreObj.get("score"));
        scoreService.saveScore(username, score);
    }

    @GetMapping("/{username}")
    public int findTopUserScore(@PathVariable(required = false) String username){
        return scoreService.findTopUserScore(username);
    }

    @GetMapping("/leaderboard")
    public List<LeaderBoardResponse> findTopScores(){
        return scoreService.getLeadBoard();
    }

}
