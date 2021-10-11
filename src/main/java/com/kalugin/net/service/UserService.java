package com.kalugin.net.service;

import com.kalugin.net.dto.UserDto;
import com.kalugin.net.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    UserDto get(int id);
    void save(User user);
}