package com.example.haziq.lead_managemanet.filters;

import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

public class CustomAuthenticationFilter extends OncePerRequestFilter {
  private final UserRepository repository;
  public CustomAuthenticationFilter(UserRepository userRepository) {
    this.repository = userRepository;
  }
    private static final String[] excludedEndpoints = new String[] {"/login"};

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    String token = extractTokenFromRequest(request);
    if (token != null) {
      User loggedUser = repository.findByAuthToken(token);
      Authentication authentication = new UsernamePasswordAuthenticationToken(loggedUser.getEmail(), loggedUser.getPassword(), Arrays.asList(new SimpleGrantedAuthority(loggedUser.getRollName())));
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return Arrays.stream(excludedEndpoints)
            .anyMatch(e -> new AntPathMatcher().match(e, request.getServletPath()));
  }

    private String extractTokenFromRequest(HttpServletRequest request) {
      Cookie[] cookies = request.getCookies();

      String desiredCookieName = "HTTP-X-AUTH-TOKEN"; // Replace this with the name of the cookie you want to retrieve
      String desiredCookieValue = "";
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if (cookie.getName().equals(desiredCookieName)) {
            desiredCookieValue = cookie.getValue();
            break; // Found the cookie, no need to continue the loop
          }
        }
      }

      return desiredCookieValue;
    }
  }

