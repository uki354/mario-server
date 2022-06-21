package com.example.marioradi.score;

import com.example.marioradi.auth.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {


    List<Score> getScoresByUser(User user);
    @Query("select s from Score s order by s.score desc")
    List<Score>  getScoreBoard(Pageable pageable);

}
