package com.miniproject.yeolgongdabang.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnterResponseDto {

    private EnterCode code;
    private String phone;
    private int seatNo;
    private int remainingTime;
    private String shortDescription;
}
