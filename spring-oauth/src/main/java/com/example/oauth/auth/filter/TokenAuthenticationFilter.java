package com.example.oauth.auth.filter;

import com.example.oauth.auth.domain.repository.LogoutAccessTokenRepository;
import com.example.oauth.auth.domain.repository.LogoutRefreshTokenRepository;
import com.example.oauth.auth.jwt.TokenProvider;
import com.example.oauth.auth.service.CustomUserDetailsService;
import com.example.oauth.common.exception.auth.TokenAuthenticationFilterException;
import com.example.oauth.member.domain.AuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private final TokenProvider tokenProvider;
    private final CustomUserDetailsService customUserDetailsService;
    private final LogoutAccessTokenRepository logoutAccessTokenRepository;
    private final LogoutRefreshTokenRepository logoutRefreshTokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);
            if (isValidToken(jwt)) {
                String email = tokenProvider.getUserEmail(jwt);
                AuthProvider authProvider = tokenProvider.getAuthProvider(jwt);
                UserDetails userDetails = customUserDetailsService.loadTokenUserByUsername(email,authProvider);
                UsernamePasswordAuthenticationToken authentication
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            throw new TokenAuthenticationFilterException();
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private boolean isValidToken(String jwt) {
        return StringUtils.hasText(jwt)
                && tokenProvider.validateToken(jwt)
                && !logoutAccessTokenRepository.existsById(jwt)
                && !logoutRefreshTokenRepository.existsById(jwt);
    }
}
