package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestLogin {

    @NotNull(message = "Email can't be null")
    @Size(min = 2, message = "Email Not be less than two characters")
    @Email
    private String email;

    @NotNull(message = "Password can't be null")
    @Size(min = 8, message = "Password must be greater than 8 characters")
    @Email
    private String password;
}
