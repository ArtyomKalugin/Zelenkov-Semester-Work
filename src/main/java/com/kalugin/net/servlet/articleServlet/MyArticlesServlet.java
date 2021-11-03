package com.kalugin.net.servlet.articleServlet;

import com.kalugin.net.dto.ArticleDto;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.helper.TextHelper;
import com.kalugin.net.service.ArticleService;
import com.kalugin.net.service.impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "myArticlesServlet", urlPatterns = "/myArticles")
public class MyArticlesServlet extends HttpServlet {
    private final ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserDto user = (UserDto) session.getAttribute("user");

        List<ArticleDto> articles = articleService.getByUserId(user.getId());
        articles = articles.stream()
                .map(article -> new ArticleDto(article.getId(), article.getUserNickname(), article.getTitle(),
                        TextHelper.editText(article.getText()), article.getPhoto(), article.getData()))
                .collect(Collectors.toList());
        Collections.reverse(articles);
        req.setAttribute("articles", articles);

        req.getRequestDispatcher("myArticles.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        HttpSession session = req.getSession(false);
        UserDto user = (UserDto) session.getAttribute("user");

        List<ArticleDto> articles = articleService.getByUserIdAndTitle(user.getId(), title);
        articles = articles.stream()
                .map(article -> new ArticleDto(article.getId(), article.getUserNickname(), article.getTitle(),
                        TextHelper.editText(article.getText()), article.getPhoto(), article.getData()))
                .collect(Collectors.toList());
        Collections.reverse(articles);
        req.setAttribute("articles", articles);

        req.getRequestDispatcher("myArticles.ftl").forward(req, resp);
    }
}
