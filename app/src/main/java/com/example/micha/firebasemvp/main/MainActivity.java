package com.example.micha.firebasemvp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micha.firebasemvp.R;
import com.example.micha.firebasemvp.movie.MovieActivity;

public class MainActivity extends AppCompatActivity implements MainContract.MView{

    public static final String TAG = MainActivity.class.getSimpleName();
    MainPresenter presenter;
    private EditText emailText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
        presenter = new MainPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        if(presenter.checkLogin()){
            if(getIntent() != null){
                startActivity(getIntent());
            }
            Intent intent = new Intent(getApplicationContext(), MovieActivity.class);
            startActivity(intent);
        }
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

    public void authenticate(View view) {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        switch(view.getId()){
            case R.id.login:
                presenter.login(email,password);
                break;

            case R.id.create:
                presenter.createUser(email,password);
                break;
        }
    }

    @Override
    public void loginComplete(boolean isLoggedIn) {
        if(isLoggedIn){
            Intent intent = new Intent(getApplicationContext(),MovieActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "loginComplete: Login failed", Toast.LENGTH_SHORT).show();
        }
    }
}
