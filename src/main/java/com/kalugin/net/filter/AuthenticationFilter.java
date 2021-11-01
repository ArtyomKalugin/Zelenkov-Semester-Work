package com.kalugin.net.filter;

import com.kalugin.net.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/createRecipe", "/createArticle", "/deleteArticle",
        "/deleteRecipe", "/logout", "/myArticles", "/myDetailArticle", "/myDetailRecipe", "/myRecipes",
        "/cabinet", "/chat"})
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
            System.out.println(user.getEmail());
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