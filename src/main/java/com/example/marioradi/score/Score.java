package com.example.marioradi.score;


import com.example.marioradi.user.User;
import com.example.marioradi.util.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "score")
public class Score extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int value;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


}
