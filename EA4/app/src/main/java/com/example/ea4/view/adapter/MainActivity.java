package com.example.ea4.view.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ea4.R;
import com.example.ea4.model.entities.Article;
import com.example.ea4.mvp.MainMVP;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements MainMVP.View {

    private MainMVP.Presenter presenter;
    private FloatingActionButton actionButton;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
        presenter = new MainPresenter(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.populateList(listView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void setListener() {
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.openDetails(a);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article a = (Article) listView.getAdapter().getItem(position);
                presenter.openDetails(a);
            }
        });
    }
}
