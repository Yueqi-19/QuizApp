package com.beaconfire.quizapp.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class QuizQuestion {

    private Integer id;
    private Integer quizId;
    private Integer questionId;
    private Integer selectedOptionId;

}
