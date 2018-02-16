package com.example.micha.firebasemvp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micha.firebasemvp.R;
import com.example.micha.firebasemvp.utils.LoginAuthenticator;

public class MainActivity extends AppCompatActivity implements MainContract.MView{

    public static final String TAG = MainActivity.class.getSimpleName();
    MainPresenter presenter;
    private EditText emailText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter();
        presenter.attachView(this);
        emailText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(presenter.checkLogin()){
            Log.d(TAG, "onStart: You're logged in already");
        }
        else{
            Log.d(TAG, "onStart: Nope");
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
            Log.d(TAG, "loginComplete: You're logged in");
        }
        else{
            Log.d(TAG, "loginComplete: Login failed");
        }
    }
}
