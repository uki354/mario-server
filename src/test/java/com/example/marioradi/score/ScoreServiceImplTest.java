package com.example.marioradi.score;

import com.example.marioradi.user.UserRepository;
import com.example.marioradi.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ScoreServiceImplTest {

    @Mock
    private ScoreRepository scoreRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

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









}