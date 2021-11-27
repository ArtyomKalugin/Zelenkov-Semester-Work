package com.zelenkov.net.servlet.infoServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "informationServlet", urlPatterns = "/info")
public class InformationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        HttpSession session = req.getSession();
        req.setAttribute("user", session.getAttribute("user"));

        resp.sendRedirect("info.ftl");
    }
}
