package com.kalugin.net.servlet;

import com.kalugin.net.dto.*;
import com.kalugin.net.model.Article;
import com.kalugin.net.model.ArticleComment;
import com.kalugin.net.model.RecipeComment;
import com.kalugin.net.service.*;
import com.kalugin.net.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "detailArticleServlet", urlPatterns = "/detailArticle")
public class DetailArticleServlet extends HttpServlet {
    private final ArticleService articleService = new ArticleServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final ArticleCommentService articleCommentService = new ArticleCommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto userNow = (UserDto) session.getAttribute("user");
        ArticleDto article = articleService.get(Integer.parseInt(req.getParameter("id")));
        UserDto user = userService.getByNickname(article.getUserNickname());
        List<ArticleCommentDto> comments =
                articleCommentService.getAllByArticleId(Integer.parseInt(req.getParameter("id")));

        req.setAttribute("article", article);
        req.setAttribute("u", null);
        req.setAttribute("author", user);
        req.setAttribute("isComments", comments);
        req.setAttribute("comments", comments);
        req.setAttribute("userNow", userNow);

        req.getRequestDispatcher("detailArticle.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");

        String text = req.getParameter("comment");
        int userId = user.getId();

        if(!text.equals("")) {
            ArticleComment comment = new ArticleComment(userId, Integer.parseInt(req.getParameter("id")), text);
            articleCommentService.save(comment);
        }

        String redirect = "/detailArticle?id=" + req.getParameter("id");
        resp.sendRedirect(redirect);
    }
}