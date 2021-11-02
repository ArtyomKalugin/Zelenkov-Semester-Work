package com.kalugin.net.servlet;

import com.kalugin.net.helper.CookieHelper;
import com.kalugin.net.service.UserService;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "informationServlet", urlPatterns = "/info")
public class InformationServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        HttpSession session = req.getSession();
        CookieHelper.checkSession(req);

        req.setAttribute("user", session.getAttribute("user"));

        resp.sendRedirect("info.ftl");
    }
}
