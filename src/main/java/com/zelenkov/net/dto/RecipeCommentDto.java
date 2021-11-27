package com.zelenkov.net.dto;

public class RecipeCommentDto {
    private final int id;
    private final UserDto user;
    private final int recipeId;
    private final String text;

    public RecipeCommentDto(int id, UserDto user, int recipeId, String text) {
        this.id = id;
        this.user = user;
        this.recipeId = recipeId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getText() {
        return text;
    }

    public UserDto getUser() {
        return user;
    }
}
