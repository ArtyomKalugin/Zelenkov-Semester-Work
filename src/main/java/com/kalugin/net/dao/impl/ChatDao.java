package com.kalugin.net.dao.impl;

import com.kalugin.net.dao.Dao;
import com.kalugin.net.helper.PostgresConnectionHelper;
import com.kalugin.net.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatDao implements Dao<Message> {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Message get(int id) {
        return null;
    }

    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public void save(Message message) {
        String sql = "INSERT INTO chat (to_user, from_user, text, date, from_user_nickname, avatar) " +
                "VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, message.getToUserId());
            preparedStatement.setInt(2, message.getFromUserId());
            preparedStatement.setString(3, message.getText());
            preparedStatement.setString(4, message.getDate());
            preparedStatement.setString(5, message.getFromUserNickname());
            preparedStatement.setString(6, message.getAvatar());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new message.", throwables);
        }
    }

    public List<Message> getAllByIds(int fromUserId, int toUserId) {
        try {
            String sql = "SELECT * FROM chat WHERE to_user = ? AND from_user = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, toUserId);
            preparedStatement.setInt(2, fromUserId);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Message> messages = new ArrayList<>();

            while (resultSet.next()) {
                Message message = new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("to_user"),
                        resultSet.getInt("from_user"),
                        resultSet.getString("text"),
                        resultSet.getString("date"),
                        resultSet.getString("from_user_nickname"),
                        resultSet.getString("avatar")
                );

                messages.add(message);
            }

            return messages;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }
 }
