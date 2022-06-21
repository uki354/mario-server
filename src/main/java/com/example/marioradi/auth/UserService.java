package com.example.marioradi.auth;


public interface UserService {

    User getUser(String username);
    void createUser(User user);

}
