package com.zelenkov.net.filter;

import com.zelenkov.net.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/createRecipe", "/deleteRecipe", "/logout",
        "/myDetailRecipe", "/myRecipes", "/cabinet", "/chat", "/editRecipe"})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        try {
            UserDto user = (UserDto) session.getAttribute("user");
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            response.sendRedirect("/signIn");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}