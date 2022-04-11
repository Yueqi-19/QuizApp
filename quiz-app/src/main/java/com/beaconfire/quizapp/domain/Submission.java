package com.beaconfire.quizapp.domain;

import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Submission {

    private Integer id;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer score;
    private Integer userId;
    private Integer quizId;

}
