package com.kalugin.net.service;

import com.kalugin.net.dto.RecipeCommentDto;
import com.kalugin.net.model.RecipeComment;

import java.util.List;

public interface RecipeCommentService {
    List<RecipeCommentDto> getAll();
    RecipeCommentDto get(int id);
    void save(RecipeComment comment);
    List<RecipeCommentDto> getAllByRecipeId(int id);
}
