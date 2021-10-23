package com.kalugin.net.servlet;

import com.kalugin.net.dto.UserDto;
import com.kalugin.net.service.UserService;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "allUsersServlet", urlPatterns = "/allUsers")
public class AllUsersServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDto> users = userService.getAll();
        users.sort(Comparator.comparing(UserDto::getNickname));
        req.setAttribute("users", users);

        req.getRequestDispatcher("allUsers.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        List<UserDto> users = userService.getAllByNickname(nickname);
        users.sort(Comparator.comparing(UserDto::getNickname));
        req.setAttribute("users", users);

        req.getRequestDispatcher("allUsers.ftl").forward(req, resp);
    }
}
