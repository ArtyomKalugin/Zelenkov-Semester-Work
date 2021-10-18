package com.kalugin.net.servlet;

import com.cloudinary.Cloudinary;
import com.kalugin.net.helper.CloudinaryHelper;
import com.kalugin.net.helper.ImageHelper;
import com.kalugin.net.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "personalCabinetServlet", urlPatterns = "/cabinet")
public class PersonalCabinetServlet extends HttpServlet {
//    private final Cloudinary cloudinary = CloudinaryHelper.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setAttribute("user", session.getAttribute("user"));
        resp.sendRedirect("cabinet.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("avatar");

        File avatar = ImageHelper.makeFile(part);

//        cloudinary.uploader().upload(avatar, new HashMap());

//        userService.save(newUser);

        resp.sendRedirect("/cabinet");
    }
}
