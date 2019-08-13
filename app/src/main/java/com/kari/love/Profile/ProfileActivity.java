package com.kari.love.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.kari.love.R;
import com.kari.love.Utils.BottomNavigationViewHelper;
import com.kari.love.Utils.GridImageAdapter;
import com.kari.love.Utils.UniversalImageLoader;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM=4;
    private static final int NUM_GRID_COLUMS = 3;

    private Context mcontext = ProfileActivity.this;

    private ProgressBar mprogressBar;
    private ImageView profilephoto;
    private ImageView coverphoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: Started");


        mprogressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mprogressBar.setVisibility(View.GONE);

        ImageView img = (ImageView) findViewById(R.id.pro_sett);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Profile Settings Activity");
                Intent i = new Intent(mcontext, AccountSettingsActivity.class);
                startActivity(i);
            }
        });

                                                                                //Main functiocalls here
        setUpBottomNavigationView();
        //setUpToolbar();
        setUpActivityWidgets();
        setProfileImage();
        setCoverImage();

        tempGridSetup();
    }



    private void tempGridSetup(){
        ArrayList<String> imgURLs= new ArrayList<>();
        imgURLs.add("https://i.pinimg.com/originals/14/93/71/149371f8a8a4df631bbe2e9fce928bf9.jpg");
        imgURLs.add("http://bsmedia.business-standard.com/_media/bs/img/article/2017-04/07/full/1491585070-1733.jpg");
        imgURLs.add("https://img.cricketworld.com/images/f-041845/raina.jpg");
        imgURLs.add("http://im.rediff.com/cricket/2014/aug/28sunnyg1.jpg");
        imgURLs.add("https://in.bookmyshow.com/entertainment-news/wp-content/uploads/2018/03/suresh-raina-Highest-rungetter-in-ipl.jpg");
        imgURLs.add("https://spiderimg.amarujala.com/assets/images/2017/05/13/750x506/suresh-raina_1494667793.jpeg");
        imgURLs.add("http://tyronesystems.com/cwc/wp-content/uploads/2015/04/suraish-raina.jpg");
        imgURLs.add("https://st3.cricketcountry.com/wp-content/uploads/2016/04/VIVO-IPL-trophy-showcased-during-the-VIVO-IPL-trophy-tour-in-Hyderabad-on-March-20-201612.jpg");
        imgURLs.add("https://st3.cricketcountry.com/wp-content/uploads/2015/04/hennai-Super-Kings-batsman-Suresh-Raina-in-action-during-47th-match-of-IPL-2014-between-Chennai-Super-Kings-and-Kolkata-Kni.jpg");
        imgURLs.add("https://english.cdn.zeenews.com/sites/default/files/2018/04/28/681881-rainacsktwitter970.jpg");
        imgURLs.add("https://image3.mouthshut.com/images/Restaurant/Photo/-71124_6945.jpg");
        imgURLs.add("https://www.hdwallpapersfreedownload.com/uploads/large/cities/india-hd-background.jpg");

        setUpImageGrid(imgURLs);
    }

    private void setUpImageGrid(ArrayList<String> imgURLs){
        GridView gridView = findViewById(R.id.gridView);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(mcontext, R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);
    }


    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: Setting profile photo");
        String imgeURL = "english.cdn.zeenews.com/sites/default/files/2018/04/28/681881-rainacsktwitter970.jpg";
        UniversalImageLoader.setImage(imgeURL, profilephoto, mprogressBar, "https://");
    }

    private void setCoverImage(){
        Log.d(TAG, "setProfileImage: Setting Cover photo");
        String imgsURL = "media.gettyimages.com/photos/cricket-batsman-hitting-ball-during-cricket-match-in-stadium-picture-id518022060?s=612x612";
        UniversalImageLoader.setImage(imgsURL, coverphoto, mprogressBar, "https://");
    }

    private void setUpActivityWidgets(){
        mprogressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mprogressBar.setVisibility(View.GONE);
        profilephoto = (ImageView) findViewById(R.id.profile_photo);
        coverphoto = (ImageView) findViewById(R.id.cover_photo);
    }

    private void setUpToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Navigating to Account settings");
                Intent intent = new Intent(mcontext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });

    }




    /**bottom NavigationView**/
    private void setUpBottomNavigationView(){
        Log.d(TAG, "setUpBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mcontext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


}
