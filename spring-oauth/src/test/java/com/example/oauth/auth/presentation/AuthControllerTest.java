package com.example.oauth.auth.presentation;

import com.example.oauth.SecuritySupport;
import com.example.oauth.auth.dto.AuthResponse;
import com.example.oauth.config.RestDocsConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(RestDocumentationExtension.class)
@Import(RestDocsConfig.class)
class AuthControllerTest extends SecuritySupport {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;
    @Autowired WebApplicationContext ctx;
    @Autowired RestDocumentationResultHandler restDocs;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider provider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx)
                .apply(documentationConfiguration(provider))
                .apply(springSecurity())
                .alwaysDo(print())
                .alwaysDo(restDocs)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @DisplayName("oauth2 로그인 / 리다이렉션 성공")
    @Test
    void login_oauth2_kakao_success() throws Exception {

        // when, then, docs
        mockMvc.perform(get("/api/oauth2/authorization/{provider}", "kakao"))
                .andExpect(status().is3xxRedirection())
                .andDo(print())
                .andDo(restDocs.document(
                        pathParameters(
                                parameterWithName("provider").description("OAuth2 소셜 로그인 제공자")
                        )));
    }

    @DisplayName("로그아웃 / 성공")
    @Test
    void logout_success() throws Exception {

        // when, then, docs
        mockMvc.perform(post("/api/logout")
                .header("Authorization", "Bearer exampleAccessToken")
                .header("refreshToken", "Bearer exampleRefreshToken"))
                .andExpect(status().isOk())
                .andDo(restDocs.document(
                        requestHeaders(
                                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT Access Token"),
                                headerWithName("refreshToken").description("JWT Refresh Token")
                        )
                ));
    }

    @DisplayName("토큰 재발급 / 성공")
    @Test
    void reissue_success() throws Exception {

        // given
        Mockito.when(authService.reissue())
                .thenReturn(AuthResponse.of("newAccessToken", "newRefreshToken"));

        // when, then, docs
        mockMvc.perform(post("/api/reissue")
                .header("Authorization", "Bearer exampleAccessToken"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tokenType", is("Bearer")))
                .andExpect(jsonPath("$.accessToken", is("newAccessToken")))
                .andExpect(jsonPath("$.refreshToken", is("newRefreshToken")))
                .andDo(restDocs.document(
                        requestHeaders(
                                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT Access Token")
                        ),
                        responseFields(
                                fieldWithPath("tokenType").type(String.class).description("토큰의 타입, default: Bearer"),
                                fieldWithPath("accessToken").type(String.class).description("재발급 받은 access token"),
                                fieldWithPath("refreshToken").type(String.class).description("재발급 받은 refresh token")
                        )
                ));
    }
}
