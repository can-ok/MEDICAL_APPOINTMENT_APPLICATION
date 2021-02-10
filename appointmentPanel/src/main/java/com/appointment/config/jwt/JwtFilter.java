package com.appointment.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.appointment.config.CustomUserDetails;
import com.appointment.service.CustomUserDetailsService;


@Component
public class JwtFilter  extends GenericFilterBean{
	
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.info("filter");
		
		
		String token=getTokenFromRequest((HttpServletRequest)request);
		if(token!=null && jwtProvider.validateToken(token)) {
			String userLogin=jwtProvider.getLoginFromToken(token);
			CustomUserDetails customUserDetails=customUserDetailsService.loadUserByUsername(userLogin);
			UsernamePasswordAuthenticationToken auth=
					new UsernamePasswordAuthenticationToken(customUserDetails,null,customUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		chain.doFilter(request, response);
	}
	
	private String getTokenFromRequest(HttpServletRequest request) {
		String autherizationHeader=request.getHeader("Authorization");
		if(autherizationHeader !=null && autherizationHeader.startsWith("Bearer")) {
			return autherizationHeader.substring(7);
		}
		return null;
	}

}
