package com.example.micha.firebasemvp.article;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.micha.firebasemvp.R;
import com.example.micha.firebasemvp.main.MainActivity;

public class ArticleActivity extends AppCompatActivity implements ArticleContract.AView {

    private ArticlePresenter presenter;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcticle);
        presenter = new ArticlePresenter();
        text = findViewById(R.id.articleText);
        String article = getIntent().getStringExtra("article");
        if(article != null){
            SharedPreferences preferences = getSharedPreferences("Articles", Context.MODE_PRIVATE);
            String articleText = preferences.getString(article, "nothing");
            if(articleText.equals("nothing")){
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("101","This is article one");
                editor.putString("202", "This is article two");
                editor.putString("303", "This is article three");
                editor.commit();
            }

            text.setText(preferences.getString(article,"blank"));

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        if(!presenter.checkLogin()){
            backToMain();
        }
    }

    private void backToMain() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void logOut(View view) {
        presenter.signOut();
    }

    @Override
    public void logout(){
        backToMain();
    }
}
