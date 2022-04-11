package com.beaconfire.quizapp.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Question {

    private Integer id;
    private String content;
    private Integer categoryId;

}
