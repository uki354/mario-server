package com.example.marioradi.score;


import com.example.marioradi.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long score;
    @Basic
    private Timestamp timestamp;
    @ManyToOne
    private User user;

}
