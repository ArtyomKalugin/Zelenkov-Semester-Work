package com.zelenkov.net.service;

import com.zelenkov.net.dto.RecipeDto;
import com.zelenkov.net.model.Recipe;

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
