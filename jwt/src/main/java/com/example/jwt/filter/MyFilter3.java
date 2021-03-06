package com.example.jwt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {

    /**
     * 시큐리티 필터가 우선적으로 호출된다! before, after 모두!
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /**
         * 이 jwt 토큰은 시큐리티 필터가 적용되기 전에 적용되어야한다.
         */
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

//        토큰을 만들었다고 가정(cos)
//        id, pw를 입력받고 로그인이 완료되면 토큰은 만들어주고 응답해주기
//        요청할 때 마다 header에 Authorization key에 value로 토큰이 옴
//        넘어온 토큰을 내가 만든건지 검증하기
        if (req.getMethod().equals("POST")) {
            System.out.println("post 요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println("headerAuth = " + headerAuth);
            System.out.println("필터3");

            if (headerAuth.equals("cos")) {
                chain.doFilter(req, res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("인증 안됨!");// 그 이후의 필터들이 적용되지 않는다.
            }
        }
    }
}
