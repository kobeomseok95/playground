package com.example.security.user.dto;

import lombok.Data;

@Data
public class KakaoProfile {

    public Integer id;
    public String connected_at;
    public Properties properties;
    public KakaoAccount kakao_account;
}