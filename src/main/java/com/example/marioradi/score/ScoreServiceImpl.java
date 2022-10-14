package com.example.marioradi.score;


import com.example.marioradi.user.User;
import com.example.marioradi.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScoreServiceImpl implements ScoreService{

    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;

    @Override
    public void saveScore(String username, int value) {
        scoreRepository.save(Score.builder()
                .user(new User())
                .value(value).build());

    }
}
