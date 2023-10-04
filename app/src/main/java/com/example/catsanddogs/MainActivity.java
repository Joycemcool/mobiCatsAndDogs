package com.example.catsanddogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.catsanddogs.fragments.CatsFragment;
import com.example.catsanddogs.fragments.DogsFragment;
import com.google.android.material.navigation.NavigationBarView;
import com.example.catsanddogs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private DogsFragment dogsFragment;
    private CatsFragment catsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        NavigationBarView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.navigation_Dogs) {

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frameLayout, dogsFragment)
                            //.replace(R.id.frameLayout,forecastFragment)
                            .commit();
                    return true;
                }

                if(itemId == R.id.navigation_Cats){

                    getSupportFragmentManager()
                            .beginTransaction()
                            //.replace(R.id.frameLayout,currentFragment)
                            .replace(R.id.frameLayout,catsFragment)
                            .commit();
                    return true;
                }
                return false;
            }
        });//end select listener

        //Setup Fragments
       // Bundle bundle = new Bundle();
//        bundle.putSerializable("weather",weather);
        dogsFragment = new DogsFragment();
        //dogsFragment.setArguments(bundle);

        catsFragment=new CatsFragment();

        //bottomNavigationView.setSelectedItemId(R.id.navigation_Dogs);

    }//end oncreate

} //end class