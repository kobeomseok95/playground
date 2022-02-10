package com.example.oauth.auth.handler;

import lombok.RequiredArgsConstructor;

//@Component
@RequiredArgsConstructor
public class LoginSuccessHandler /*implements AuthenticationSuccessHandler */{

//    private final TokenProvider tokenProvider;
//    private final ObjectMapper objectMapper;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        response.setStatus(HttpStatus.OK.value());
//        response.setContentType(APPLICATION_JSON_VALUE);
//        response.setCharacterEncoding("UTF-8");
//
//        String refreshToken = tokenProvider.createRefreshToken(authentication);
//        String accessToken = tokenProvider.createAccessToken(authentication);
//        AuthResponse authResponse = AuthResponse.of(accessToken,refreshToken);
//
//        objectMapper.writeValue(response.getWriter(), authResponse);
//    }
}
