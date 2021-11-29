package com.zelenkov.net.servlet.recipeServlet;

import com.zelenkov.net.dto.UserDto;
import com.zelenkov.net.helper.ImageHelper;
import com.zelenkov.net.model.Recipe;
import com.zelenkov.net.service.impl.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MultipartConfig
@WebServlet(name = "createRecipeServlet", urlPatterns = "/createRecipe")
public class CreateRecipeServlet extends HttpServlet {
    private final RecipeServiceImpl recipeService = new RecipeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("addRecipe.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int userId = user.getId();
        Part part = req.getPart("photo");

        if(!title.equals("") && !content.equals("")) {
            String path = getServletContext().getRealPath("/tmp");
            String fileName = ImageHelper.makeFile(part, path);

            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

            Recipe recipe = new Recipe(userId, title, content, "tmp/" + fileName, formatForDateNow.format(date));
            recipeService.save(recipe);
        }

        resp.sendRedirect("/cabinet");
    }
}
