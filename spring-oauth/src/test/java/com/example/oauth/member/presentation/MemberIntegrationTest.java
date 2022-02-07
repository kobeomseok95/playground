package com.example.oauth.member.presentation;

import com.example.oauth.IntegrationTest;
import com.example.oauth.support.WithMockJwt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberIntegrationTest extends IntegrationTest {

    @WithMockJwt
    @DisplayName("나의 정보 조회 / 성공")
    @Test
    void api_me_success() throws Exception {

        // when, then
        mockMvc.perform(get("/api/me"))
                .andExpect(status().isOk());
    }
}
