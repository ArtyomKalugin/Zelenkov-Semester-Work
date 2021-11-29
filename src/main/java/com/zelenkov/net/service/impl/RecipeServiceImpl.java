package com.zelenkov.net.service.impl;

import com.zelenkov.net.dao.impl.RecipeDao;
import com.zelenkov.net.dao.impl.UserDao;
import com.zelenkov.net.dto.RecipeDto;
import com.zelenkov.net.model.Recipe;
import com.zelenkov.net.service.RecipeService;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeServiceImpl implements RecipeService {
    private final RecipeDao recipeDao = new RecipeDao();
    private final UserDao userDao = new UserDao();

    @Override
    public List<RecipeDto> getAll() {
        List<Recipe> recipes = recipeDao.getAll();

        return recipes.stream()
                .map(recipe -> new RecipeDto(recipe.getId(), userDao.get(recipe.getUserId()).getNickname(),
                        recipe.getTitle(), recipe.getText(), recipe.getPhoto(), recipe.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto get(int id) {
        Recipe recipe = recipeDao.get(id);
        String userNickname = userDao.get(recipe.getUserId()).getNickname();

        return new RecipeDto(recipe.getId(), userNickname, recipe.getTitle(),
                recipe.getText(), recipe.getPhoto(), recipe.getData());
    }

    @Override
    public void save(Recipe recipe) {
        recipeDao.save(recipe);
    }

    @Override
    public List<RecipeDto> getByTitle(String title) {
        List<Recipe> recipes = recipeDao.getByTitle(title);

        return recipes.stream()
                .map(recipe -> new RecipeDto(recipe.getId(), userDao.get(recipe.getUserId()).getNickname(),
                        recipe.getTitle(), recipe.getText(), recipe.getPhoto(), recipe.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDto> getByUserId(int userId) {
        List<Recipe> recipes = recipeDao.getByUserId(userId);

        return recipes.stream()
                .map(recipe -> new RecipeDto(recipe.getId(), userDao.get(recipe.getUserId()).getNickname(),
                        recipe.getTitle(), recipe.getText(), recipe.getPhoto(), recipe.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDto> getByUserIdAndTitle(int userId, String title) {
        List<Recipe> recipes = recipeDao.getByUserIdAndTitle(userId, title);

        return recipes.stream()
                .map(recipe -> new RecipeDto(recipe.getId(), userDao.get(recipe.getUserId()).getNickname(),
                        recipe.getTitle(), recipe.getText(), recipe.getPhoto(), recipe.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        recipeDao.delete(id);
    }

    @Override
    public void changeData(int id, String title, String text, String photo) {
        recipeDao.changeData(id, title, text, photo);
    }
}
