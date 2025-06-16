package com.jsoft.roomschedule.jwt;

import com.jsoft.roomschedule.users.SystemUser;
import com.jsoft.roomschedule.users.UserService;
import com.jsoft.roomschedule.auth.UserDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class SystemUserAuthFilter extends OncePerRequestFilter {


    private final JwtTokenService jwtTokenService;

    private final UserService userService;

    public SystemUserAuthFilter(JwtTokenService jwtTokenService, UserService userService) {
        this.jwtTokenService = jwtTokenService;
        this.userService = userService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Verifica se o endpoint requer autenticação antes de processar a requisição
        if(isNotPublicEndPoint(request)){
              String token = recoveryToken(request);
              if(token != null) {
                  String subject = jwtTokenService.getSubjectFromToken(token);
                  Optional<SystemUser> user = userService.findByEmail(subject);
                  if (user.isPresent()){
                      UserDetailsImpl userDetails = new UserDetailsImpl(user.get());
                      Authentication authentication =
                              new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
                      SecurityContextHolder.getContext().setAuthentication(authentication);
                  }
              } else {
                  throw new RuntimeException("Empty token !");
              }
        }
        filterChain.doFilter(request, response); //go to next processes
    }

    private String recoveryToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null) {
            authHeader = authHeader.replace("Bearer", "");
        }
        return authHeader;
    }

    private boolean isNotPublicEndPoint(HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        return !Arrays.stream(SecurityConfiguration.ENDPOINTS_WITH_AUTH_NOT_REQUIRED).anyMatch(endPoint ->
                requestUri.contains(endPoint.replace("*","")));
    }
}
