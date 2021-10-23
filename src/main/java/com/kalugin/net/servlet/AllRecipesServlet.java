package com.kalugin.net.servlet;

import com.kalugin.net.dto.RecipeDto;
import com.kalugin.net.helper.TextHelper;
import com.kalugin.net.service.RecipeService;
import com.kalugin.net.service.impl.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "allRecipesServlet", urlPatterns = "/allRecipes")
public class AllRecipesServlet extends HttpServlet {
    private final RecipeService recipeService = new RecipeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RecipeDto> recipes = recipeService.getAll();
        recipes = recipes.stream()
                .map(recipe -> new RecipeDto(recipe.getId(), recipe.getUserNickname(), recipe.getTitle(),
                        TextHelper.editText(recipe.getText()), recipe.getPhoto(), recipe.getData()))
                .collect(Collectors.toList());
        Collections.reverse(recipes);
        req.setAttribute("recipes", recipes);

        req.getRequestDispatcher("allRecipes.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        List<RecipeDto> recipes = recipeService.getByTitle(title);
        recipes = recipes.stream()
                .map(recipe -> new RecipeDto(recipe.getId(), recipe.getUserNickname(), recipe.getTitle(),
                        TextHelper.editText(recipe.getText()), recipe.getPhoto(), recipe.getData()))
                .collect(Collectors.toList());
        Collections.reverse(recipes);
        req.setAttribute("recipes", recipes);

        req.getRequestDispatcher("allRecipes.ftl").forward(req, resp);
    }
}
