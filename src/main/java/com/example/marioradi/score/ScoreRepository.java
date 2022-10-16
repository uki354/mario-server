package com.example.marioradi.score;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    Score findTopByUser_Username(String username);
    @Query(value = "select max(s.value) from Score s  inner join s.user u where u.username = :username group by s.user.id")
    int findTopByUsername(String username);
    @Query(value = "select max(s.value) as score ,u.username as user  from Score s inner join s.user u group by s.user.id order by  max(s.value) desc ")
    List<Tuple> findTopScores(Pageable pageable);


}
