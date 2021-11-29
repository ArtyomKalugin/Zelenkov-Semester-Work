package com.zelenkov.net.dao.impl;

import com.zelenkov.net.dao.Dao;
import com.zelenkov.net.helper.PostgresConnectionHelper;
import com.zelenkov.net.model.User;;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public User get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            User user = null;

            while (resultSet.next()) {
                if(resultSet.getInt("id") == id) {
                    user = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("nickname"),
                            resultSet.getString("first_name"),
                            resultSet.getString("second_name"),
                            resultSet.getString("email"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getString("avatar")
                    );
                }
            }

            return user;
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            return null;
        }
    }

    public User getByLogin(String login) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            User user = null;

            while (resultSet.next()) {
                if(resultSet.getString("login").equals(login)) {
                    user = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("nickname"),
                            resultSet.getString("first_name"),
                            resultSet.getString("second_name"),
                            resultSet.getString("email"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getString("avatar")
                    );
                }
            }

            return user;
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            return null;
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    public void changeAvatar(int id, String url) {
        String sql = "UPDATE users SET avatar = ? WHERE users.id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, url);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }


    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("nickname"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("avatar")
                );
                users.add(user);
            }

            return users;
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (nickname, first_name, second_name, email, login, password, avatar) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getSecondName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getAvatar());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    public List<User> getAllByNickname(String nickname) {
        try {
            String sql = "SELECT * FROM users WHERE nickname ILIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "%" + nickname + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("nickname"),
                        resultSet.getString("first_name"),
                        resultSet.getString("second_name"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("avatar")
                );
                users.add(user);
            }

            return users;
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            return new ArrayList<>();
        }
    }

    public User getByNickname(String nickname) {
        try {
            String sql = "SELECT * FROM users WHERE nickname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;

            while (resultSet.next()) {
                if(resultSet.getString("nickname").equals(nickname)) {
                    user = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("nickname"),
                            resultSet.getString("first_name"),
                            resultSet.getString("second_name"),
                            resultSet.getString("email"),
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getString("avatar")
                    );
                }
            }

            return user;
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            return null;
        }
    }
}
