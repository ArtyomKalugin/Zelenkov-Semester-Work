package com.kalugin.net.dto;

public class RecipeDto {
    private final int id;
    private final int userId;
    private final String title;
    private final String text;
    private final String photo;


    public RecipeDto(int id, int userId, String title, String text, String photo) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getPhoto() {
        return photo;
    }
}
