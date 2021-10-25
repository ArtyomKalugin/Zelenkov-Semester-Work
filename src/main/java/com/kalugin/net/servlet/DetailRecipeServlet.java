package com.kalugin.net.servlet;

import com.kalugin.net.dto.RecipeDto;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.service.RecipeService;
import com.kalugin.net.service.UserService;
import com.kalugin.net.service.impl.RecipeServiceImpl;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "detailRecipeServlet", urlPatterns = "/detailRecipe")
public class DetailRecipeServlet extends HttpServlet {
    private final RecipeService recipeService = new RecipeServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeDto recipe = recipeService.get(Integer.parseInt(req.getParameter("id")));
        UserDto user = userService.getByNickname(recipe.getUserNickname());

        req.setAttribute("recipe", recipe);
        req.setAttribute("u", null);
        req.setAttribute("user", user);

        req.getRequestDispatcher("detailRecipe.ftl").forward(req, resp);
    }
}