package com.example.micha.firebasemvp.utils;

import com.example.micha.firebasemvp.model.Movie;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by micha on 2/16/2018.
 */

public class FirebaseDB {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference movieRef = database.getReference("Movies");

    public void addMovie(Movie movie){
        movieRef.push().setValue(movie);
    }
}
