package com.zelenkov.net.service;

import com.zelenkov.net.dto.RecipeCommentDto;
import com.zelenkov.net.model.RecipeComment;

import java.util.List;

public interface RecipeCommentService {
    List<RecipeCommentDto> getAll();
    RecipeCommentDto get(int id);
    void save(RecipeComment comment);
    List<RecipeCommentDto> getAllByRecipeId(int id);
}
