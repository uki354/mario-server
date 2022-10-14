package com.example.marioradi.score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    Score findTopByUser_Username(String username);


}
