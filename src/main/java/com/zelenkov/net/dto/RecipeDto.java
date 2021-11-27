package com.zelenkov.net.dto;

public class RecipeDto {
    private final int id;
    private final String userNickname;
    private final String title;
    private final String text;
    private final String photo;
    private final String data;

    public RecipeDto(int id, String userNickname, String title, String text, String photo, String data) {
        this.id = id;
        this.userNickname = userNickname;
        this.title = title;
        this.text = text;
        this.photo = photo;
        this.data = data;
    }

    public int getId() {
        return id;
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

    public String getData() {
        return data;
    }

    public String getUserNickname() {
        return userNickname;
    }
}
