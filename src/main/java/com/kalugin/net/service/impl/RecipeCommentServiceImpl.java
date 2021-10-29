package com.kalugin.net.service.impl;

import com.kalugin.net.dao.impl.RecipeCommentDao;
import com.kalugin.net.dto.RecipeCommentDto;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.model.RecipeComment;
import com.kalugin.net.service.RecipeCommentService;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeCommentServiceImpl implements RecipeCommentService {
    private final RecipeCommentDao recipeCommentDao = new RecipeCommentDao();
    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    public List<RecipeCommentDto> getAll() {
        List<RecipeComment> comments = recipeCommentDao.getAll();

        return comments.stream()
                .map(comment -> new RecipeCommentDto(comment.getId(), userService.get(comment.getUserId()),
                        comment.getRecipeId(), comment.getText()))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeCommentDto get(int id) {
        RecipeComment comment = recipeCommentDao.get(id);
        UserDto user = userService.get(comment.getUserId());

        return new RecipeCommentDto(comment.getId(), user, comment.getRecipeId(), comment.getText());
    }

    @Override
    public void save(RecipeComment comment) {
        recipeCommentDao.save(comment);
    }

    @Override
    public List<RecipeCommentDto> getAllByRecipeId(int id) {
        List<RecipeComment> comments = recipeCommentDao.getAllByRecipeId(id);

        return comments.stream()
                .map(comment -> new RecipeCommentDto(comment.getId(), userService.get(comment.getUserId()),
                        comment.getRecipeId(), comment.getText()))
                .collect(Collectors.toList());
    }
}
