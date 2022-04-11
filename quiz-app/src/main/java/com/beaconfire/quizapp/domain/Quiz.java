package com.beaconfire.quizapp.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Quiz {

    private Integer id;
    private String name;
    private Integer categoryId;

}
