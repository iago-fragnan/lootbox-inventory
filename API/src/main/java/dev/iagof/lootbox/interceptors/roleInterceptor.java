package dev.iagof.lootbox.interceptors;

import dev.iagof.lootbox.helpers.JWTHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class roleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!JWTHelper.isAdmin(request.getHeader("X-Auth-Token"))){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"data\": \"Unauthorized\"}");
            response.getWriter().flush();
            return false;
        }

        return true;
    }
}