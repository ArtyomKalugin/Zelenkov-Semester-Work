package com.kalugin.net.service.impl;

import com.kalugin.net.dao.impl.ArticleCommentDao;
import com.kalugin.net.dto.ArticleCommentDto;
import com.kalugin.net.dto.RecipeCommentDto;
import com.kalugin.net.dto.UserDto;
import com.kalugin.net.model.ArticleComment;
import com.kalugin.net.model.RecipeComment;
import com.kalugin.net.service.ArticleCommentService;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleCommentServiceImpl implements ArticleCommentService {
    private final ArticleCommentDao articleCommentDao = new ArticleCommentDao();
    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    public List<ArticleCommentDto> getAll() {
        List<ArticleComment> comments = articleCommentDao.getAll();

        return comments.stream()
                .map(comment -> new ArticleCommentDto(comment.getId(), userService.get(comment.getUserId()),
                        comment.getArticleId(), comment.getText()))
                .collect(Collectors.toList());
    }

    @Override
    public ArticleCommentDto get(int id) {
        ArticleComment comment = articleCommentDao.get(id);
        UserDto user = userService.get(comment.getUserId());

        return new ArticleCommentDto(comment.getId(), user, comment.getArticleId(), comment.getText());
    }

    @Override
    public void save(ArticleComment comment) {
        articleCommentDao.save(comment);
    }

    @Override
    public List<ArticleCommentDto> getAllByArticleId(int id) {
        List<ArticleComment> comments = articleCommentDao.getAllByArticleId(id);

        return comments.stream()
                .map(comment -> new ArticleCommentDto(comment.getId(), userService.get(comment.getUserId()),
                        comment.getArticleId(), comment.getText()))
                .collect(Collectors.toList());
    }
}
