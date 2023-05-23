package com.example.ea4.presenter;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ea4.model.dao.ArticleDAOSingleton;
import com.example.ea4.model.dao.IArticleDAO;
import com.example.ea4.model.entities.Article;
import com.example.ea4.mvp.MainMVP;
import com.example.ea4.view.adapter.ArticleDetailsActivity;

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private IArticleDAO dao;
    Article article;

    public MainPresenter(MainMVP.View view){
        this.view = view;
        dao = ArticleDAOSingleton.getInstance();
    }

    @Override
    public void deatach() {
        view = null;
    }

    @Override
    public void openDetails(Article a) {
        Intent intent = new Intent(view.getContext(), ArticleDetailsActivity.class);
        view.getContext().startActivity(intent);
    }

    @Override
    public void openDetails(Article article){
        Intent intent = new Intent(view.getContext(), ArticleDetailsActivity.class);
        intent.putExtra( Constant.ATTR_TITLE, article.getTitle());
        view.getContext().startActivity(intent);
    }

    @Override
    public void populateList(ListView listView) {
        ArrayAdapter<Article> adapter = new ArrayAdapter<>(
                view.getContext(),
                android.R.layout.simple_list_item_1,
                dao.findAll());
        listView.setAdapter(adapter);
    }

    @Override
    public void favoriteArticle(Article article) {

    }
}
