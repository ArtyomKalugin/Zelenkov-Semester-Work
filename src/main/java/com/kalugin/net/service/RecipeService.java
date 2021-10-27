package com.kalugin.net.service;

import com.kalugin.net.dto.RecipeDto;
import com.kalugin.net.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> getAll();
    RecipeDto get(int id);
    void save(Recipe recipe);
    List<RecipeDto> getByTitle(String title);
    List<RecipeDto> getByUserId(int userId);
    List<RecipeDto> getByUserIdAndTitle(int userId, String title);
    void delete(int id);
}
