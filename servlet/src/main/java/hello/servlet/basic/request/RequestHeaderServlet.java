package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);

        printHeaders(req);

        printHeaderUtils(req);

        printEtc(req);
    }

    private void printEtc(HttpServletRequest req) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                req.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                req.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                req.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " +
                req.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                req.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                req.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " +
                req.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " +
                req.getServerPort()); //Host 헤더
        System.out.println();
        System.out.println("[Accept-Language 편의 조회]");
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +
                        locale));
        System.out.println("request.getLocale() = " + req.getLocale());
        System.out.println();
        System.out.println("[cookie 편의 조회]");
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " +
                req.getContentType());
        System.out.println("request.getContentLength() = " +req.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                req.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("==============헤더 전체 가져오기");
//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            System.out.println("headerName = " + headerName);
//        }
        req.getHeaderNames().asIterator()
                .forEachRemaining(headerNames -> System.out.println("headerNames = " + headerNames));
    }

    private void printStartLine(HttpServletRequest req) {
        //        request의 startLine
        System.out.println("req.getMethod() = " + req.getMethod());
        System.out.println("req.getProtocol() = " + req.getProtocol());
        System.out.println("req.getScheme() = " + req.getScheme());

        System.out.println("req.getRequestURL() = " + req.getRequestURL());
        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        System.out.println("req.getQueryString() = " + req.getQueryString());
//        https의 사용 여부
        System.out.println("req.isSecure() = " + req.isSecure());
    }
}
