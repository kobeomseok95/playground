package com.example.oauth.member.presentation;

import com.example.oauth.SecuritySupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@ExtendWith(RestDocumentationExtension.class)
class MemberControllerTest extends SecuritySupport {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;
    @Autowired WebApplicationContext ctx;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocs) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx)
                .apply(springSecurity())
                .apply(documentationConfiguration(restDocs))
                .alwaysDo(print())
                .addFilter( new CharacterEncodingFilter( "UTF-8", true ))
                .build();
    }

    @DisplayName("회원 정보 조회 / 성공")
    @Test
    void get_me_test_success() throws Exception {

        // given
        securityUserMockSetting();

        // when, then, docs
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/me")
                .header(HttpHeaders.AUTHORIZATION, "Bearer accessToken")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.email").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andExpect(jsonPath("$.role").isNotEmpty())
                .andExpect(jsonPath("$.social").isNotEmpty())
                .andExpect(jsonPath("$.authProvider").isNotEmpty())
                .andExpect(jsonPath("$.picture").isNotEmpty())
                .andExpect(jsonPath("$.password").isNotEmpty())
                .andExpect(jsonPath("$.createdDate").isEmpty())
                .andExpect(jsonPath("$.lastModifiedDate").isEmpty())
                .andExpect(jsonPath("$.roleKey").isNotEmpty())
                .andDo(document("member/{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestHeaders(
                                headerWithName(HttpHeaders.AUTHORIZATION).description("JWT Access Token")
                        ),
                        responseFields(
                                fieldWithPath("id").description("사용자 ID"),
                                fieldWithPath("email").description("사용자 Email"),
                                fieldWithPath("name").description("사용자 이름"),
                                fieldWithPath("role").description("사용자 권한"),
                                fieldWithPath("social").description("사용자의 소셜 로그인 유무"),
                                fieldWithPath("authProvider").description("사용자의 소셜 로그인 제공자, ex) Kakao, Apple, Naver, Google..."),
                                fieldWithPath("picture").description("사용자 프로필 사진"),
                                fieldWithPath("password").description("사용자 비밀번호"),
                                fieldWithPath("createdDate").description("사용자 가입 날짜"),
                                fieldWithPath("lastModifiedDate").description("사용자 정보 수정 날짜"),
                                fieldWithPath("roleKey").description("사용자 권한 Prefix + 권한")
                        )));
    }
}