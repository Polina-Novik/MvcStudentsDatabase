package by.novik.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
public class FirstInterceptor implements HandlerInterceptor {
    //типо фильтра на все приложение

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      log.info("we call the following endpoint: {}", request.getRequestURI());
        return true;
    }
}
