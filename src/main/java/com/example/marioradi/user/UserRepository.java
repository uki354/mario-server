package com.example.marioradi.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);
    @Query(value = "select u  from user u inner join u.roles where u.username = :username ")
    User findUserByUsernameAndFetchRoles(String username);
    boolean existsByUsername(String username);

}
