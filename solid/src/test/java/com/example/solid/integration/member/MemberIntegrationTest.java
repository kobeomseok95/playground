package com.example.solid.integration.member;

import com.example.solid.integration.IntegrationTest;
import com.example.solid.modules.member.application.port.in.MemberJoinRequest;
import com.example.solid.modules.member.domain.Member;
import com.example.solid.modules.member.repository.MemberJpaRepository;
import com.example.solid.unit.modules.member.application.port.in.MockMemberJoinRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberIntegrationTest extends IntegrationTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    @DisplayName("회원 가입 - 성공")
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

    @Test
    @DisplayName("회원 가입 - 실패")
    void join_fail() throws Exception {

        // given
        MemberJoinRequest request = MockMemberJoinRequest.createRequest();
        setUpSaveMember(request);
        String requestBody = objectMapper.writeValueAsString(request);

        // when, then
        mockMvc.perform(post("/api/members")
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    private void setUpSaveMember(MemberJoinRequest request) {
        memberJpaRepository.save(
                Member.build(request.getPhone()));
    }
}
