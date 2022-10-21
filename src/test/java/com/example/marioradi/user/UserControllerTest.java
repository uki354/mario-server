package com.example.marioradi.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;


    @InjectMocks
    private UserController userController;

    @Test
    public void shouldCallMethodToCreateUserOnce(){
        UserDto userDto = new UserDto("test", "test");
        userController.createNewUser(userDto);
        verify(userService, Mockito.atMostOnce()).createNewDefaultUser(userDto);
    }


}