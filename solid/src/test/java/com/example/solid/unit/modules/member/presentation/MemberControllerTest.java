package com.example.solid.unit.modules.member.presentation;

import com.example.solid.unit.modules.ControllerTest;
import com.example.solid.unit.modules.member.application.port.in.MockMemberJoinRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MemberControllerTest extends ControllerTest {

    @Test
    @DisplayName("회원 가입 / 성공")
    void join() throws Exception {

        // given
        String requestBody = objectMapper.writeValueAsString(
                MockMemberJoinRequest.createRequest());

        // when, then
        mockMvc.perform(post("/api/members")
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
