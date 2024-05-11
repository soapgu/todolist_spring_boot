package com.example.todolist.config;

import com.example.todolist.service.JWTService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private final Log log = LogFactory.getLog(InterceptorConfig.class);

    @Autowired
    private JWTService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("JwtInterceptor preHandle");
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        String token = request.getHeader("Authorization");
        if( token != null && !token.isEmpty() ) {
            String userId = jwtService.verifyToken(token.replace("Bearer ", ""));
            if( userId != null && !userId.isEmpty() ) {
                log.info("Jwt get userId:" + userId);
                log.info("Path userId:" + pathVariables.get("userId"));
                if(userId.equals(pathVariables.get("userId"))){
                    return true;
                }
            }
        }
        response.setStatus(401);
        return false;
    }
}
