package com.zelenkov.net.servlet.recipeServlet;

import com.zelenkov.net.dto.RecipeDto;
import com.zelenkov.net.dto.UserDto;
import com.zelenkov.net.service.RecipeService;
import com.zelenkov.net.service.UserService;
import com.zelenkov.net.service.impl.RecipeServiceImpl;
import com.zelenkov.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "detailRecipeServlet", urlPatterns = "/detailRecipe")
public class DetailRecipeServlet extends HttpServlet {
    private final RecipeService recipeService = new RecipeServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto userNow = (UserDto) session.getAttribute("user");
        RecipeDto recipe = recipeService.get(Integer.parseInt(req.getParameter("id")));
        UserDto user = userService.getByNickname(recipe.getUserNickname());

        req.setAttribute("recipe", recipe);
        req.setAttribute("u", null);
        req.setAttribute("author", user);
        req.setAttribute("userNow", userNow);

        req.getRequestDispatcher("detailRecipe.ftl").forward(req, resp);
    }
}