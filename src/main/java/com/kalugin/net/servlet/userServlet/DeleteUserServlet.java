package com.kalugin.net.servlet.userServlet;

import com.kalugin.net.dto.UserDto;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "deleteUserServlet", urlPatterns = "/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                resp.addCookie(c);
            }
        }

        HttpSession session = req.getSession(false);

        if (session != null) {
            UserDto user = (UserDto) session.getAttribute("user");
            userService.delete(user.getId());

            session.invalidate();
        }

        resp.sendRedirect("info.ftl");
    }
}