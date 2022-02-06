package com.example.oauth.auth.presentation;

import com.example.oauth.IntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthIntegrationTest extends IntegrationTest {

    @MockBean
    RestTemplate restTemplate;

    @DisplayName("로그인 / 리다이렉션 성공")
    @Test
    void login_oauth2_success() throws Exception {
        mockMvc.perform(get("/api/oauth2/authorization/{registrationId}", "kakao"))
                .andExpect(status().is3xxRedirection());
    }

    @DisplayName("로그인 / 리다이렉션 이후 로그인 성공")
    @Test
    void login_oauth2_obtain_access_token_success() throws Exception {

        // given
//        Mockito.when(restTemplate.exchange())
//                .thenReturn();
    }
}
