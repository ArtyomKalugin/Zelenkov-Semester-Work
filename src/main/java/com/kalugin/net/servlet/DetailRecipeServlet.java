package com.kalugin.net.servlet;

import com.kalugin.net.dto.RecipeCommentDto;
import com.kalugin.net.dto.RecipeDto;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.model.RecipeComment;
import com.kalugin.net.service.RecipeCommentService;
import com.kalugin.net.service.RecipeService;
import com.kalugin.net.service.UserService;
import com.kalugin.net.service.impl.RecipeCommentServiceImpl;
import com.kalugin.net.service.impl.RecipeServiceImpl;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "detailRecipeServlet", urlPatterns = "/detailRecipe")
public class DetailRecipeServlet extends HttpServlet {
    private final RecipeService recipeService = new RecipeServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final RecipeCommentService recipeCommentService = new RecipeCommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto userNow = (UserDto) session.getAttribute("user");
        RecipeDto recipe = recipeService.get(Integer.parseInt(req.getParameter("id")));
        UserDto user = userService.getByNickname(recipe.getUserNickname());
        List<RecipeCommentDto> comments =
                recipeCommentService.getAllByRecipeId(Integer.parseInt(req.getParameter("id")));

        req.setAttribute("recipe", recipe);
        req.setAttribute("u", null);
        req.setAttribute("author", user);
        req.setAttribute("isComments", comments);
        req.setAttribute("comments", comments);
        req.setAttribute("userNow", userNow);

        req.getRequestDispatcher("detailRecipe.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");

        String text = req.getParameter("comment");
        int userId = user.getId();

        RecipeComment comment = new RecipeComment(userId, Integer.parseInt(req.getParameter("id")), text);
        recipeCommentService.save(comment);

        String redirect = "/detailRecipe?id=" + req.getParameter("id");
        resp.sendRedirect(redirect);
    }
}