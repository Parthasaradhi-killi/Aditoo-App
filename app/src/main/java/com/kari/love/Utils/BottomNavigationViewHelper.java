package com.kari.love.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.kari.love.Aditoo.AditooActivity;
import com.kari.love.Bus.BusActivity;
import com.kari.love.Events.EventsActivity;
import com.kari.love.Home.MainActivity;
import com.kari.love.Profile.ProfileActivity;
import com.kari.love.R;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up bottom navigation view");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){

                    case R.id.house:
                        Intent i1 = new Intent(context, MainActivity.class);                  //ACTIVITY NUM=0
                        context.startActivity(i1);
                        break;

                    case R.id.bus:
                        Intent i2= new Intent(context, BusActivity.class);                    //ACTIVITY NUM=1
                        context.startActivity(i2);
                        break;

                    case R.id.aditoo:
                        Intent i3 = new Intent(context, AditooActivity.class);                //ACTIVITY NUM=2
                        context.startActivity(i3);
                        break;

                    case R.id.events:
                        Intent i4= new Intent(context, EventsActivity.class);                 //ACTIVITY NUM=3
                        context.startActivity(i4);
                        break;

                    case R.id.profile:
                        Intent i5 = new Intent(context, ProfileActivity.class);               //ACTIVITY NUM=4
                        context.startActivity(i5);
                        break;
                }

                return false;
            }
        });
    }
}
