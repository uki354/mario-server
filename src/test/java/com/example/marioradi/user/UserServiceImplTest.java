package com.example.marioradi.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Captor
    private ArgumentCaptor<User> captor;


    @Test
    public void shouldThrowRuntimeException_DuplicateUsername(){
        given(userRepository.existsByUsername("test")).willReturn(true);
        assertThrows(RuntimeException.class, () ->  userService.createNewDefaultUser(new UserDto("test", "test")));
    }

    










}