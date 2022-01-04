package com.example.solid.unit.modules;

import com.example.solid.modules.member.application.port.in.MemberUseCase;
import com.example.solid.modules.member.presentation.MemberController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({
        MemberController.class
})
public abstract class ControllerTest {

    @MockBean
    protected MemberUseCase memberUseCase;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected MockMvc mockMvc;
}
