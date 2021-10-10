package com.kalugin.net.servlet;

import com.kalugin.net.dao.impl.UserDao;
import com.kalugin.net.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String firstName = req.getParameter("first_name");
        String secondName = req.getParameter("second_name");
        String email = req.getParameter("email");
        String avatar = "qwdqwd";
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User newUser = new User(nickname, firstName, secondName, email, avatar, login, password);
        UserDao userDao = new UserDao();
        userDao.save(newUser);

        HttpSession session = req.getSession();
        session.setAttribute("nickname", nickname);
        session.setMaxInactiveInterval(60 * 60);

        Cookie userCookie = new Cookie("nickname", nickname);
        userCookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(userCookie);

        resp.sendRedirect("info.ftl");
    }
}
