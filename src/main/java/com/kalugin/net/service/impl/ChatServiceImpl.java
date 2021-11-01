package com.kalugin.net.service.impl;

import com.kalugin.net.dao.impl.ChatDao;
import com.kalugin.net.dto.MessageDto;
import com.kalugin.net.model.Message;
import com.kalugin.net.service.ChatService;

import java.util.List;
import java.util.stream.Collectors;

public class ChatServiceImpl implements ChatService {
    private final ChatDao chatDao = new ChatDao();

    @Override
    public List<MessageDto> getAll() {
        List<Message> messages = chatDao.getAll();

        return messages.stream()
                .map(message -> new MessageDto(message.getId(),message.getToUserId(), message.getFromUserId(),
                        message.getText(), message.getDate(), message.getFromUserNickname(), message.getAvatar()))
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto get(int id) {
        Message message = chatDao.get(id);

        return new MessageDto(message.getId(), message.getToUserId(), message.getFromUserId(),
                message.getText(), message.getDate(), message.getFromUserNickname(), message.getAvatar());
    }

    @Override
    public void save(Message message) {
        chatDao.save(message);
    }

    @Override
    public List<MessageDto> getAllByIds(int fromUserId, int toUserId) {
        List<Message> messages = chatDao.getAllByIds(fromUserId, toUserId);

        return messages.stream()
                .map(message -> new MessageDto(message.getId(), message.getToUserId(), message.getFromUserId(),
                        message.getText(), message.getDate(), message.getFromUserNickname(), message.getAvatar()))
                .collect(Collectors.toList());
    }
}
