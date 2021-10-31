package com.kalugin.net.dto;

public class ArticleCommentDto {
    private final int id;
    private final UserDto user;
    private final int articleId;
    private final String text;

    public ArticleCommentDto(int id, UserDto user, int articleId, String text) {
        this.id = id;
        this.user = user;
        this.articleId = articleId;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getRecipeId() {
        return articleId;
    }

    public String getText() {
        return text;
    }

    public UserDto getUser() {
        return user;
    }
}
