package com.kalugin.net.helper;

import com.kalugin.net.dto.UserDto;

import java.util.List;

public class HTMLUsersHelper {
    public static String makeHTML(List<UserDto> users) {
        StringBuilder result = new StringBuilder();

        if(users.size() == 0) {
            result.append("<p class=\"lead\">Нет пользователей!</p>");
        } else {
            for(UserDto user : users) {
                result.append("<a href=\"/detailUser?id=").append(user.getId()).append("\">")
                        .append("<div class=\"alert alert-dark\" role=\"alert\">")
                        .append("<table>").append("<tr>")
                        .append("<td><img alt=\"user_img\" src=\"").append(user.getAvatar())
                        .append("\" width=\"50\" height=\"50\" class=\"rounded-circle\"></td>")
                        .append("<td>").append("<h3>")
                        .append("<strong>").append(user.getNickname()).append("</strong>")
                        .append("</h3></td></tr></table></div></a>");
            }
        }

        return result.toString();
    }
}
