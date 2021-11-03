package com.kalugin.net.servlet.recipeServlet;

import com.kalugin.net.service.impl.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteRecipeServlet", urlPatterns = "/deleteRecipe")
public class DeleteRecipeServlet extends HttpServlet {
    RecipeServiceImpl recipeService = new RecipeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        recipeService.delete(Integer.parseInt(req.getParameter("id")));

        req.getRequestDispatcher("/myRecipes").forward(req, resp);
    }
}
