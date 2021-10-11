package com.kalugin.net.dto;

public class UserDto {
    private String nickname;
    private String firstName;
    private String secondName;
    private String email;
    private String login;
    private String hashPassword;

    public UserDto(String nickname, String firstName, String secondName, String email,
                String login, String hashPassword) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.login = login;
        this.hashPassword = hashPassword;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
}
