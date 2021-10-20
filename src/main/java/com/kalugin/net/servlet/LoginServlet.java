package com.kalugin.net.servlet;

import com.cloudinary.Cloudinary;
import com.kalugin.net.dao.impl.UserDao;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.helper.CloudinaryHelper;
import com.kalugin.net.helper.ImageHelper;
import com.kalugin.net.model.User;
import com.kalugin.net.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        resp.sendRedirect("login.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String firstName = req.getParameter("first_name");
        String secondName = req.getParameter("second_name");
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User newUser = new User(nickname, firstName, secondName, email, login, password,
                "https://res.cloudinary.com/dwzcudur6/image/upload/v1634711026/defaultUser_msfkll.png");

        userService.save(newUser);
        UserDto user = userService.getByLogin(login);

        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(60 * 60);

        Cookie userCookie = new Cookie("nickname", nickname);
        userCookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(userCookie);

        resp.sendRedirect("/info");
    }
}
