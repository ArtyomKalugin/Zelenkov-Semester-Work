package com.kalugin.net.service;

import com.kalugin.net.dto.ArticleDto;
import com.kalugin.net.model.Article;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getAll();
    ArticleDto get(int id);
    void save(Article article);
    List<ArticleDto> getByTitle(String title);
    List<ArticleDto> getByUserId(int userId);
    List<ArticleDto> getByUserIdAndTitle(int userId, String title);
    void delete(int id);
}
