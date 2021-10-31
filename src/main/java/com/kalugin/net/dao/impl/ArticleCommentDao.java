package com.kalugin.net.dao.impl;

import com.kalugin.net.dao.Dao;
import com.kalugin.net.helper.PostgresConnectionHelper;
import com.kalugin.net.model.ArticleComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleCommentDao implements Dao<ArticleComment> {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public ArticleComment get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM comment_article";
            ResultSet resultSet = statement.executeQuery(sql);

            ArticleComment article = null;

            while (resultSet.next()) {
                if(resultSet.getInt("id") == id) {
                    article = new ArticleComment(
                            resultSet.getInt("id"),
                            resultSet.getInt("user_id"),
                            resultSet.getInt("article_id"),
                            resultSet.getString("text")
                    );
                }
            }

            return article;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute get query.", throwables);
            return null;
        }
    }

    @Override
    public List<ArticleComment> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM comment_article";
            ResultSet resultSet = statement.executeQuery(sql);

            List<ArticleComment> comments = new ArrayList<>();

            while (resultSet.next()) {
                ArticleComment comment = new ArticleComment(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("article_id"),
                        resultSet.getString("text")
                );

                comments.add(comment);
            }

            return comments;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }

    @Override
    public void save(ArticleComment comment) {
        String sql = "INSERT INTO comment_article (user_id, article_id, text) " +
                "VALUES (?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, comment.getUserId());
            preparedStatement.setInt(2, comment.getArticleId());
            preparedStatement.setString(3, comment.getText());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new article comment.", throwables);
        }
    }

    public List<ArticleComment> getAllByArticleId(int id) {
        try {
            String sql = "SELECT * FROM comment_article WHERE article_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<ArticleComment> comments = new ArrayList<>();

            while (resultSet.next()) {
                ArticleComment comment = new ArticleComment(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("article_id"),
                        resultSet.getString("text")
                );

                comments.add(comment);
            }

            return comments;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }
}
