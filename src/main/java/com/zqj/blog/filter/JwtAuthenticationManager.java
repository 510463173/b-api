package com.zqj.blog.filter;

import com.zqj.blog.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationManager implements AuthenticationManager {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getCredentials();
        UserDetails blogUserDetails = User.builder()
                .username("Visitor")
                .password("")
                .roles("Visitor")
                .build();
        try {
            String subject = jwtService.getSubject(token);
            blogUserDetails = userDetailsService.loadUserByUsername(subject);;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new UsernamePasswordAuthenticationToken(blogUserDetails, token, blogUserDetails.getAuthorities());
    }

}
