package com.kalugin.net.dao.impl;

import com.kalugin.net.dao.Dao;
import com.kalugin.net.helper.PostgresConnectionHelper;
import com.kalugin.net.model.Recipe;
import com.kalugin.net.model.RecipeComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeCommentDao implements Dao<RecipeComment> {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public RecipeComment get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM comment_recipe";
            ResultSet resultSet = statement.executeQuery(sql);

            RecipeComment comment = null;

            while (resultSet.next()) {
                if(resultSet.getInt("id") == id) {
                    comment = new RecipeComment(
                            resultSet.getInt("id"),
                            resultSet.getInt("user_id"),
                            resultSet.getInt("recipe_id"),
                            resultSet.getString("text")
                    );
                }
            }

            return comment;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute get query.", throwables);
            return null;
        }
    }

    @Override
    public List<RecipeComment> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM comment_recipe";
            ResultSet resultSet = statement.executeQuery(sql);

            List<RecipeComment> comments = new ArrayList<>();

            while (resultSet.next()) {
                RecipeComment comment = new RecipeComment(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("recipe_od"),
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
    public void save(RecipeComment comment) {
        String sql = "INSERT INTO comment_recipe (user_id, recipe_id, text) " +
                "VALUES (?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, comment.getUserId());
            preparedStatement.setInt(2, comment.getRecipeId());
            preparedStatement.setString(3, comment.getText());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new recipe comment.", throwables);
        }
    }

    public List<RecipeComment> getAllByRecipeId(int id) {
        try {
            String sql = "SELECT * FROM comment_recipe WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<RecipeComment> comments = new ArrayList<>();

            while (resultSet.next()) {
                RecipeComment comment = new RecipeComment(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("recipe_od"),
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
