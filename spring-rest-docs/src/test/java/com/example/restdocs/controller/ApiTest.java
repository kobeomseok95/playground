package com.example.restdocs.controller;

import com.example.restdocs.dto.GetResponse;
import com.example.restdocs.dto.PostRequest;
import com.example.restdocs.dto.PostResponse;
import com.example.restdocs.services.RestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.restdocs.ApiDocumentUtils.getDocumentRequest;
import static com.example.restdocs.ApiDocumentUtils.getDocumentResponse;
import static java.nio.charset.StandardCharsets.*;
import static org.mockito.Mockito.*;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@WebMvcTest(Api.class)
@AutoConfigureRestDocs
class ApiTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;
    @MockBean RestService restService;

    @BeforeEach
    void setUp(WebApplicationContext context, RestDocumentationContextProvider provider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(provider))
                .build();
    }

    @Test
    @DisplayName("id로 get 요청 후 응답하기")
    void get_test() throws Exception {

        when(restService.get(any())).thenReturn(List.of(GetResponse.builder().name("이름").age(1).build()));

        mockMvc.perform(get("/test/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("get",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(parameterWithName("id").description("요청한 아이디")),
                        responseFields(
                                fieldWithPath("[].name").description("이름"),
                                fieldWithPath("[].age").description("나이")
                        )));
    }

    @Test
    @DisplayName("post로 요청하기")
    void post_test() throws Exception {

        when(restService.post(any())).thenReturn(PostResponse.success());
        String body = objectMapper.writeValueAsString(PostRequest.builder()
                .name("test").age(1).build());
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", "테스트");
        bodyMap.put("age", 1);

        mockMvc.perform(RestDocumentationRequestBuilders.post("/test")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("post",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        requestBody(bodyMap),
                        responseFields(fieldWithPath("message").description("성공 실패 여부"))));
    }
}
