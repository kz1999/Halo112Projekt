package com.example.halo112_generic.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.halo112_generic.domain.MyUserDetails;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	    Authentication authentication) throws IOException, ServletException {
	    clearAuthenticationAttributes(request);
	    
	    MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
	    if (details.isConfirmed()) {
	    	response.setStatus(HttpStatus.ACCEPTED.value());
	    } else {
	    	SecurityContextHolder.clearContext();
	    	authentication.setAuthenticated(false);
	    	response.setStatus(HttpStatus.UNAUTHORIZED.value());
	    }
	}
}