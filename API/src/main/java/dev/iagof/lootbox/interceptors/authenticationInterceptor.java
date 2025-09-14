package dev.iagof.lootbox.interceptors;

import dev.iagof.lootbox.helpers.JWTHelper;
import dev.iagof.lootbox.helpers.RequestResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class authenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        JWTHelper.init();

        if(request.getHeader("X-Auth-Token") == null && !JWTHelper.validate(request.getHeader("X-Auth-Token"))){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"data\": \"Authentication Missing/Failed\"}");
            response.getWriter().flush();
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
