package com.kalugin.net.model;

public class RecipeComment {
    private int id;
    private int userId;
    private int recipeId;
    private String text;

    public RecipeComment(int id, int userId, int recipeId, String text) {
        this.id = id;
        this.userId = userId;
        this.recipeId = recipeId;
        this.text = text;
    }

    public RecipeComment(int userId, int recipeId, String text) {
        this.userId = userId;
        this.recipeId = recipeId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
