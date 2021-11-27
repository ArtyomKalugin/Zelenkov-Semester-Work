package com.zelenkov.net.servlet.userServlet;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.zelenkov.net.dto.UserDto;
import com.zelenkov.net.helper.CloudinaryHelper;
import com.zelenkov.net.helper.ImageHelper;
import com.zelenkov.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@MultipartConfig
@WebServlet(name = "personalCabinetServlet", urlPatterns = "/cabinet")
public class PersonalCabinetServlet extends HttpServlet {
    private final Cloudinary cloudinary = CloudinaryHelper.getInstance();
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

        File file = ImageHelper.makeFile(part);

        Map upload = cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", file.getName()));

        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        user.setAvatar((String) upload.get("url"));

        userService.changeAvatar(user.getId(), user.getAvatar());

        resp.sendRedirect("/cabinet");
    }
}
