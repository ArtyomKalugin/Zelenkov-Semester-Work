package com.kalugin.net.dto;

public class MessageDto {
    private final int id;
    private final int toUserId;
    private final int fromUserId;
    private final String text;
    private final String date;
    private final String fromUserNickname;
    private final String avatar;

    public MessageDto(int id, int toUserId, int fromUserId, String text, String date, String fromUserNickname, String avatar) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public String getFromUserNickname() {
        return fromUserNickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getId() {
        return id;
    }
}
