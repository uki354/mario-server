package com.example.marioradi.user;

import com.example.marioradi.role.Role;
import com.example.marioradi.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final static String DEFAULT_ROLE = "user";

    @Override
    @Transactional
    public void createNewDefaultUser(UserDto userDto) {
        if(!checkIfUserExists(userDto.getUsername())) {
            User user = createUser(userDto.getUsername(), userDto.getPassword());
            addDefaultRole(user);
            userRepository.save(user);

        }else throw new RuntimeException("User with \"" + userDto.getUsername() + "\" username already exists");
    }

    private boolean checkIfUserExists(String username){
        return userRepository.existsByUsername(username);
    }

    private User createUser(String username, String password){
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password)).build();
    }

    private void addDefaultRole(User user){
        Collection<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findRoleByName(DEFAULT_ROLE));
        user.setRoles(roles);
    }

    @Override
    public String getAuthenticatedUserUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
