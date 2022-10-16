package com.example.marioradi.score;


import com.example.marioradi.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScoreServiceImpl implements ScoreService{

    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;

    @Override
    public void saveScore(String username, int value) {
        scoreRepository.save(Score.builder()
                .user(userRepository.findUserByUsername(username))
                .value(value).build());
    }

    @Override
    public int findTopUserScore(String username) {
        return scoreRepository.findTopByUsername(username);
    }

    @Override
    public List<LeaderBoardResponse> getLeadBoard() {
        List<Tuple> topScores = scoreRepository.findTopScores(PageRequest.of(0, 10));
        List<LeaderBoardResponse> topScoresList= new ArrayList<>();
        System.out.println(topScores.size());
//        topScores.stream().map(tuple -> topScoresList.add(LeaderBoardResponse.builder().username(tuple.get("user", String.class)).score(tuple.get("score", Integer.class)).build()));
        topScores.forEach(tuple -> topScoresList.add(LeaderBoardResponse.builder().username(tuple.get("user", String.class)).score(tuple.get("score", Integer.class)).build()));
        return topScoresList;




    }
}
