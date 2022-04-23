package com.example.tourguidapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.tourguidapp.databinding.ActivityCommonContentBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tourguidapp.databinding.ActivityCommonContentBinding;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCommonContentBinding binding;
    private String tittle;
    private float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_common_content);

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);



        Bundle b = getIntent().getExtras();
        if (b != null) {

            this.tittle = b.getString("tittle");
            this.rating = b.getFloat("rating");

        }

        View main_view = findViewById(R.id.common_content);

        TextView textView = main_view.findViewById(R.id.text);

        textView.setText(tittle);

        RatingBar ratingBar = main_view.findViewById(R.id.rating);

        ratingBar.setRating(rating);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}