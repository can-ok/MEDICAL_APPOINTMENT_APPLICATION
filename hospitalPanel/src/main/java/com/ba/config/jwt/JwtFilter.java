package com.ba.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ba.config.CustomUserDetails;
import com.ba.service.CustomPatientDetailService;



@Component
public class JwtFilter  extends OncePerRequestFilter{
	
	@Autowired
	private TokenManager tokenManager;
	
	@Autowired
	private CustomPatientDetailService customPatientDetailService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String autherizationHeader=request.getHeader("Authorization");
		String token = null;
		if(autherizationHeader !=null && autherizationHeader.startsWith("Bearer")) {
			token = autherizationHeader.substring(7);
			if(token!=null && tokenManager.validateToken(token)) {
				String userName=tokenManager.getLoginFromToken(token); //it is identificationNumber for us
				CustomUserDetails customUserDetails=customPatientDetailService.loadUserByUsername(userName);
				UsernamePasswordAuthenticationToken auth=
						new UsernamePasswordAuthenticationToken(customUserDetails,null,customUserDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		filterChain.doFilter(request, response);
	}
	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		
//		
//		if(token!=null && jwtProvider.validateToken(token)) {
//			String userLogin=jwtProvider.getLoginFromToken(token);
//			CustomUserDetails customUserDetails=customUserDetailsService.loadUserByUsername(userLogin);
//			UsernamePasswordAuthenticationToken auth=
//					new UsernamePasswordAuthenticationToken(customUserDetails,null,customUserDetails.getAuthorities());
//			SecurityContextHolder.getContext().setAuthentication(auth);
//		}
//		
//		chain.doFilter(request, response);
//	}
//	
//	private String getTokenFromRequest(HttpServletRequest request) {
//		String autherizationHeader=request.getHeader("Authorization");
//		if(autherizationHeader !=null && autherizationHeader.startsWith("Bearer")) {
//			return autherizationHeader.substring(7);
//		}
//		return null;
//	}

	

}