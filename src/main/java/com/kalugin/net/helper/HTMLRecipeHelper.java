package com.kalugin.net.helper;

import com.kalugin.net.dto.RecipeDto;

import java.util.List;

public class HTMLRecipeHelper {
    public static String makeHTML(List<RecipeDto> recipes) {
        StringBuilder result = new StringBuilder();

        if(recipes.size() == 0) {
            result.append("<p class=\"lead\">Нет рецептов!</p>");
        } else {
            for(RecipeDto recipe : recipes) {
                result.append("<a href=\"/detailRecipe?id=").append(recipe.getId()).append("\">")
                        .append("<div class=\"alert alert-dark\" role=\"alert\">")
                        .append("<h2>").append(recipe.getTitle()).append("</h2>")
                        .append("<div>").append(recipe.getText()).append("</div>")
                        .append("<br>")
                        .append("<img src=\"").append(recipe.getPhoto()).append("\" width=\"665\" height=\"350\">")
                        .append("<br>").append("<br>")
                        .append("<div><small class=\"text-muted\">").append(recipe.getUserNickname())
                        .append(" ").append(recipe.getData()).append("</small></div>")
                        .append("<div><small class=\"text-muted\">Рецепт ").append(recipe.getId()).append("</small></div>")
                        .append("</div>").append("</a>");
            }
        }

        return result.toString();
    }
}
