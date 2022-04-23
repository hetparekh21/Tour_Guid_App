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


public class ArtAndCultureFragment extends Fragment {

    public ArtAndCultureFragment() {
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

        /* TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */

        final int[]AhmedabadNiGufa = {R.drawable.ahmedabadnigufa_main,R.drawable.ahmedabadnigufa1,R.drawable.ahmedabadnigufa2,R.drawable.ahmedabadnigufa3,R.drawable.ahmedabadnigufa4,R.drawable.ahmedabadnigufa5,R.drawable.ahmedabadnigufa6,R.drawable.ahmedabadnigufa7,R.drawable.ahmedabadnigufa8,R.drawable.ahmedabadnigufa9};
        final int[] SnaskarKendra = {R.drawable.sanskarkendra_main,R.drawable.sanskarkendra1,R.drawable.sanskarkendra2,R.drawable.sanskarkendra3,R.drawable.sanskarkendra4,R.drawable.sanskarkendra5,R.drawable.sanskarkendra6,R.drawable.sanskarkendra7,R.drawable.sanskarkendra8};
        final int[] LalbhaiDalpatbhaiMuseum = {R.drawable.ldm_main,R.drawable.ldm1,R.drawable.ldm2,R.drawable.ldm3,R.drawable.ldm4,R.drawable.ldm5,R.drawable.ldm6,R.drawable.ldm7,R.drawable.ldm8,R.drawable.ldm9} ;
        final int[] TheCalicoMuseumOfTextiles = {R.drawable.tcmot_main,R.drawable.tcmot1,R.drawable.tcmot2,R.drawable.tcmot3,R.drawable.tcmot4,R.drawable.tcmot5,R.drawable.tcmot6,R.drawable.tcmot7,R.drawable.tcmot8,R.drawable.tcmot8} ;
        final int[] AutoWorldVintageCarMuseum = {R.drawable.awvcm_main,R.drawable.awvcm1,R.drawable.awvcm2,R.drawable.awvcm3,R.drawable.awvcm4,R.drawable.awvcm5,R.drawable.awvcm6,R.drawable.awvcm7,R.drawable.awvcm8,R.drawable.awvcm9} ;
        final ArrayList<tittle_list_object> ArtAndCulture = new ArrayList<>();

        ArtAndCulture.add(new tittle_list_object(getString(R.string.ahmedabad_ni_gufa),4.3F,"Kasturbhai Lalbhai Campus Opp Gujarat University campus, CEPT campus, Navrangpura, Ahmedabad, Gujarat 380009","4pm","8pm","079 26308698","geo:23.0363,72.5498?z=23",AhmedabadNiGufa,"Amdavad ni Gufa is an underground art gallery in Ahmedabad, India. Designed by the architect Balkrishna Vithaldas Doshi, it exhibits works of the Indian artist Maqbool Fida Husain. The gallery represents a unique juxtaposition of architecture and art. The cave-like underground structure has a roof made of multiple interconnected domes, covered with a mosaic of tiles. On the inside, irregular tree-like columns support the domes. It was earlier known as Husain-Doshi ni Gufa. There are facilities for special painting exhibitions and for projecting films. Gardens and a café are located above ground."));
        ArtAndCulture.add(new tittle_list_object(getString(R.string.sanskar_kendra), 4.2F,"Bhagtacharya Road, Near Sardar Patel, Bridge, Paldi, Ahmedabad, Gujarat 380006","","","079 2657 8369","geo:23.0131,72.5693?z=23",SnaskarKendra,"Sanskar Kendra is a museum at Ahmedabad, India, designed by the architect Le Corbusier. It is a city museum depicting history, art, culture and architecture of Ahmedabad. Another Patang Kite Museum is there which includes a collection of kites, photographs, and other artifacts."));
        ArtAndCulture.add(new tittle_list_object(getString(R.string.lalbhai_dalpatbhai_museum), 4.5F,"Gujarat University Clock Tower, L.D. Institute of Indology Campus, opp. L.D. Engineering Hostel, Navrangpura, Ahmedabad, Gujarat 380009","","","079 2630 6883","geo:23.0331,72.5499?z=23",LalbhaiDalpatbhaiMuseum,"Lalbhai Dalpatbhai Museum, abbreviated L. D. Museum, is a museum of Indian sculptures, bronzes, manuscripts, paintings, drawings, miniature paintings, woodwork, bead work and ancient and contemporary coins in Ahmedabad, Gujarat, India."));
        ArtAndCulture.add(new tittle_list_object(getString(R.string.the_calico_museum_of_textiles), 4.3F,"The Retreat, Airport Rd, Opp. Rani Sati Mandir, Jain Colony, Shahibag, Ahmedabad, Gujarat 380004","","","079 2286 5995","geo:23.0543,72.5922?z=23",TheCalicoMuseumOfTextiles,"The Calico Museum of Textiles is located in the city of Ahmedabad in the state of Gujarat in western India. The museum is managed by the Sarabhai Foundation."));
        ArtAndCulture.add(new tittle_list_object(getString(R.string.auto_world_vintage_car_museum), 4.4F,"Dastan Estate, Service Rd, Nikol, Kathwada, Gujarat 382430","8am","9pm","","geo:23.0573,72.6873?z=23",AutoWorldVintageCarMuseum,"Open-air museum showcasing high-end vintage automobiles, carriages, motorcycles & other vehicles."));

        tittle_list_adapter adapter = new tittle_list_adapter(getActivity(), ArtAndCulture, R.color.white);
//        design_default_color_background
        ListView listView = (ListView) rootView.findViewById(R.id.common_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tittle_list_object tittle_List_object = ArtAndCulture.get(position);

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