package skku.Rarepet.global.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import skku.Rarepet.global.interfaces.SessionConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    public static final String[] whiteList = {"/users/login", "/users"};
    public static final String[] blackList = {"/*", "/*/**"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();
        if(session == null || session.getAttribute(SessionConst.SESSION) ==  null) {
            response.sendError(401, "로그인이 필요합니다.");
            return false;
        }
        return true;
    }
}
