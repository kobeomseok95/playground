package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.servlet.http.HttpServletResponse.*;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
//  response 완료
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        status line
        resp.setStatus(SC_OK);

//        response Headers
        resp.setHeader("Content-Type", "text/plain");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

//        Header 편의 메서드
        content(resp);
//        Cookie 편의 메서드
        cookie(resp);
//        redirect 편의 메서드
        redirect(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("ok");
    }

    private void redirect(HttpServletResponse resp) throws IOException {
//        resp.setStatus(SC_FOUND);
//        resp.setHeader("Location", "/basic/hello-form.html");
        resp.sendRedirect("/basic/hello-form.html");
    }

    private void content(HttpServletResponse resp) {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse resp) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }
}
