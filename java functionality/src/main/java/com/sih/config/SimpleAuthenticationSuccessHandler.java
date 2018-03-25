package com.sih.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if(authority.getAuthority().equals("ROLE_USER")){
				redirectStrategy.sendRedirect(request, response, "/users/home");
			}
			else if(authority.getAuthority().equals("ROLE_ADMIN")){
				redirectStrategy.sendRedirect(request, response, "/admins/home");
			}
			else if(authority.getAuthority().equals("ROLE_MANAGER")){
				redirectStrategy.sendRedirect(request, response, "/managers/home");
			}
			else{
				throw new IllegalStateException();
			}
		}
	}

}
