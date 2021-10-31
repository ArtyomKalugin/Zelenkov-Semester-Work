package com.kalugin.net.dao.impl;

import com.kalugin.net.dao.Dao;
import com.kalugin.net.helper.PostgresConnectionHelper;
import com.kalugin.net.model.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao implements Dao<Article> {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Article get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM article";
            ResultSet resultSet = statement.executeQuery(sql);

            Article article = null;

            while (resultSet.next()) {
                if(resultSet.getInt("id") == id) {
                    article = new Article(
                            resultSet.getInt("id"),
                            resultSet.getInt("user_id"),
                            resultSet.getString("title"),
                            resultSet.getString("text"),
                            resultSet.getString("photo"),
                            resultSet.getString("date")
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
    public List<Article> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM article";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Article> articles = new ArrayList<>();

            while (resultSet.next()) {
                Article article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("photo"),
                        resultSet.getString("date")
                );

                articles.add(article);
            }

            return articles;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }

    @Override
    public void save(Article article) {
        String sql = "INSERT INTO article (user_id, title, text, photo, date) " +
                "VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, article.getUserId());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getText());
            preparedStatement.setString(4, article.getPhoto());
            preparedStatement.setString(5, article.getData());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new article.", throwables);
        }
    }

    public List<Article> getByTitle(String title) {
        try {
            String sql = "SELECT * FROM article WHERE title ILIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "%" + title + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Article> articles = new ArrayList<>();

            while (resultSet.next()) {
                Article article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("photo"),
                        resultSet.getString("date")
                );

                articles.add(article);
            }

            return articles;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }

    public List<Article> getByUserId(int userId) {
        try {
            String sql = "SELECT * FROM article WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Article> articles = new ArrayList<>();

            while (resultSet.next()) {
                Article article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("photo"),
                        resultSet.getString("date")
                );

                articles.add(article);
            }

            return articles;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }

    public List<Article> getByUserIdAndTitle(int userId, String title) {
        try {
            String sql = "SELECT * FROM article WHERE user_id = ? AND title ILIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, "%" + title + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Article> articles = new ArrayList<>();

            while (resultSet.next()) {
                Article article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("photo"),
                        resultSet.getString("date")
                );

                articles.add(article);
            }

            return articles;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM article WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to delete article.", throwables);
        }
    }
}
