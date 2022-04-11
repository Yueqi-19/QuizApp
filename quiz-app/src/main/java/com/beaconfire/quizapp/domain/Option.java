package com.beaconfire.quizapp.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Option {

    private Integer id;
    private String content;
    private Integer questionId;
    private Boolean isCorrect;

}
