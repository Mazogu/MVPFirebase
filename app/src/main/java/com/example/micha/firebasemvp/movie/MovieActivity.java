package com.example.micha.firebasemvp.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micha.firebasemvp.R;
import com.example.micha.firebasemvp.main.MainActivity;

public class MovieActivity extends AppCompatActivity implements MovieContract.MoView{

    private MoviePresenter presenter;

    private EditText titleText,directorText,genreText,yearText,ratingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        titleText = findViewById(R.id.movieTitle);
        directorText = findViewById(R.id.movieDirector);
        genreText = findViewById(R.id.movieGenre);
        yearText = findViewById(R.id.movieYear);
        ratingText = findViewById(R.id.movieRating);
        presenter = new MoviePresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        if(!presenter.checkLogin()){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void showError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void signOut(View view) {
        presenter.signOut();
    }

    public void addMovie(View view) {
        presenter.addMovie(new com.example.micha.firebasemvp.model.Movie(titleText.getText().toString(),directorText.getText().toString(),
                genreText.getText().toString(),yearText.getText().toString(),ratingText.getText().toString()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void logout() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
