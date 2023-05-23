package com.example.ea4.mvp;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ea4.model.entities.Article;

public interface ArticleDetailsMVP {

    interface View{
        void updateUI(String title, String url);

        Bundle getBundle();

        void showToast(String message);

        void close();
    }

    interface Presenter{
        void deatach();

        void verifyUpdate();

        void saveArticle(String title, String url);

    }

}
