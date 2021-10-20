package com.kalugin.net.service.impl;

import com.kalugin.net.dao.impl.UserDao;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.helper.PasswordHelper;
import com.kalugin.net.model.User;
import com.kalugin.net.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDao();

    @Override
    public List<UserDto> getAll() {
        List<User> users = userDao.getAll();

        return users.stream()
                .map(user -> new UserDto(user.getId(), user.getNickname(), user.getFirstName(), user.getSecondName(),
                        user.getEmail(), user.getLogin(), user.getPassword(), user.getAvatar()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto get(int id) {
       User user = userDao.get(id);

       return new UserDto(user.getId(), user.getNickname(), user.getFirstName(), user.getSecondName(),
               user.getEmail(), user.getLogin(), user.getPassword(), user.getAvatar());
    }

    @Override
    public UserDto getByLogin(String login) {
        User user = userDao.getByLogin(login);

        return new UserDto(user.getId(), user.getNickname(), user.getFirstName(), user.getSecondName(),
                user.getEmail(), user.getLogin(), user.getPassword(), user.getAvatar());
    }

    @Override
    public void save(User user) {
        userDao.save(new User(user.getNickname(), user.getFirstName(), user.getSecondName(),
                user.getEmail(), user.getLogin(), PasswordHelper.encrypt(user.getPassword()), user.getAvatar()));
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void changeAvatar(int id, String url) {
        userDao.changeAvatar(id, url);
    }
}