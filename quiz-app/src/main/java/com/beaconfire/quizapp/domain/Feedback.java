package com.beaconfire.quizapp.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Feedback {

    private Integer id;
    private String content;
    private Integer rating;

}
