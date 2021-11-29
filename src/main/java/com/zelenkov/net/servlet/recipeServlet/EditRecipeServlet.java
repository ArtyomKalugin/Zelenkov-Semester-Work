package com.zelenkov.net.servlet.recipeServlet;

import com.zelenkov.net.dto.RecipeDto;
import com.zelenkov.net.helper.ImageHelper;
import com.zelenkov.net.service.impl.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@MultipartConfig
@WebServlet(name = "editRecipeServlet", urlPatterns = "/editRecipe")
public class EditRecipeServlet extends HttpServlet {
    RecipeServiceImpl recipeService = new RecipeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeDto recipe = recipeService.get(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("recipe", recipe);

        req.getRequestDispatcher("editRecipe.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeDto recipe = recipeService.get(Integer.parseInt(req.getParameter("id")));

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Part part = req.getPart("photo");

        if(!title.equals("") && !content.equals("")) {
            if(part.getSize() != 0) {
                String path = getServletContext().getRealPath("/tmp");
                String fileName = ImageHelper.makeFile(part, path);
                recipe.setPhoto("tmp/" + fileName);
            }

            recipe.setTitle(title);
            recipe.setText(content);

            recipeService.changeData(recipe.getId(), recipe.getTitle(), recipe.getText(), recipe.getPhoto());
        }

        resp.sendRedirect("/myRecipes");
    }
}
