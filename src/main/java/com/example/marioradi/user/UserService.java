package com.example.marioradi.user;

public interface UserService {

    void createNewDefaultUser(UserDto userDto);
    String getAuthenticatedUserUsername();

}
