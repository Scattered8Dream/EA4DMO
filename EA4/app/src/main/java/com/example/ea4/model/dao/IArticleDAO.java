package com.example.ea4.model.dao;

import com.example.ea4.model.entities.Article;
import com.example.ea4.model.entities.Tag;

import java.util.List;

public interface IArticleDAO {

    void create(Article article);
    boolean update(String oldTitle, Article article);
    boolean delete(Article article);
    Article findByTitle(String title);
    List<Article> findByTag(Tag tag);
    List<Article> findAll();
}
