package com.miniproject.yeolgongdabang.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserJoinRequestDto {

    @NotEmpty
    @Pattern(regexp = "^[0-9]{8}$")
    private String phone;
}
