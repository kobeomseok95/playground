package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    /**
     * get, post(form) 방식에 상관없이 파라미터를 받을 수 있다.
     *
     * get 방식은 쿼리파라미터로 데이터가 날라가기 때문에 contentType = null 이다.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("전체 파라미터 조회 start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " : " + request.getParameter(paramName)));

        System.out.println("전체 파라미터 조회 end");
        System.out.println();

        System.out.println("단일 파라미터 조회");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println(username + ", " + age);
        System.out.println();

        System.out.println("이름이 같은 복수 파라미터 조회");
        String[] usernames = request.getParameterValues("username");
        for (String s : usernames) {
            System.out.println("s = " + s);
        }
    }
}
