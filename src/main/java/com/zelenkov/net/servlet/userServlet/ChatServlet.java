package com.zelenkov.net.servlet.userServlet;

import com.zelenkov.net.dto.MessageDto;
import com.zelenkov.net.dto.UserDto;
import com.zelenkov.net.model.Message;
import com.zelenkov.net.service.ChatService;
import com.zelenkov.net.service.impl.ChatServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@WebServlet(name = "chatServlet", urlPatterns = "/chat")
public class ChatServlet extends HttpServlet {
    private final ChatService chatService = new ChatServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto userNow = (UserDto) session.getAttribute("user");
        int userToId = Integer.parseInt(req.getParameter("id"));

        List<MessageDto> messages = chatService.getAllByIds(userNow.getId(), userToId);
        List<MessageDto> messages1 = chatService.getAllByIds(userToId, userNow.getId());
        messages.addAll(messages1);
        messages.sort(Comparator.comparingInt(MessageDto::getId));

        req.setAttribute("chat", messages);
        req.setAttribute("opp", req.getParameter("id"));

        req.getRequestDispatcher("chat.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        int userToId = Integer.parseInt(req.getParameter("id"));
        String text = req.getParameter("text");
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

        if(!text.equals("")) {
            Message message = new Message(userToId, user.getId(), text, formatForDateNow.format(date),
                    user.getNickname(), user.getAvatar());
            chatService.save(message);
        }
        
        String redirect = "/chat?id=" + req.getParameter("id");
        resp.sendRedirect(redirect);
    }
}
