package com.kalugin.net.service.impl;

import com.kalugin.net.dao.impl.RecipeDao;
import com.kalugin.net.dto.RecipeDto;
import com.kalugin.net.model.Recipe;
import com.kalugin.net.service.RecipeService;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeServiceImpl implements RecipeService {
    private final RecipeDao recipeDao = new RecipeDao();

    @Override
    public List<RecipeDto> getAll() {
        List<Recipe> recipes = recipeDao.getAll();

        return recipes.stream()
                .map(recipe -> new RecipeDto(recipe.getId(), recipe.getUserId(), recipe.getTitle(),
                        recipe.getText(), recipe.getPhoto()))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto get(int id) {
        Recipe recipe = recipeDao.get(id);

        return new RecipeDto(recipe.getId(), recipe.getUserId(), recipe.getTitle(),
                recipe.getText(), recipe.getPhoto());
    }

    @Override
    public void save(Recipe recipe) {
        recipeDao.save(recipe);
    }
}
