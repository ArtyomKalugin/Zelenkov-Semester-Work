package com.kalugin.net.service;

import com.kalugin.net.dto.ArticleCommentDto;
import com.kalugin.net.model.ArticleComment;

import java.util.List;

public interface ArticleCommentService {
    List<ArticleCommentDto> getAll();
    ArticleCommentDto get(int id);
    void save(ArticleComment comment);
    List<ArticleCommentDto> getAllByArticleId(int id);
}
