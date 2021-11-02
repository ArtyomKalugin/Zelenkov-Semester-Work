package com.kalugin.net.helper;

import com.kalugin.net.dto.UserDto;
import com.kalugin.net.service.UserService;
import com.kalugin.net.service.impl.UserServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CookieHelper {
    private final static UserService userService = new UserServiceImpl();

    public static void checkSession(HttpServletRequest req) {
        HttpSession session = req.getSession();

        if(session.getAttribute("user") == null) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if(c.getName().equals("login")) {
                        UserDto user = userService.getByLogin(c.getValue());
                        session.setAttribute("user", user);
                        req.setAttribute("user", user);
                    }
                }
            }
        }
    }

}
