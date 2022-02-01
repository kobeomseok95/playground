package com.example.oauth.auth.presentation;

import com.example.oauth.auth.service.CustomOAuth2Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    CustomOAuth2Service customOAuth2Service;

    @Test
    @DisplayName("oauth2 로그인 / 성공")
    void login_oauth2_success() throws Exception {

        // given

        // when, then, docs

    }
}