package com.zelenkov.net.model;

public class Message {
    private int id;
    private int toUserId;
    private int fromUserId;
    private String text;
    private String date;
    private String fromUserNickname;
    private String avatar;

    public Message(int id, int toUserId, int fromUserId, String text, String date, String fromUserNickname, String avatar) {
        this.id = id;
        this.toUserId = toUserId;
        this.fromUserId = fromUserId;
        this.text = text;
        this.date = date;
        this.fromUserNickname = fromUserNickname;
        this.avatar = avatar;
    }

    public Message(int toUserId, int fromUserId, String text, String date, String fromUserNickname, String avatar) {
        this.toUserId = toUserId;
        this.fromUserId = fromUserId;
        this.text = text;
        this.date = date;
        this.fromUserNickname = fromUserNickname;
        this.avatar = avatar;
    }

    public int getToUserId() {
        return toUserId;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public String getFromUserNickname() {
        return fromUserNickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
