package com.example.marioradi.score;

import com.example.marioradi.user.User;
import com.example.marioradi.user.UserRepository;
import com.example.marioradi.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ScoreServiceImplTest {

    @Mock
    private ScoreRepository scoreRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    @Captor
    private ArgumentCaptor<Score> captor;

    @InjectMocks
    private ScoreServiceImpl scoreService;


    @Test
    public void shouldGetAuthenticatedUserTopScoreWhenPassedNull(){
        Mockito.when(userService.getAuthenticatedUserUsername()).thenReturn("Test");
        scoreService.findTopUserScore(null);
        verify(scoreRepository, Mockito.atMostOnce()).findTopByUsername("Test");
    }

    @Test
    public void shouldGetPassedUserTopScore(){
        scoreService.findTopUserScore("test");
        verify(scoreRepository, Mockito.atMostOnce()).findTopByUsername("test");
    }

    @Test
    public void shouldVerifyScoreSave(){
        User user = User.builder().username("test").build();
        when(userRepository.findUserByUsername(Mockito.anyString())).thenReturn(user);
        scoreService.saveScore("test", 0);
        verify(scoreRepository).save(captor.capture());

        assertEquals(user.getUsername(),captor.getValue().getUser().getUsername());
        assertEquals(0,captor.getValue().getValue());

    }

    @Test
    public void shouldReturnLeaderboardListFromTuple(){
        List<Tuple> tupleList = new ArrayList<>();
        when(scoreRepository.findTopScores(Mockito.any())).thenReturn(tupleList);
        List<LeaderBoardResponse> response = scoreService.getLeadBoard();
        assertEquals(response.size(),tupleList.size());
    }









}