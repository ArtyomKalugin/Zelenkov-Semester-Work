package com.kalugin.net.servlet.articleServlet;

import com.kalugin.net.service.ArticleService;
import com.kalugin.net.service.impl.ArticleServiceImpl;
import com.kalugin.net.service.impl.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteArticleServlet", urlPatterns = "/deleteArticle")
public class DeleteArticleServlet extends HttpServlet {
    private final ArticleService articleService = new ArticleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        articleService.delete(Integer.parseInt(req.getParameter("id")));

        req.getRequestDispatcher("/myArticles").forward(req, resp);
    }
}

