package com.example.ea4.model.dao;

import com.example.ea4.model.entities.Article;
import com.example.ea4.model.entities.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArticleDAOSingleton implements  IArticleDAO {
    private static ArticleDAOSingleton instance = null;
    private List<Article> dataset;

    private ArticleDAOSingleton(){
        dataset = new ArrayList<>();
    }

    public static ArticleDAOSingleton getInstance(){
        if(instance == null)
            instance = new ArticleDAOSingleton();
        return instance;
    }


    @Override
    public void create(Article article) {
        if(article != null){
            dataset.add(article);
        }
    }

    @Override
    public boolean update(String oldTitle, Article article) {
        Article inDataset;
        inDataset = dataset.stream().filter(article1 -> article1.getTitle().equals(oldTitle)).findAny().orElse(null);
        if (inDataset != null){
            inDataset.setTitle(article.getTitle());
            inDataset.setUrl(article.getUrl());
            inDataset.setFavorite(article.isFavorite());
            inDataset.getTags().clear();
            inDataset.getTags().addAll(article.getTags());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Article article) {
        return dataset.remove(article);
    }

    @Override
    public Article findByTitle(String title) {
        return dataset.stream().filter(article -> article.getTitle().equals(title)).findFirst().orElse(null);
    }

    @Override
    public List<Article> findByTag(Tag tag) {
        List<Article> selection = new ArrayList<>();
        for(Article a : dataset){
            for (Tag t : a.getTags()){
                if(t.getTagName().equals(tag.getTagName())){
                    selection.add(a);
                }
            }
        }
        return selection;
    }

    @Override
    public List<Article> findAll() {
        return dataset;
    }
}
