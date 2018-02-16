package com.example.micha.firebasemvp.utils;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by micha on 2/15/2018.
 */

public class LoginAuthenticator {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private LoginFacilitator facilitator;
    private LogoutFacilitator logout;

    public LoginAuthenticator(LoginFacilitator facilitator) {
        this.facilitator = facilitator;
        auth = FirebaseAuth.getInstance();
    }

    public LoginAuthenticator(LogoutFacilitator logout){
        this.logout = logout;
        auth = FirebaseAuth.getInstance();
    }

    public void login(final String username, String password){
        auth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                user = auth.getCurrentUser();
                if(user!=null){
                    facilitator.sendResult(true);
                }
                else {
                    facilitator.sendResult(false);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        });
    }

    public boolean checkLogin() {
        user = auth.getCurrentUser();
        return user!=null ? true:false;
    }

    public void createUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                user = auth.getCurrentUser();
                if(user!=null){
                    facilitator.sendResult(true);
                }
                else{
                    facilitator.sendResult(false);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void logout() {
        auth.signOut();
        user = auth.getCurrentUser();
        if(user == null){
            logout.logout();
        }
    }

    public interface LoginFacilitator {
        void sendResult(boolean result);
    }

    public interface LogoutFacilitator{
        void logout();
    }
}
