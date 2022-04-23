package com.example.tourguidapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class tittle_list_adapter extends ArrayAdapter<tittle_list_object> {

    private int mColorResourceId ;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        // Get the object located at this position in the list
        tittle_list_object tittle_list_object = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.text);
        // Get the default translation from the current word object and
        // set this text on the number TextView
        numberTextView.setText(tittle_list_object.getLocation_tittle());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageview = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if(tittle_list_object.hasImage()){

            imageview.setImageResource(tittle_list_object.getImageResourceId());

        }else{

            imageview.setVisibility(View.GONE);

        }

        RatingBar ratingBar = listItemView.findViewById(R.id.rating) ;

        ratingBar.setRating(tittle_list_object.getRating());

        View textview = listItemView.findViewById(R.id.text_container) ;

        int color = ContextCompat.getColor(getContext(),mColorResourceId) ;

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        return listItemView;
    }

    public tittle_list_adapter(Activity context, ArrayList<tittle_list_object> _tittle_list_objects, int mColorResourceId){

        super(context,0, _tittle_list_objects);
        this.mColorResourceId = mColorResourceId ;

    }


}
