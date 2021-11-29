package com.zelenkov.net.servlet.userServlet;

import com.zelenkov.net.dto.UserDto;
import com.zelenkov.net.helper.ImageHelper;
import com.zelenkov.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@MultipartConfig()
@WebServlet(name = "personalCabinetServlet", urlPatterns = "/cabinet")
public class PersonalCabinetServlet extends HttpServlet {
    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setAttribute("user", session.getAttribute("user"));
        resp.sendRedirect("cabinet.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("avatar");
        String path = getServletContext().getRealPath("/tmp");
        String fileName = ImageHelper.makeFile(part, path);

        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        user.setAvatar("tmp/" + fileName);

        userService.changeAvatar(user.getId(), user.getAvatar());

        req.getRequestDispatcher("cabinet.ftl").forward(req, resp);
    }
}
