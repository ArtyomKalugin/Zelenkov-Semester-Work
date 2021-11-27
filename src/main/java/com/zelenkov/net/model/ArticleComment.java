package com.zelenkov.net.model;

public class ArticleComment {
    private int id;
    private int userId;
    private int articleId;
    private String text;

    public ArticleComment(int id, int userId, int articleId, String text) {
        this.id = id;
        this.userId = userId;
        this.articleId = articleId;
        this.text = text;
    }

    public ArticleComment(int userId, int articleId, String text) {
        this.userId = userId;
        this.articleId = articleId;
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

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
