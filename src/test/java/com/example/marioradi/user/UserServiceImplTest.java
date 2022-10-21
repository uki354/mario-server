package com.example.marioradi.user;

import com.example.marioradi.MarioradiApplication;
import com.example.marioradi.role.Role;
import com.example.marioradi.role.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Captor
    private ArgumentCaptor<User> captor;


    @Test
    public void shouldThrowRuntimeException_DuplicateUsername(){
        given(userRepository.existsByUsername("test")).willReturn(true);
        assertThrows(RuntimeException.class, () ->  userService.createNewDefaultUser(new UserDto("test", "test")));
    }

    @Test
    public void shouldSaveEncodeDUserPassword_AndFetchRole_AndSave(){
        given(userRepository.existsByUsername("test")).willReturn(false);
        given(roleRepository.findRoleByName(Mockito.anyString())).willReturn(new Role());

        UserDto testObj = new UserDto("test", "test");
        User userWithEncodedPassword =
                User.builder().username("test").password(passwordEncoder.encode("test")).build();
        userService.createNewDefaultUser(testObj);

        verify(userRepository).save(captor.capture());

        assertEquals(userWithEncodedPassword.getUsername(),captor.getValue().getUsername());
        assertEquals(userWithEncodedPassword.getPassword(), captor.getValue().getPassword());
    }

    @Test
    public void shouldReturnUsernameOfAuthenticatedUser(){
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("test","test");
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        String authenticatedUserUsername = userService.getAuthenticatedUserUsername();
        assertEquals(authenticatedUserUsername, authentication.getName());
    }

























}