package com.kalugin.net.service;

import com.kalugin.net.dto.UserDto;
import com.kalugin.net.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    UserDto get(int id);
    UserDto getByLogin(String login);
    void save(User user);
    void delete(int id);
    void changeAvatar(int id, String url);
    List<UserDto> getAllByNickname(String nickname);
}