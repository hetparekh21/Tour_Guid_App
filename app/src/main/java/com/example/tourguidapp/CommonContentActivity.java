package com.example.tourguidapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

//import com.example.tourguidapp.databinding.ActivityCommonContentBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Layout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//import com.example.tourguidapp.databinding.ActivityCommonContentBinding;

public class CommonContentActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    //    private ActivityCommonContentBinding binding;
    private String tittle;
    private float rating;
    final static private int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = -1;
    private String address;
    private String opens;
    private String closes;
    private String contact;
    private boolean PHOTO_CLICKED = false;
    private String geoLocation;
    private int[] location_photos;
    private String about_text;

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
            this.mImageResourceId = b.getInt("mImageResourceId");
            this.address = b.getString("address");
            this.opens = b.getString("opens");
            this.closes = b.getString("closes");
            this.contact = b.getString("contact");
            this.geoLocation = b.getString("geoLocation");
            this.location_photos = b.getIntArray("location_photos");
            this.about_text = b.getString("about");
        }

        View main_view = findViewById(R.id.common_content);

        // setting the tittle of the location
        TextView textView = main_view.findViewById(R.id.text);

        textView.setText(tittle);

        // setting the rating of the location
        RatingBar ratingBar = main_view.findViewById(R.id.rating);

        ratingBar.setRating(rating);

        // setting the main image of the location
        ImageView mainImage = findViewById(R.id.image);

        if (mImageResourceId != NO_IMAGE_PROVIDED) {

            mainImage.setImageResource(mImageResourceId);

        } else {

            mainImage.setVisibility(View.GONE);

        }

        // setting the address of the location
        TextView location_address = findViewById(R.id.address);

        location_address.setText(address);

        RelativeLayout location_address_part = findViewById(R.id.location);

        // setting map intent
        location_address_part.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri mapIntentUri = Uri.parse(geoLocation);
                Intent map = new Intent(Intent.ACTION_VIEW);
                map.setData(mapIntentUri);
                startActivity(map);

            }
        });

        // setting the open and close time ;

        TextView location_open = findViewById(R.id.opens);

        TextView location_close = findViewById(R.id.closes);

        if (opens.equals("")) {

            location_open.setVisibility(View.GONE);

            location_close.setText("Timings Not Available ");

        } else if (opens.equals("24hrs")) {

            location_close.setVisibility(View.GONE);

            location_open.setText("Open "+opens);

        } else {

            location_open.setText(location_open.getText() + opens + " -");

            location_close.setText(location_close.getText() + closes);

        }

        // setting about

        TextView textView1 = findViewById(R.id.about_text);

        textView1.setText(textView1.getText() + about_text);

        // setting contact info

        TextView location_contact = findViewById(R.id.contact);

        if (contact.equals("")) {

            location_contact.setText("Contact Info Not Available");

        } else {

            location_contact.setText(contact);

            RelativeLayout location_contact_part = findViewById(R.id.phone);

            // setting phone dial intent
            location_contact_part.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent phone = new Intent(Intent.ACTION_DIAL);
                    phone.setData(Uri.parse("tel:" + contact));

                    startActivity(phone);

                }
            });

        }

        Button overview = findViewById(R.id.overview_button);

        Button about = findViewById(R.id.about_button);

        Button photos = findViewById(R.id.photos_button);

        View photos_layout = main_view.findViewById(R.id.photos);

        View about_layout = main_view.findViewById(R.id.about);

        View overview_layout = main_view.findViewById(R.id.overview);

        overview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                overview.setBackground(getDrawable(R.drawable.button_active));

                about.setBackground(getDrawable(R.drawable.button));

                photos.setBackground(getDrawable(R.drawable.button));

                overview_layout.setVisibility(View.VISIBLE);

                photos_layout.setVisibility(View.GONE);

                about_layout.setVisibility(View.GONE);


            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                about.setBackground(getDrawable(R.drawable.button_active));

                photos.setBackground(getDrawable(R.drawable.button));

                overview.setBackground(getDrawable(R.drawable.button));

                about_layout.setVisibility(View.VISIBLE);

                photos_layout.setVisibility(View.GONE);

                overview_layout.setVisibility(View.GONE);

            }
        });

        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                photos.setBackground(getDrawable(R.drawable.button_active));

                overview.setBackground(getDrawable(R.drawable.button));

                about.setBackground(getDrawable(R.drawable.button));

                photos_layout.setVisibility(View.VISIBLE);

                overview_layout.setVisibility(View.GONE);

                about_layout.setVisibility(View.GONE);

                if (!PHOTO_CLICKED) {

                    for (int i = 0; i < location_photos.length; i++) {

                        PHOTO_CLICKED = true;

                        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                        layoutParams1.leftMargin = 16;
                        layoutParams1.rightMargin = 16;
                        layoutParams1.topMargin = 10;

                        // creating first image
                        ImageView imageView = new ImageView(CommonContentActivity.this);

                        imageView.setImageResource(location_photos[i]);

                        ScrollView photos = main_view.findViewById(R.id.photos);

                        LinearLayout photo_grid = photos.findViewById(R.id.photos_grid);

                        CardView cardView = new CardView(CommonContentActivity.this);
                        cardView.setRadius(10);
                        cardView.setLayoutParams(layoutParams1);
                        cardView.addView(imageView);
                        cardView.setPadding(16, 16, 16, 16);

                        photo_grid.addView(cardView);

                    }

                }

            }
        });


    }

}