package com.kalugin.net.servlet;

import com.kalugin.net.dto.UserDto;
import com.kalugin.net.helper.PasswordHelper;
import com.kalugin.net.service.UserService;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SignInServlet", urlPatterns = "/signIn")
public class SignInServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("err", null);

        //resp.sendRedirect("signIn.ftl");
        req.getRequestDispatcher("signIn.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String hashPassword = PasswordHelper.encrypt(req.getParameter("password"));

        for(UserDto user : userService.getAll()) {
            if(user.getHashPassword().equals(hashPassword) && user.getLogin().equals(login)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(60 * 60);

                Cookie userCookie = new Cookie("nickname", user.getNickname());
                userCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(userCookie);

                resp.sendRedirect("/info");
                return;
            }
        }

        req.setAttribute("err", "Неправильный логин или пароль!");

        req.getRequestDispatcher("signIn.ftl").forward(req, resp);

    }
}
