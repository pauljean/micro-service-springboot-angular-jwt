package com.pauljean.microservicezuulproxy.config.jwt;

import java.io.IOException;
import java.util.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

//import com.pauljean.microservicezuulproxy.service.UserDetailsServiceImpl;

@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtProvider tokenProvider;

	//@Autowired
	//private UserDetailsServiceImpl userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (request.getMethod().equals("OPTIONS"))
		{
			response.setStatus(HttpServletResponse.SC_OK);
		} else if (request.getRequestURI().equals("/api/auth/signin") ||
		request.getRequestURI().equals("/api/auth/signup")) {
			System.out.println("**on authentifie pas***");
			filterChain.doFilter(request,response);
			return;
		}
		else {

		try {

			String jwt = getJwt(request);
			if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
				String username = tokenProvider.getUserNameFromJwtToken(jwt);

				//UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				List<String> roles= tokenProvider.getRoleNameFromJwtToken(jwt);


				logger.info("username= "+username);
				logger.info("roles= "+roles);
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				roles.forEach(rn -> {

					authorities.add(new SimpleGrantedAuthority(rn));
				});
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						username, null, authorities);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			logger.error("Can NOT set user authentication -> Message: {}", e);
		}
		}

		filterChain.doFilter(request, response);

		}





	private String getJwt(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.replace("Bearer ", "");
		}

		return null;
	}




}
