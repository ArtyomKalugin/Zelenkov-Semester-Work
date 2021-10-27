package com.kalugin.net.servlet;

import com.kalugin.net.dto.UserDto;
import com.kalugin.net.service.impl.RecipeServiceImpl;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "detailUserServlet", urlPatterns = "/detailUser")
public class DetailUserServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    RecipeServiceImpl recipeService = new RecipeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto userNow = (UserDto) session.getAttribute("user");
        int id = Integer.parseInt(req.getParameter("id"));

        if(userNow != null && userNow.getId() == id) {
            req.getRequestDispatcher("/cabinet").forward(req, resp);
        } else {
            UserDto user = userService.get(id);
            int allRecipesCount = recipeService.getByUserId(user.getId()).size();

            req.setAttribute("count", allRecipesCount);
            req.setAttribute("detailUser", user);

            req.getRequestDispatcher("detailUser.ftl").forward(req, resp);
        }
    }
}
