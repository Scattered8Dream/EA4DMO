package com.example.ea4.mvp;

import android.content.Context;
import android.widget.ListView;

import com.example.ea4.model.entities.Article;

public interface MainMVP {

    interface View{
        Context getContext();
    }

    interface Presenter{
        void deatach();
        void openDetails();
        void openDetails(Article article);
        void populateList(ListView listView);
        void favoriteArticle(Article article);
    }
}
