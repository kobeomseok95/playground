package com.miniproject.yeolgongdabang.user.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DayTicketRequestDto {

    @NotEmpty
    @Pattern(regexp = "^[0-9]{8}$")
    private String phone;

    @NotNull
    private int seatNumber;

    @NotNull
    private Long ticketId;
}
