package com.kalugin.net.servlet.articleServlet;

import com.kalugin.net.dto.ArticleDto;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.helper.CookieHelper;
import com.kalugin.net.helper.HTMLArticleHelper;
import com.kalugin.net.helper.TextHelper;
import com.kalugin.net.service.ArticleService;
import com.kalugin.net.service.UserService;
import com.kalugin.net.service.impl.ArticleServiceImpl;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "allArticlesServlet", urlPatterns = "/allArticles")
public class AllArticlesServlet extends HttpServlet {
    private final ArticleService articleService = new ArticleServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieHelper.checkSession(req);

        String title = req.getParameter("title");
        List<ArticleDto> articles = articleService.getByTitle(title);
        articles = articles.stream()
                .map(article -> new ArticleDto(article.getId(), article.getUserNickname(), article.getTitle(),
                        TextHelper.editText(article.getText()), article.getPhoto(), article.getData()))
                .collect(Collectors.toList());
        Collections.reverse(articles);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(HTMLArticleHelper.makeHTML(articles));
    }
}