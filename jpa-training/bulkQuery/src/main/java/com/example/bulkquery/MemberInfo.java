package com.example.bulkquery;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberInfo {

    private String username;
    private String userAddress;
}
