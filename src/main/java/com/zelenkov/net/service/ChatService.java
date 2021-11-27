package com.zelenkov.net.service;

import com.zelenkov.net.dto.MessageDto;
import com.zelenkov.net.model.Message;

import java.util.List;

public interface ChatService {
    List<MessageDto> getAll();
    MessageDto get(int id);
    void save(Message message);
    List<MessageDto> getAllByIds(int fromUserId, int toUserId);
}
