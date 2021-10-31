package com.kalugin.net.servlet;

import com.kalugin.net.dto.ArticleDto;
import com.kalugin.net.dto.RecipeDto;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.service.ArticleService;
import com.kalugin.net.service.RecipeService;
import com.kalugin.net.service.UserService;
import com.kalugin.net.service.impl.ArticleServiceImpl;
import com.kalugin.net.service.impl.RecipeServiceImpl;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "myDetailArticleServlet", urlPatterns = "/myDetailArticle")
public class MyDetailArticlesServlet extends HttpServlet {
    private final ArticleService articleService = new ArticleServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDto article = articleService.get(Integer.parseInt(req.getParameter("id")));
        UserDto user = userService.getByNickname(article.getUserNickname());
        HttpSession session = req.getSession();
        UserDto userNow = (UserDto) session.getAttribute("user");

        req.setAttribute("article", article);
        req.setAttribute("u", userNow);
        req.setAttribute("author", user);
        req.setAttribute("isComments", null);

        req.getRequestDispatcher("detailArticle.ftl").forward(req, resp);
    }
}
