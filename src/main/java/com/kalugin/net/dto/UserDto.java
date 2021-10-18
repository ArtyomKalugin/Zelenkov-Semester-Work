package com.kalugin.net.dto;

public class UserDto {
    private final int id;
    private String nickname;
    private String firstName;
    private String secondName;
    private String email;
    private final String login;
    private String hashPassword;
    private String avatar;

    public UserDto(int id, String nickname, String firstName, String secondName, String email,
                String login, String hashPassword, String avatar) {
        this.id = id;
        this.nickname = nickname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.login = login;
        this.hashPassword = hashPassword;
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
