package com.example.oauth.auth.presentation;

import com.example.oauth.auth.filter.TokenAuthenticationErrorFilter;
import com.example.oauth.auth.filter.TokenAuthenticationFilter;
import com.example.oauth.auth.handler.LoginFailureHandler;
import com.example.oauth.auth.handler.LoginSuccessHandler;
import com.example.oauth.auth.handler.RestAccessDeniedHandler;
import com.example.oauth.auth.handler.RestAuthenticationEntryPoint;
import com.example.oauth.auth.service.AuthService;
import com.example.oauth.auth.service.CustomOAuth2Service;
import com.example.oauth.auth.service.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AutoConfigureRestDocs
class AuthControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;

    // TODO Security Dependency
    @MockBean LoginFailureHandler loginFailureHandler;
    @MockBean LoginSuccessHandler loginSuccessHandler;
    @MockBean RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @MockBean RestAccessDeniedHandler restAccessDeniedHandler;
    @MockBean CustomOAuth2Service customOAuth2Service;
    @MockBean TokenAuthenticationFilter tokenAuthenticationFilter;
    @MockBean TokenAuthenticationErrorFilter tokenAuthenticationErrorFilter;
    @MockBean AuthService authService;
    @MockBean CustomUserDetailsService customUserDetailsService;

    @DisplayName("oauth2 로그인 / 리다이렉션 성공")
    @Test
    void login_oauth2_kakao_success() throws Exception {

        // when, then, docs
        mockMvc.perform(get("/api/oauth2/authorization/{provider}", "kakao"))
                .andExpect(status().is3xxRedirection())
                .andDo(print())
                .andDo(document("auth/{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("provider").description("OAuth2 소셜 로그인 제공자")
                        )));
    }
}