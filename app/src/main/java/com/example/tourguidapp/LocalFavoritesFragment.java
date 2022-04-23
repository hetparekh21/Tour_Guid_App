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

public class LocalFavoritesFragment extends Fragment {

    public LocalFavoritesFragment() {
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

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */
        final int[] ScienceCity = {R.drawable.sc_main,R.drawable.sc1,R.drawable.sc2,R.drawable.sc3,R.drawable.sc4,R.drawable.sc5,R.drawable.sc6,R.drawable.sc7,R.drawable.sc8,R.drawable.sc9};
        final int[] KankariaLake = {R.drawable.kkl_main,R.drawable.kkl1,R.drawable.kkl2,R.drawable.kkl3,R.drawable.kkl4,R.drawable.kkl5,R.drawable.kkl6,R.drawable.kkl7,R.drawable.kkl8,R.drawable.kkl9} ;
        final int[] Lawgarden = {R.drawable.lawgarden_main,R.drawable.lawgarden1,R.drawable.lawgarden2,R.drawable.lawgarden3,R.drawable.lawgarden4,R.drawable.lawgarden5,R.drawable.lawgarden6,R.drawable.lawgarden7,R.drawable.lawgarden8,R.drawable.lawgarden9} ;
        final int[] VastrapurLake = {R.drawable.vl_main,R.drawable.vl1,R.drawable.vl2,R.drawable.vl4,R.drawable.vl5,R.drawable.vl6} ;
        final int[] SabarmatiRiverfront= {R.drawable.sabarmatiriverfront_main,R.drawable.sabarmatiriverfront_1,R.drawable.sabarmatiriverfront_2,R.drawable.sabarmatiriverfront_3,R.drawable.sabarmatiriverfront_4,R.drawable.sabarmatiriverfront_5,R.drawable.sabarmatiriverfront_5,R.drawable.sabarmatiriverfront_6,R.drawable.sabarmatiriverfront_7,R.drawable.sabarmatiriverfront_8,R.drawable.sabarmatiriverfront_9} ;

        final ArrayList<tittle_list_object> LocalFavorites = new ArrayList<>();

        LocalFavorites.add(new tittle_list_object(getString(R.string.science_city), 4.1F,"3FJW+339, Thaltej, Ahmedabad, Gujarat 380060","","","","geo:23.0714,72.5168?z=23",ScienceCity,"Gujarat Science City is a science education and entertainment centre located in Ahmedabad, Gujarat, India. Opened in 2002, it has an IMAX 3D theatre; exhibitions on science, space, energy, life sciences, plants, nature and robotics; an aquarium, an aviary and a butterfly park; as well as other facilities."));
        LocalFavorites.add(new tittle_list_object(getString(R.string.kankaria_lake), 4.5F,"Kankaria Lake , Kankaria , Ahmedabad, Gujarat 380002","","","","geo:23.0063,72.6026?z=15",KankariaLake,"Kankaria Lake is the second largest lake in Ahmedabad, Gujarat, India. It is located in the south-eastern part of the city, in the Maninagar area. It was completed in 1451 during the reign of Sultan Qutb-ud-Din Ahmad Shah II though its origin is placed in the Chaulukya period sometimes."));
        LocalFavorites.add(new tittle_list_object(getString(R.string.law_garden), 4.3F,"Netaji Rd, Maharashtra Society, Ellisbridge, Ahmedabad, Gujarat 380009","5am","10pm","","geo:23.0273,72.5607",Lawgarden,"Law Garden is a public garden in the city of Ahmedabad, India. The market outside the garden is very famous for the handicraft goods sold by local people. The road at the side of the garden is filled with street hawkers selling a variety of food items"));
        LocalFavorites.add(new tittle_list_object(getString(R.string.vastrapur_lake), 4.2F,"Vastrapur, Ahmedabad, Gujarat 380052","","","","geo:23.0384,72.5288?z=18",VastrapurLake,"Vastrapur Lake is situated in western part of Ahmedabad. It is officially named after Narsinh Mehta. The lake was beautified by the AMC after 2002 and has since become a popular spot in the city. Every weekend, many people visit this lake. It currently boasts an open-air theater and children's park."));
        LocalFavorites.add(new tittle_list_object(getString(R.string.sabarmati_riverfront), 4.6F,"Sabarmati Riverfront Walkway East, Lal Darwaja, Ahmedabad, Gujarat 380001","9am","9pm","079 2658 0430","geo:23.0235,72.5766?z=23",SabarmatiRiverfront,"Sabarmati Riverfront is a waterfront being developed along the banks of Sabarmati river in Ahmedabad, India. Proposed in the 1960s, the construction began in 2005. Since 2012, the waterfront is gradually opened to public as and when facilities are constructed and various facilities are actively under construction."));

        tittle_list_adapter adapter = new tittle_list_adapter(getActivity(), LocalFavorites, R.color.white);

        ListView listView = (ListView) rootView.findViewById(R.id.common_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tittle_list_object tittle_List_object = LocalFavorites.get(position);

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