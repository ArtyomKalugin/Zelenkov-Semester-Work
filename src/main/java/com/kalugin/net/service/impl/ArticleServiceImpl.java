package com.kalugin.net.service.impl;

import com.kalugin.net.dao.impl.ArticleDao;
import com.kalugin.net.dao.impl.UserDao;
import com.kalugin.net.dto.ArticleDto;
import com.kalugin.net.model.Article;
import com.kalugin.net.service.ArticleService;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleServiceImpl implements ArticleService {
    private final ArticleDao articleDao = new ArticleDao();
    private final UserDao userDao = new UserDao();

    @Override
    public List<ArticleDto> getAll() {
        List<Article> articles = articleDao.getAll();

        return articles.stream()
                .map(article -> new ArticleDto(article.getId(), userDao.get(article.getUserId()).getNickname(),
                        article.getTitle(), article.getText(), article.getPhoto(), article.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDto get(int id) {
        Article article = articleDao.get(id);
        String userNickname = userDao.get(article.getUserId()).getNickname();

        return new ArticleDto(article.getId(), userNickname, article.getTitle(),
                article.getText(), article.getPhoto(), article.getData());
    }

    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public List<ArticleDto> getByTitle(String title) {
        List<Article> articles = articleDao.getByTitle(title);

        return articles.stream()
                .map(article -> new ArticleDto(article.getId(), userDao.get(article.getUserId()).getNickname(),
                        article.getTitle(), article.getText(), article.getPhoto(), article.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> getByUserId(int userId) {
        List<Article> articles = articleDao.getByUserId(userId);

        return articles.stream()
                .map(article -> new ArticleDto(article.getId(), userDao.get(article.getUserId()).getNickname(),
                        article.getTitle(), article.getText(), article.getPhoto(), article.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> getByUserIdAndTitle(int userId, String title) {
        List<Article> articles = articleDao.getByUserIdAndTitle(userId, title);

        return articles.stream()
                .map(article -> new ArticleDto(article.getId(), userDao.get(article.getUserId()).getNickname(),
                        article.getTitle(), article.getText(), article.getPhoto(), article.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        articleDao.delete(id);
    }
}
