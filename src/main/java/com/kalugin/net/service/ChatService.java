package com.kalugin.net.service;

import com.kalugin.net.dto.MessageDto;
import com.kalugin.net.model.Message;

import java.util.List;

public interface ChatService {
    List<MessageDto> getAll();
    MessageDto get(int id);
    void save(Message message);
    List<MessageDto> getAllByIds(int fromUserId, int toUserId);
}
