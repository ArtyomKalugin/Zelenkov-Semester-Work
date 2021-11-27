package com.zelenkov.net.servlet.recipeServlet;

import com.zelenkov.net.dto.RecipeDto;
import com.zelenkov.net.dto.UserDto;
import com.zelenkov.net.service.RecipeService;
import com.zelenkov.net.service.UserService;
import com.zelenkov.net.service.impl.RecipeServiceImpl;
import com.zelenkov.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "myDetailRecipeServlet", urlPatterns = "/myDetailRecipe")
public class MyDetailRecipesServlet extends HttpServlet {
    private final RecipeService recipeService = new RecipeServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeDto recipe = recipeService.get(Integer.parseInt(req.getParameter("id")));
        UserDto user = userService.getByNickname(recipe.getUserNickname());
        HttpSession session = req.getSession();
        UserDto userNow = (UserDto) session.getAttribute("user");

        req.setAttribute("recipe", recipe);
        req.setAttribute("u", userNow);
        req.setAttribute("author", user);
        req.setAttribute("isComments", null);

        req.getRequestDispatcher("detailRecipe.ftl").forward(req, resp);
    }
}