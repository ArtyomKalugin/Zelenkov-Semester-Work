package com.kalugin.net.servlet.recipeServlet;

import com.kalugin.net.dto.RecipeDto;
import com.kalugin.net.helper.CookieHelper;
import com.kalugin.net.helper.HTMLRecipeHelper;
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
        CookieHelper.checkSession(req);

        String title = req.getParameter("title");
        List<RecipeDto> recipes = recipeService.getByTitle(title);
        recipes = recipes.stream()
                .map(recipe -> new RecipeDto(recipe.getId(), recipe.getUserNickname(), recipe.getTitle(),
                        TextHelper.editText(recipe.getText()), recipe.getPhoto(), recipe.getData()))
                .collect(Collectors.toList());
        Collections.reverse(recipes);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(HTMLRecipeHelper.makeHTML(recipes));
    }
}
