package com.example.tourguidapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricalMonumentFragment extends Fragment {

    public HistoricalMonumentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.common_list, container, false);

        final int[] BaiHarirVav = {R.drawable.baiharirvav_main,R.drawable.baiharirvav1,R.drawable.baiharirvav2,R.drawable.baiharirvav3,R.drawable.baiharirvav4,R.drawable.baiharirvav5,R.drawable.baiharirvav6,R.drawable.baiharirvav7,R.drawable.baiharirvav8,R.drawable.baiharirvav9} ;
        final int[] SidiSaiyyedMosque = {R.drawable.ssm_main,R.drawable.ssm1,R.drawable.ssm2,R.drawable.ssm3,R.drawable.ssm4,R.drawable.ssm5,R.drawable.ssm6,R.drawable.ssm7,R.drawable.ssm8,R.drawable.ssm9} ;
        final int[] SabarmatiAshram = {R.drawable.sabarmatiashram_main,R.drawable.sabarmatiashram1,R.drawable.sabarmatiashram2,R.drawable.sabarmatiashram3,R.drawable.sabarmatiashram4,R.drawable.sabarmatiashram5,R.drawable.sabarmatiashram6,R.drawable.sabarmatiashram7,R.drawable.sabarmatiashram8,R.drawable.sabarmatiashram9} ;
        final int[] HutheesingJainTemple = {R.drawable.hutheesingtemple_main,R.drawable.hutheesingtemple1,R.drawable.hutheesingtemple2,R.drawable.hutheesingtemple3,R.drawable.hutheesingtemple4,R.drawable.hutheesingtemple6,R.drawable.hutheesingtemple7,R.drawable.hutheesingtemple8,R.drawable.hutheesingtemple9} ;
        final int[] BhadraFort = {R.drawable.bhadrafort_main,R.drawable.bhadrafort1,R.drawable.bhadrafort2,R.drawable.bhadrafort3,R.drawable.bhadrafort4,R.drawable.bhadrafort5,R.drawable.bhadrafort5,R.drawable.bhadrafort6,R.drawable.bhadrafort7} ;

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        final ArrayList<tittle_list_object> HistoricalMonument = new ArrayList<>();

        HistoricalMonument.add(new tittle_list_object(getString(R.string.bai_harir_vav), 4.4F,"Hanumansingh Rd, Haripura, Asarwa, Ahmedabad, Gujarat 380016","11am","7pm","","geo:23.040655,72.605727?z=23",BaiHarirVav,"Bai Harir Sultani Stepwell is a stepwell in Asarwa area 15 km off Ahmedabad, Gujarat, India."));
        HistoricalMonument.add(new tittle_list_object(getString(R.string.sidi_saiyyed_mosque), 4.6F,"Bhadra Rd, Opposite Electricity House, Old City, Gheekanta, Lal Darwaja, Ahmedabad, Gujarat 380001","","","","geo:23.0271,72.5810?z=23",SidiSaiyyedMosque,"The Sidi Saiyyed Mosque, popularly known as Sidi Saiyyid ni Jali locally, built in 1572-73 AD, is one of the most famous mosques of Ahmedabad, a city in the state of Gujarat, India."));
        HistoricalMonument.add(new tittle_list_object(getString(R.string.sabarmati_ashram), 4.6F,"Gandhi Smarak Sangrahalaya, Ashram Rd, Ahmedabad, Gujarat 380027","10am","5pm","079 2755 7277","geo:23.0608,72.5809?z=23",SabarmatiAshram,"Sabarmati Ashram is located in the Sabarmati suburb of Ahmedabad, Gujarat, adjoining the Ashram Road, on the banks of the River Sabarmati, 4 miles from the town hall. This was one of the many residences of Mahatma Gandhi who lived at Sabarmati and Sevagram when he was not travelling across India or in prison."));
        HistoricalMonument.add(new tittle_list_object(getString(R.string.hutheesing_jain_temple), 4.6F,"Hutheesing Jain Temple, Shahibaug Rd, Bardolpura, Madhupura, Ahmedabad, Gujarat 380004","7am","8pm","","geo:23.0411,72.5895?z=23",HutheesingJainTemple,"Hutheesing Temple is the best known Jain temple in Ahmedabad in Gujarat, India. It was constructed in 1848."));
        HistoricalMonument.add(new tittle_list_object(getString(R.string.bhadra_fort), 3.5F,"Bhadra Rd, Old City, Lal Darwaja, Ahmedabad, Gujarat 380001","24hrs","","","geo:23.0240,72.5808?z=23",BhadraFort,"Bhadra Fort is situated in the walled city area of Ahmedabad, India. It was built by Ahmad Shah I in 1411. With its well carved royal palaces, mosques, gates and open spaces, it was renovated in 2014 by Ahmedabad Municipal Corporation and Archaeological Survey of India as a cultural centre for the city."));

        tittle_list_adapter adapter = new tittle_list_adapter(getActivity(), HistoricalMonument, R.color.white);

        ListView listView = (ListView) rootView.findViewById(R.id.common_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tittle_list_object tittle_List_object = HistoricalMonument.get(position);

                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(getContext(),CommonContentActivity.class);

                Bundle b = new Bundle();
                b.putFloat("rating" , tittle_List_object.getRating() );
                b.putString("tittle" , tittle_List_object.getLocation_tittle());
                b.putInt("mImageResourceId",tittle_List_object.getImageResourceId());
                b.putString("address",tittle_List_object.getAddress());
                b.putString("opens",tittle_List_object.getOpens());
                b.putString("closes",tittle_List_object.getCloses());
                b.putString("contact",tittle_List_object.getContact());
                b.putString("geoLocation",tittle_List_object.getGeoLocation());
                b.putIntArray("location_photos", tittle_List_object.getPhoto_array());
                b.putString("about",tittle_List_object.getAbout());
                intent.putExtras(b) ;
                // Start the new activity
                startActivity(intent);

            }
        });

        return rootView;
    }
}