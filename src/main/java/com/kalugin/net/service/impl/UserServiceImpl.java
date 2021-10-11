package com.kalugin.net.service.impl;

import com.kalugin.net.dao.Dao;
import com.kalugin.net.dao.impl.UserDao;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.helper.PasswordHelper;
import com.kalugin.net.model.User;
import com.kalugin.net.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final Dao<User> userDao = new UserDao();

    @Override
    public List<UserDto> getAll() {
        List<User> users = userDao.getAll();
        return users.stream()
                .map(user -> new UserDto(user.getNickname(), user.getFirstName(), user.getSecondName(),
                        user.getEmail(), user.getLogin(), user.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto get(int id) {
        return null;
    }

    @Override
    public void save(User user) {
        userDao.save(new User(user.getNickname(), user.getFirstName(), user.getSecondName(),
                user.getEmail(), user.getLogin(), PasswordHelper.encrypt(user.getPassword())));
    }
}