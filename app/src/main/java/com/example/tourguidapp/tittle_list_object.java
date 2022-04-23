package com.example.tourguidapp;

public class tittle_list_object {

    private String location_tittle = new String();
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private float rating;
    private static final int NO_IMAGE_PROVIDED = -1;
    private String address;
    private String opens;
    private String closes;
    private String contact;
    private String geoLocation;
    private int photo_array[] ;
    private String about ;

    public tittle_list_object(String location_tittle,float rating, String address, String opens, String closes, String contact, String geoLocation ,int[] photo_array,String about) {

        this.location_tittle = location_tittle;
        this.mImageResourceId = photo_array[0];
        this.rating = rating;
        this.address = address;
        this.opens = opens;
        this.closes = closes;
        this.contact = contact;
        this.geoLocation = geoLocation;
        this.photo_array = photo_array ;
        this.about = about ;
    }

    public tittle_list_object(String location_tittle, float rating) {

        this.location_tittle = location_tittle;
        this.rating = rating;

    }

    public String getLocation_tittle() {
        return location_tittle;
    }

    public int getImageResourceId() {
        return photo_array[0];
    }

    public float getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getOpens() {
        return opens;
    }

    public String getCloses() {
        return closes;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public int[] getPhoto_array() {
        return photo_array;
    }

    public String getAbout() {
        return about;
    }

    public boolean hasImage() {

        return mImageResourceId != NO_IMAGE_PROVIDED;

    }
}
