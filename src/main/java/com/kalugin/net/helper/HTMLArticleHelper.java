package com.kalugin.net.helper;

import com.kalugin.net.dto.ArticleDto;

import java.util.List;

public class HTMLArticleHelper {
    public static String makeHTML(List<ArticleDto> articles) {
        StringBuilder result = new StringBuilder();

        if(articles.size() == 0) {
            result.append("<p class=\"lead\">Нет статей!</p>");
        } else {
            for(ArticleDto article : articles) {
                result.append("<a href=\"/detailArticle?id=").append(article.getId()).append("\">")
                        .append("<div class=\"alert alert-dark\" role=\"alert\">")
                        .append("<h2>").append(article.getTitle()).append("</h2>")
                        .append("<div>").append(article.getText()).append("</div>")
                        .append("<br>")
                        .append("<img src=\"").append(article.getPhoto()).append("\" width=\"665\" height=\"350\">")
                        .append("<br>").append("<br>")
                        .append("<div><small class=\"text-muted\">").append(article.getUserNickname())
                        .append(" ").append(article.getData()).append("</small></div>")
                        .append("<div><small class=\"text-muted\">Статья ").append(article.getId()).append("</small></div>")
                        .append("</div>").append("</a>");
            }
        }

        return result.toString();
    }
}
