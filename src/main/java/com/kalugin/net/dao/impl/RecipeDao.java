package com.kalugin.net.dao.impl;

import com.kalugin.net.dao.Dao;
import com.kalugin.net.helper.PostgresConnectionHelper;
import com.kalugin.net.model.Recipe;
import com.kalugin.net.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDao implements Dao<Recipe> {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Recipe get(int id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            Recipe recipe = null;

            while (resultSet.next()) {
                if(resultSet.getInt("id") == id) {
                    recipe = new Recipe(
                            resultSet.getInt("id"),
                            resultSet.getInt("user_id"),
                            resultSet.getString("title"),
                            resultSet.getString("text"),
                            resultSet.getString("photo")
                    );
                }
            }

            return recipe;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute get query.", throwables);
            return null;
        }
    }

    @Override
    public List<Recipe> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM recipe";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Recipe> recipes = new ArrayList<>();

            while (resultSet.next()) {
                Recipe recipe = new Recipe(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("text"),
                        resultSet.getString("photo")
                );

                recipes.add(recipe);
            }

            return recipes;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query.", throwables);
            return new ArrayList<>();
        }
    }

    @Override
    public void save(Recipe recipe) {
        String sql = "INSERT INTO recipe (user_id, title, text, photo) " +
                "VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, recipe.getUserId());
            preparedStatement.setString(2, recipe.getTitle());
            preparedStatement.setString(3, recipe.getText());
            preparedStatement.setString(4, recipe.getPhoto());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            LOGGER.warn("Failed to save new recipe.", throwables);
        }
    }
}
