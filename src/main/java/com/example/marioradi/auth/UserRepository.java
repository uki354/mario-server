package com.example.marioradi.auth;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {

    User getUserByUsername(String username);


}
