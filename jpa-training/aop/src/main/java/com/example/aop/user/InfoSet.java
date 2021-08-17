package com.example.aop.user;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoSet {

    Set<UserDto> userDto = new HashSet();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @EqualsAndHashCode(of = "userId")
    public static class UserDto {
        private Long userId;
        private String username;
    }
}
