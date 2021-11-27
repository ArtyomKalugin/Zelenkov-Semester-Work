package com.zelenkov.net.service;

import com.zelenkov.net.dto.UserDto;
import com.zelenkov.net.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    UserDto get(int id);
    UserDto getByLogin(String login);
    UserDto getByNickname(String nickname);
    void save(User user);
    void delete(int id);
    void changeAvatar(int id, String url);
    List<UserDto> getAllByNickname(String nickname);
}